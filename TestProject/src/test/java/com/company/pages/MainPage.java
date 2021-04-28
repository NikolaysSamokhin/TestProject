package com.company.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.company.annotations.ElementTitle;
import com.company.annotations.PageTitle;

import static com.codeborne.selenide.Selenide.$x;

@PageTitle("Главная_страница_Яндекса")
public class MainPage extends Base {

    private final SelenideElement serviceBlock = $x("//ul[@class='services-new__list']");

    @ElementTitle("Список сервисов")
    private final ElementsCollection serviceElements = serviceBlock.$$x(".//li");

    @Override
    public void pageIsDisplayed() {
     allElementsAreVisible(serviceElements);
    }

}
