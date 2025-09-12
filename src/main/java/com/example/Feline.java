package com.example;

import java.util.List;

/**
 * Класс кошачьих, наследуется от Animal и реализует интерфейс Predator.
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
    @Override
    public int getKittens() {
        return getKittens(1);
    }

    /**
     * Возвращает указанное количество котят.
     * @param kittensCount количество котят
     * @return переданное количество котят
     */
    @Override
    public int getKittens(int kittensCount) {
        return kittensCount;
    }

    /**
     * Возвращает пищу в зависимости от типа животного.
     * Использует метод родительского класса Animal.
     * @param type тип животного
     * @return список продуктов питания
     * @throws Exception если передан неизвестный тип животного
     */
    @Override
    public List<String> getFood(String type) throws Exception {
        return super.getFood(type);
    }
}