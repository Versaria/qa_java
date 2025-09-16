package com.example;

import java.util.List;

/**
 * Класс, представляющий семейство кошачьих.
 * Наследуется от класса Animal и реализует интерфейс Predator.
 * Содержит специфические методы для семейства кошачьих.
 */
public class Feline extends Animal implements Predator {

    /**
     * Реализация метода из интерфейса Predator.
     * Возвращает список мяса, которое ест хищник.
     * @return список продуктов питания для хищников
     * @throws Exception если возникает ошибка при получении пищи
     */
    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    /**
     * Переопределение метода для возврата конкретного семейства.
     * @return название семейства "Кошачьи"
     */
    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    /**
     * Возвращает количество котят по умолчанию.
     * @return количество котят (по умолчанию 1)
     */
    public int getKittens() {
        return getKittens(1);
    }

    /**
     * Возвращает указанное количество котят.
     * @param kittensCount количество котят
     * @return переданное количество котят
     */
    public int getKittens(int kittensCount) {
        return kittensCount;
    }

}