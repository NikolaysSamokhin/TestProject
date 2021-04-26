package com.company.stepDefinitions;


import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.company.endpoints.YandexEndpoints;
import com.company.pages.Base;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

@Log4j
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

    @SneakyThrows
    @Тогда("выбрать элемент {string} из коллекции {string} на странице {string}")
    public void elementsCollectionAreVisible(String element, String collectionName, String pageName) {
        getElementCollection(pageName, collectionName).filter(Condition.text(element)).first()
                .click(ClickOptions.usingDefaultMethod());
    }

    @Тогда("на текущей странице проверить, что отображается {string}")
    public void checkVisibleBlock(String elementName) {
        getElement(elementName).shouldBe(Condition.visible, Duration.ofSeconds(5));
    }


    @И("на текущей странице пользователь выбирает радиобаттон типа {string}")
    public void chooseRadio(String radioName) {
        SelenideElement element = getElement(radioName);
        if (!element.isSelected()) {
            element.click();
        }
    }

}
