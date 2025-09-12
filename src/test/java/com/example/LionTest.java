package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Тесты для класса Lion.
 * Использует Mockito для создания мок-объектов.
 * Каждый тест проверяет только одну функциональность в соответствии с принципом "один тест - одна проверка".

 * Изменения:
 * 1. Разделен тест с двумя проверками на отдельные unit-тесты
 * 2. Все моки Predator заменены на Feline
 */
@ExtendWith(MockitoExtension.class)
class LionTest {
    @Mock
    Feline feline; // Мок-объект класса Feline

    /**
     * Тест наличия гривы у самца.
     * Проверяет только наличие гривы у самца.
     */
    @Test
    void testDoesHaveManeForMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    /**
     * Тест отсутствия гривы у самки.
     * Проверяет только отсутствие гривы у самки.
     */
    @Test
    void testDoesHaveManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    /**
     * Тест исключения при недопустимом поле.
     * Проверяет только факт возникновения исключения.
     */
    @Test
    void testInvalidSexThrowsException() {
        assertThrows(Exception.class, () -> new Lion("Неизвестный", feline));
    }

    /**
     * Тест сообщения исключения при недопустимом поле.
     * Проверяет только содержание сообщения исключения.
     */
    @Test
    void testInvalidSexExceptionMessage() {
        Exception exception = assertThrows(Exception.class, () ->
                new Lion("Неизвестный", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }

    /**
     * Тест метода getKittens.
     * Проверяет только возврат корректного количества котят.
     */
    @Test
    void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
        verify(feline, times(1)).getKittens();
    }

    /**
     * Тест метода getFood.
     * Проверяет только возврат корректного списка пищи.
     */
    @Test
    void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
        verify(feline, times(1)).getFood("Хищник");
    }
}