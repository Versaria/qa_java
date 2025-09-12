package com.example;

import java.util.List;

/**
 * Класс, представляющий льва Алекса из мультфильма "Мадагаскар".
 * Наследуется от класса Lion и добавляет специфические методы для Алекса.
 */
public class Alex extends Lion {

    /**
     * Конструктор, всегда передающий "Самец" в родительский класс.
     * @param predator зависимость для получения информации о пище и котятах
     * @throws Exception если возникает ошибка при создании объекта
     */
    public Alex(Predator predator) throws Exception {
        super("Самец", predator);
    }

    /**
     * Возвращает список друзей Алекса.
     * @return список имен друзей
     */
    public List<String> getFriends() {
        return List.of("Марти", "Глория", "Мелман");
    }

    /**
     * Возвращает место жительства Алекса.
     * @return строка с названием места жительства
     */
    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    /**
     * Переопределенный метод, так как у Алекса нет котят.
     * @return всегда 0
     */
    @Override
    public int getKittens() {
        return 0;
    }
}