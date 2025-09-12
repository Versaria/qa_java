package com.example;

import java.util.List;

/**
 * Класс, представляющий льва.
 * Использует принцип инъекции зависимостей через конструктор.
 */
public class Lion {
    private final boolean hasMane;
    private final Predator predator; // Зависимость от интерфейса Predator

    /**
     * Конструктор с инъекцией зависимости.
     * @param sex пол льва ("Самец" или "Самка")
     * @param predator зависимость для получения информации о пище и котятах
     * @throws Exception если передан недопустимый пол
     */
    public Lion(String sex, Predator predator) throws Exception {
        this.predator = predator;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    /**
     * Возвращает количество котят через зависимость Predator.
     * @return количество котят
     */
    public int getKittens() {
        return predator.getKittens();
    }

    /**
     * Проверяет, есть ли у льва грива.
     * @return true если у льва есть грива (самец), false если нет (самка)
     */
    public boolean doesHaveMane() {
        return hasMane;
    }

    /**
     * Возвращает пищу льва через зависимость Predator.
     * @return список продуктов питания
     * @throws Exception если возникает ошибка при получении пищи
     */
    public List<String> getFood() throws Exception {
        return predator.getFood("Хищник");
    }
}