package com.company.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.company.annotations.ElementTitle;
import com.company.annotations.PageTitle;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

@Log4j
@PageTitle("Главная_страница_Яндекса")
public class MainPage extends Base {

    private final SelenideElement serviceBlock = $x("//ul[@class='services-new__list']");

    @ElementTitle("Список сервисов")
    private final ElementsCollection serviceElements = serviceBlock.$$x(".//li");

    public void pageIsDisplayed() {
     allElementsAreVisible(serviceElements);
    }

    public void clickOnService(String serviceName) {
        serviceElements.filterBy(text(serviceName));
    }

}
