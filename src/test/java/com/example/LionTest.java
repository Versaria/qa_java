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
 */
@ExtendWith(MockitoExtension.class)
class LionTest {
    @Mock
    Predator predator; // Мок-объект интерфейса Predator

    /**
     * Тест наличия гривы у самца.
     */
    @Test
    void testDoesHaveManeForMale() throws Exception {
        Lion lion = new Lion("Самец", predator);
        assertTrue(lion.doesHaveMane());
    }

    /**
     * Тест отсутствия гривы у самки.
     */
    @Test
    void testDoesHaveManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", predator);
        assertFalse(lion.doesHaveMane());
    }

    /**
     * Тест исключения при недопустимом поле.
     */
    @Test
    void testInvalidSex() {
        Exception exception = assertThrows(Exception.class, () ->
                new Lion("Неизвестный", predator));
        assertTrue(exception.getMessage().contains("Используйте допустимые значения пола животного"));
    }

    /**
     * Тест метода getKittens.
     */
    @Test
    void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", predator);
        when(predator.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
        verify(predator, times(1)).getKittens();
    }

    /**
     * Тест метода getFood.
     */
    @Test
    void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", predator);
        when(predator.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
        verify(predator, times(1)).getFood("Хищник");
    }

    /**
     * Дополнительный тест метода getKittens с мок-объектом.
     */
    @Test
    void testGetKittensWithMock() throws Exception {
        Lion lion = new Lion("Самец", predator);
        when(predator.getKittens()).thenReturn(3);
        assertEquals(3, lion.getKittens());
        verify(predator, times(1)).getKittens();
    }

    /**
     * Тест для проверки исключения в конструкторе.
     */
    @Test
    void testLionConstructorWithInvalidSex() {
        Exception exception = assertThrows(Exception.class, () ->
                new Lion("Invalid", predator));
        assertTrue(exception.getMessage().contains("Используйте допустимые значения пола животного"));
    }

    /**
     * Тест для проверки точного сообщения исключения.
     */
    @Test
    void testLionConstructorExceptionMessage() {
        Exception exception = assertThrows(Exception.class, () ->
                new Lion("Invalid", predator));
        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }
}