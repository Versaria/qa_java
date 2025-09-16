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
 * Каждый тест проверяет только одну функциональность.
 */
@ExtendWith(MockitoExtension.class)
class LionTest {
    @Mock
    Feline feline;

    /**
     * Тест наличия гривы у самца.
     */
    @Test
    void testDoesHaveManeForMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    /**
     * Тест отсутствия гривы у самки.
     */
    @Test
    void testDoesHaveManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    /**
     * Тест исключения при недопустимом поле.
     */
    @Test
    void testInvalidSexThrowsException() {
        assertThrows(Exception.class, () -> new Lion("Неизвестный", feline));
    }

    /**
     * Тест сообщения исключения при недопустимом поле.
     */
    @Test
    void testInvalidSexExceptionMessage() {
        Exception exception = assertThrows(Exception.class, () ->
                new Lion("Неизвестный", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }

    /**
     * Тест возврата корректного количества котят.
     */
    @Test
    void testGetKittensReturnsCorrectValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    /**
     * Тест вызова метода getKittens у Feline.
     */
    @Test
    void testGetKittensCallsFeline() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        verify(feline, times(1)).getKittens();
    }

    /**
     * Тест возврата корректного списка пищи.
     */
    @Test
    void testGetFoodReturnsCorrectValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    /**
     * Тест вызова метода getFood у Feline.
     */
    @Test
    void testGetFoodCallsFeline() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        verify(feline, times(1)).getFood("Хищник");
    }
}