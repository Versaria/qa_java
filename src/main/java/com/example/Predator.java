package com.example;

import java.util.List;

/**
 * Интерфейс для хищных животных.
 * Определяет методы, которые должны реализовать все хищники.
 */
public interface Predator {

    /**
     * Возвращает список мяса, которое ест хищник.
     * @return список продуктов питания
     * @throws Exception если возникает ошибка при получении пищи
     */
    List<String> eatMeat() throws Exception;

    /**
     * Возвращает количество котят по умолчанию.
     * @return количество котят (по умолчанию 1)
     */
    int getKittens();

    /**
     * Возвращает указанное количество котят.
     * @param kittensCount количество котят
     * @return переданное количество котят
     */
    int getKittens(int kittensCount);

    /**
     * Возвращает пищу в зависимости от типа животного.
     * @param type тип животного
     * @return список продуктов питания
     * @throws Exception если передан неизвестный тип животного
     */
    List<String> getFood(String type) throws Exception;
}