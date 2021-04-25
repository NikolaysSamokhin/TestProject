package com.company.endpoints;

/**
 * Перечисление эндпоинтов сервиса BSO
 */
public enum ApiEndpoints {
  VALID_ENDPOINT("bso/invalid/series/{series}");

  private String value;

  ApiEndpoints(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
