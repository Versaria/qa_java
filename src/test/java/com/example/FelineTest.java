package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для класса Feline.
 * Класс Feline наследует от Animal и реализует интерфейс Predator.
 * Тестируем все публичные методы и наследуемое поведение.
 */
class FelineTest {

    /**
     * Тест метода eatMeat - проверяет, что хищник возвращает правильный список пищи.
     */
    @Test
    void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat(),
                "Метод eatMeat должен возвращать правильный список еды для хищника");
    }

    /**
     * Тест метода getFamily - проверяет возврат правильного семейства.
     */
    @Test
    void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily(),
                "Метод getFamily должен возвращать 'Кошачьи'");
    }

    /**
     * Тест метода getKittens без параметров - проверяет значение по умолчанию.
     */
    @Test
    void testGetKittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens(),
                "Метод getKittens без параметров должен возвращать 1");
    }

    /**
     * Тест метода getKittens с параметром - проверяет возврат указанного количества.
     */
    @Test
    void testGetKittensWithCount() {
        Feline feline = new Feline();
        int kittensCount = 3;
        assertEquals(kittensCount, feline.getKittens(kittensCount),
                "Метод getKittens с параметром должен возвращать переданное количество котят");
    }

    /**
     * Тест метода getFood с неизвестным типом животного - проверяет исключение.
     */
    @Test
    void testGetFoodWithUnknownType() {
        Feline feline = new Feline();
        Exception exception = assertThrows(Exception.class, () ->
                feline.getFood("Неизвестный"));
        assertTrue(exception.getMessage().contains("Неизвестный вид животного"),
                "Сообщение об ошибке должно содержать информацию о неизвестном виде животного");
    }

    /**
     * Тест метода getFood с травоядным - проверяет возврат правильного списка пищи.
     */
    @Test
    void testGetFoodWithHerbivore() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Трава", "Различные растения");
        assertEquals(expectedFood, feline.getFood("Травоядное"),
                "Метод getFood должен возвращать правильный список еды для травоядного");
    }
}