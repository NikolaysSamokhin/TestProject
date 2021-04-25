package com.company.stepDefinitions;

import base.Base;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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
                open();
                break;
        }
    }

    @SneakyThrows
    @Тогда("отображается страница {string}")
    public void всеЭлементыВидны(String pageName) {
        initPage(pageName);
        lastInitClass.getMethod("pageIsDisplayed", null).invoke(lastInitClass.newInstance());
    }

    @И("на текущей странице нажать на кнопку/ссылку {string}")
    public void clickBtnSetApplication(String elementName) {
        getElement(elementName).click();
    }

    @Тогда("на текущей странице проверить, что отображается {string}")
    public void checkVisibleBlock(String elementName) {
        getElement(elementName).shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    @И("на текущей странице пользователь нажимает на чекбокс {string}")
    public void chooseCheckbox(String checkboxName) {
        try {
            SelenideElement element = getElement(checkboxName);
            if (!element.isSelected()) {
                element.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(lastInitClass.getName());
        }

    }

    @И("на текущей странице пользователь выбирает радиобаттон типа {string}")
    public void chooseRadio(String radioName) {
        SelenideElement element = getElement(radioName);
        if (!element.isSelected()) {
            element.click();
        }
    }

}
