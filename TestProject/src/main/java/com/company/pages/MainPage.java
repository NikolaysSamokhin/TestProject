package com.company.pages;

import base.Base;
import com.codeborne.selenide.SelenideElement;
import com.company.annotations.ElementTitle;
import com.company.annotations.PageTitle;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Selenide.$x;

@Log4j
@PageTitle("Главная_страница")
public class MainPage extends Base {
    private final SelenideElement firstBlock = $x("//section/div[.//*[text()='Бесплатная регистрация бизнеса онлайн']]");
    @ElementTitle("Подробнее о пакетах услуг")
    private final SelenideElement fifthBlockOpenBtn = firstBlock.$x(".//a[text()='Подробнее о пакетах услуг']");




    public void fillSeventhBlock() {

    }

}
