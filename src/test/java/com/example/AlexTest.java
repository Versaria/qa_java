package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Тесты для класса Alex.
 * Использует Mockito для создания мок-объектов.

 * Изменения:
 * 1. Мок Predator заменен на Feline
 */
@ExtendWith(MockitoExtension.class)
class AlexTest {
    @Mock
    Feline feline; // Мок-объект класса Feline

    /**
     * Тест метода getFriends.
     * Проверяет только возврат корректного списка друзей.
     */
    @Test
    void testGetFriends() throws Exception {
        Alex alex = new Alex(feline);
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        assertEquals(expectedFriends, alex.getFriends());
    }

    /**
     * Тест метода getPlaceOfLiving.
     * Проверяет только возврат корректного места жительства.
     */
    @Test
    void testGetPlaceOfLiving() throws Exception {
        Alex alex = new Alex(feline);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    /**
     * Тест переопределенного метода getKittens.
     * Проверяет только возврат нуля котят.
     */
    @Test
    void testGetKittens() throws Exception {
        Alex alex = new Alex(feline);
        assertEquals(0, alex.getKittens());
        verify(feline, never()).getKittens();
    }

    /**
     * Тест, что Алекс является самцом.
     * Проверяет только наличие гривы у Алекса.
     */
    @Test
    void testAlexIsMale() throws Exception {
        Alex alex = new Alex(feline);
        assertTrue(alex.doesHaveMane());
    }

    /**
     * Тест конструктора Alex.
     * Проверяет только успешное создание объекта.
     */
    @Test
    void testAlexConstructor() {
        assertDoesNotThrow(() -> new Alex(feline));
    }
}