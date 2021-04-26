package com.company.endpoints;

public enum YandexEndpoints {
  MAIN_PAGE("https://yandex.ru/");

  private String value;

  YandexEndpoints(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
