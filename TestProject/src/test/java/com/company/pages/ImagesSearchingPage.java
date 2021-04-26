package com.company.pages;

import com.codeborne.selenide.SelenideElement;
import com.company.annotations.ElementTitle;
import com.company.annotations.PageTitle;
import lombok.extern.log4j.Log4j;

import static com.codeborne.selenide.Selenide.$x;

@Log4j
@PageTitle("Страница_поиска_картинок")
public class ImagesSearchingPage extends Base {

    private final SelenideElement searchImageBlock = $x("//form[@role='search']");

    @ElementTitle("Кнопка_загрузить_картинку")
    private final SelenideElement uploadButton = searchImageBlock.$x("//*[@aria-label='Поиск по изображению']");



}
