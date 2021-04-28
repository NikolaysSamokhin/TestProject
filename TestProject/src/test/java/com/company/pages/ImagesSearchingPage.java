package com.company.pages;

import com.codeborne.selenide.SelenideElement;
import com.company.annotations.ElementTitle;
import com.company.annotations.PageTitle;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

@PageTitle("Страница_поиска_по_изображению")
public class ImagesSearchingPage extends Base {
    private final List<SelenideElement> elementList;

    @ElementTitle("Блок_поиска_по_изображению")
    private final SelenideElement searchImageBlock = $x(".//form[@role='search']");

    @ElementTitle("Кнопка_поиска_по_изображению")
    private SelenideElement uploadButton = $x("//button[@aria-label='Поиск по изображению']");

    @ElementTitle("Згрузка_изображения_для_поиска")
    private SelenideElement inputSearchingImager = $x("//input[@name='upfile']");

    public ImagesSearchingPage() {
        elementList = Arrays.asList(searchImageBlock, uploadButton);
    }

    @SneakyThrows
    @Override
    public void pageIsDisplayed() {
        allElementsAreVisible(elementList);
    }
}
