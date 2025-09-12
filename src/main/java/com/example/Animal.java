package com.example;

import java.util.List;

/**
 * Базовый класс для всех животных.
 * Содержит общие методы для получения информации о пище и семействах животных.
 */
public class Animal {

    /**
     * Возвращает список пищи в зависимости от вида животного.
     * @param animalKind вид животного ("Травоядное" или "Хищник")
     * @return список продуктов питания
     * @throws Exception если передан неизвестный вид животного
     */
    public List<String> getFood(String animalKind) throws Exception {
        if ("Травоядное".equals(animalKind)) {
            return List.of("Трава", "Различные растения");
        } else if ("Хищник".equals(animalKind)) {
            return List.of("Животные", "Птицы", "Рыба");
        } else {
            throw new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }

    /**
     * Возвращает общую информацию о семействах животных.
     * @return строка с перечислением семейств
     */
    public String getFamily() {
        return "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    }
}