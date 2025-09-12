package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для класса Animal.
 * Покрываем все методы и ветки условий.
 */
class AnimalTest {

    /**
     * Тест метода getFood для травоядных животных.
     */
    @Test
    void testGetFoodForHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> expectedFood = List.of("Трава", "Различные растения");
        assertEquals(expectedFood, animal.getFood("Травоядное"));
    }

    /**
     * Тест метода getFood для хищников.
     */
    @Test
    void testGetFoodForPredator() throws Exception {
        Animal animal = new Animal();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, animal.getFood("Хищник"));
    }

    /**
     * Тест метода getFood для неизвестного типа животного.
     */
    @Test
    void testGetFoodForUnknownType() {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () ->
                animal.getFood("Неизвестный"));
        assertTrue(exception.getMessage().contains("Неизвестный вид животного"));
    }

    /**
     * Тест метода getFamily.
     */
    @Test
    void testGetFamily() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }

    /**
     * Тест точного сообщения исключения для метода getFood.
     */
    @Test
    void testGetFoodExceptionMessage() {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () ->
                animal.getFood("Неизвестный"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }
}