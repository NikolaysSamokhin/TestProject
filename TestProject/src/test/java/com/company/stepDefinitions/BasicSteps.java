package com.company.stepDefinitions;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.company.endpoints.YandexEndpoints;
import com.company.pages.Base;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import lombok.SneakyThrows;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class BasicSteps extends Base {

    @Дано("пользователь находится на главной странице {word}")
    public void onMainPage(String pageName) {
        switch (pageName) {
            case "Main":
                open(YandexEndpoints.MAIN_PAGE.getValue());
                break;
            default:
                System.out.println("Некорректное название страницы");
        }
    }

    @Тогда("выбрать элемент {string} из коллекции {string}")
    public void elementsCollectionAreVisible(String element, String collectionName) {
        getElementCollection(collectionName).filter(Condition.text(element)).first()
                .click(ClickOptions.usingDefaultMethod());
    }

    @И("на текущей странице нажать на кнопку/ссылку {string}")
    public void clickBtnSetApplication(String elementName) {
        getElement(elementName).click();
    }

    @Тогда("переключиться на вкладку {int}")
    public void switchTabBrowser(int tabNumber) {
        switchTab(tabNumber);
    }

    @И("на текущей странице пользователь выбирает радиобаттон типа {string}")
    public void chooseRadio(String radioName) {
        SelenideElement element = getElement(radioName);
        if (!element.isSelected()) {
            element.click();
        }
    }

    @SneakyThrows
    @Тогда("отображается страница {string}")
    public void allElementsAreVisible(String pageName) {
        initPage(pageName);
        lastInitClass.getMethod("pageIsDisplayed", null).invoke(lastInitClass.newInstance());
    }

    @SneakyThrows
    @Тогда("Текст в форме отображения {string} должен совпдать с примером {string}")
    public void checkText(String formName, String expectedText) {
        ElementsCollection elements = getElementCollection(formName);
        List<String> list = elements.stream().map(x -> x.text()).collect(Collectors.toList());

        assertThat(list).containsAnyOf(expectedText);
    }

    @И("загрузить картинку {string} для поиска через {string}")
    public void uploadPicture(String imageName, String formName) {
        SelenideElement element = getElement(formName);
        element.uploadFile(new File(System.getProperty("user.dir")
                + String.format("\\src\\test\\resources\\pictures\\/%s.jpg", imageName)));
    }
}
