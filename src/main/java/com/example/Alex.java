package com.example;

import java.util.List;

/**
 * Класс, представляющий льва Алекса из мультфильма "Мадагаскар".
 * Наследуется от класса Lion и добавляет специфические методы для Алекса.
 */
public class Alex extends Lion {

    /**
     * Конструктор, всегда передающий "Самец" в родительский класс.
     * @param feline зависимость для получения информации о пище
     * @throws Exception если возникает ошибка при создании объекта
     */
    public Alex(Feline feline) throws Exception {
        super("Самец", feline);
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