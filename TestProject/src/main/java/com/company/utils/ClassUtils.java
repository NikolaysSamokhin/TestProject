package com.company.utils;

import java.util.Random;

public class ClassUtils {
    /**
     * Метод для создания случайного числового значения с заданной разрядностью
     *
     * @param length разрядность случайного значения
     */
    public static String generateRandomNumber(int length) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        // первая цифра не может быть нулём
        for (int i = 0; i < length; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * Метод для создания случайной строки с заданным размером
     *
     * @param length размер случайного случайной
     */
    public static String generateRandomString(int length) {
        Random rand = new Random();
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        char letter = abc.charAt(rand.nextInt(abc.length()));

        StringBuilder sb = new StringBuilder();
        // первая цифра не может быть нулём
        for (int i = 0; i < length; i++) {
            sb.append(abc.charAt(rand.nextInt(abc.length())));
        }
        return sb.toString();
    }

    public static <T> T parseObject(Object o, Class<T> clazz) {
        return (T) o;
    }
}