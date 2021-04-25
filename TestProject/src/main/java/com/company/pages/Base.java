package base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.company.annotations.ElementTitle;
import com.company.annotations.PageTitle;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.Set;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;
import static org.apache.commons.lang3.StringUtils.substringAfter;

@Log4j
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

        log.error("Не найден элемент с именем: " + elementName);
        return null;
    }
    @SneakyThrows
    public void initPage(String pageName) {
        Set<Class<?>> annotated = new Reflections("pages").getTypesAnnotatedWith(PageTitle.class);
        lastInitClass = annotated.stream().filter(clazz -> clazz.getAnnotation(PageTitle.class)
                .value()
                .equalsIgnoreCase(pageName))
                .findFirst()
                .orElse(null);

        assert lastInitClass != null;
        lastInitialized = substringAfter(lastInitClass.toString(), "class ");
    }

    @SneakyThrows
    public SelenideElement getElement(String elementName) {
        Object elementByTitle = findElementByTitle(elementName);
        if (elementByTitle instanceof SelenideElement)
            return (SelenideElement) elementByTitle;
        else {
            log.error("Элемент не является SelenideElement");
            return null;
        }
    }


}
