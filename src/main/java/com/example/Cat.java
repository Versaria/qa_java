package com.example;

import java.util.List;

/**
 * Класс, представляющий кота.
 * Использует принцип инъекции зависимостей через конструктор.
 */
public class Cat {
    private final Predator predator; // Зависимость от интерфейса Predator

    /**
     * Конструктор с инъекцией зависимости.
     * @param predator зависимость для получения информации о пище
     */
    public Cat(Predator predator) {
        this.predator = predator;
    }

    /**
     * Возвращает звук, который издает кот.
     * @return строка "Мяу"
     */
    public String getSound() {
        return "Мяу";
    }

    /**
     * Возвращает пищу кота через интерфейс Predator.
     * @return список продуктов питания
     * @throws Exception если возникает ошибка при получении пищи
     */
    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }
}