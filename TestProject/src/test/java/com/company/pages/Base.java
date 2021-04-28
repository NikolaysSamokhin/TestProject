package com.company.pages;

import com.codeborne.selenide.*;
import com.company.annotations.ElementTitle;
import com.company.annotations.PageTitle;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;
import static org.apache.commons.lang3.StringUtils.substringAfter;

public abstract class Base {

    private static final Condition clickable = and("can be clicked", visible, enabled);
    public static final int ELEMENT_TIMEOUT_SECONDS = 15;

    static {
        Configuration.timeout = ELEMENT_TIMEOUT_SECONDS * 1000;
        Configuration.pageLoadTimeout = ELEMENT_TIMEOUT_SECONDS * 1000;
    }

    public Object lastInitialized;
    public Class<?> lastInitClass;

    @SneakyThrows
    private Object findElementByTitle(String elementName) {
        Field[] annotated = lastInitClass.getDeclaredFields();

        for (Field field : annotated) {
            ElementTitle annotation = field.getAnnotation(ElementTitle.class);
            if (annotation != null && annotation.value().equals(elementName)) {
                field.setAccessible(true);
                return field.get(page(lastInitClass));
            }
        }

        System.out.println("Не найден элемент с именем: " + elementName);
        return null;
    }

    @SneakyThrows
    public ElementsCollection getElementCollection(String elementName) {
        Object elementByTitle = findElementByTitle(elementName);
        if (elementByTitle instanceof ElementsCollection)
            return (ElementsCollection) elementByTitle;
        else {
            System.out.println("Элемент не является ElementsCollection");
            return null;
        }
    }

    public void initPage(String pageName) {
        Set<Class<?>> annotated = new Reflections("com/company/pages").getTypesAnnotatedWith(PageTitle.class);
        lastInitClass = annotated.stream().filter(clazz -> clazz.getAnnotation(PageTitle.class)
                .value()
                .equalsIgnoreCase(pageName))
                .findFirst()
                .orElse(null);

        assert lastInitClass != null;
        lastInitialized = substringAfter(lastInitClass.toString(), "class ");
    }

    public static void allElementsAreVisible(ElementsCollection elements) {
        elements.forEach(selenideElement -> selenideElement.shouldBe(visible));
    }

    public static void allElementsAreVisible(List<SelenideElement> elements) {
        elements.forEach(selenideElement -> selenideElement.shouldBe(visible));
    }

    public void pageIsDisplayed() {
    }

    ;

    public static void switchTab(int tab) {
        List<String> tabs = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());
        WebDriverRunner.getWebDriver().switchTo().window(tabs.get(tab));
    }

    public SelenideElement getElement(String elementName) {
        Object elementByTitle = findElementByTitle(elementName);
        if (elementByTitle instanceof SelenideElement)
            return (SelenideElement) elementByTitle;
        else {
            System.out.println("Элемент не является SelenideElement");
            return null;
        }
    }

}
