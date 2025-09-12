package com.example;

import java.util.List;

/**
 * Класс, представляющий кота.
 * Использует принцип инъекции зависимостей через конструктор.
 */
public class Cat {

    Predator predator;

    /**
     * Конструктор с инъекцией зависимости.
     * Принимает объект типа Feline, который реализует интерфейс Predator,
     * и сохраняет его для использования в методах класса.
     * @param feline зависимость для получения информации о пище кота
     */
    public Cat(Feline feline) {
        this.predator = feline;
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