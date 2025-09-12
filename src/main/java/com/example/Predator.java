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

}