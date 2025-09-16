package com.example;

import java.util.List;

/**
 * Класс, представляющий льва.
 * Использует принцип инъекции зависимостей через конструктор.
 * Зависимость Feline передается через конструктор, что обеспечивает
 * лучшую тестируемость и соблюдение принципа инверсии зависимостей.
 */
public class Lion {
    private final boolean hasMane;
    private final Feline feline; // Зависимость инжектируется через конструктор

    /**
     * Конструктор с инъекцией зависимости Feline.
     * @param sex пол льва ("Самец" или "Самка")
     * @param feline зависимость для получения информации о пище и котятах
     * @throws Exception если передан недопустимый пол
     */
    public Lion(String sex, Feline feline) throws Exception {
        this.feline = feline;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    /**
     * Возвращает количество котят через зависимость Feline.
     * @return количество котят
     */
    public int getKittens() {
        return feline.getKittens();
    }

    /**
     * Проверяет, есть ли у льва грива.
     * @return true если у льва есть грива (самец), false если нет (самка)
     */
    public boolean doesHaveMane() {
        return hasMane;
    }

    /**
     * Возвращает пищу льва через зависимость Feline.
     * Лев является хищником, поэтому используется соответствующая категория.
     * @return список продуктов питания
     * @throws Exception если возникает ошибка при получении пищи
     */
    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}