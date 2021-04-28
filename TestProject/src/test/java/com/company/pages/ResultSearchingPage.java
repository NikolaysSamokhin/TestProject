package com.company.pages;

import com.codeborne.selenide.ElementsCollection;
import com.company.annotations.ElementTitle;
import com.company.annotations.PageTitle;
import lombok.SneakyThrows;

import static com.codeborne.selenide.Selenide.$$x;

@PageTitle("Страница_отображения_результата")
public class ResultSearchingPage extends Base {

    @ElementTitle("Форма_отображения_результата")
    private final ElementsCollection result = $$x("//div[contains(text(), 'Кажется, на изображении')]" +
            "/parent::div//span[@class='Button2-Text']");

    @SneakyThrows
    @Override
    public void pageIsDisplayed() {
        allElementsAreVisible(result);
    }
}
