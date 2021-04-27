package com.company.stepDefinitions;

import com.company.pages.Base;
import io.cucumber.java.ru.Когда;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;

@Log4j
public class SearchingImagesSteps extends Base {

    @SneakyThrows
    @Когда("загрузить картинку {string}")
    public void uploadPicture(String namePicture) {
    }

    @SneakyThrows
    @Когда("нажать на кнопку поиска по изображению")
    public void clickOnSearching() {
     getElement("Кнопка_поиска_по_изображению").click();
    }
}
