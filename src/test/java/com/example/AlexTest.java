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
 * Каждый тест проверяет только одну функциональность.
 */
@ExtendWith(MockitoExtension.class)
class AlexTest {
    @Mock
    Feline feline;

    /**
     * Тест возврата корректного списка друзей.
     */
    @Test
    void testGetFriends() throws Exception {
        Alex alex = new Alex(feline);
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        assertEquals(expectedFriends, alex.getFriends());
    }

    /**
     * Тест возврата корректного места жительства.
     */
    @Test
    void testGetPlaceOfLiving() throws Exception {
        Alex alex = new Alex(feline);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    /**
     * Тест возврата нуля котят.
     */
    @Test
    void testGetKittensReturnsZero() throws Exception {
        Alex alex = new Alex(feline);
        assertEquals(0, alex.getKittens());
    }

    /**
     * Тест, что метод getKittens не вызывает соответствующий метод у Feline.
     */
    @Test
    void testGetKittensNeverCallsFeline() throws Exception {
        Alex alex = new Alex(feline);
        alex.getKittens();
        verify(feline, never()).getKittens();
    }

    /**
     * Тест, что Алекс является самцом.
     */
    @Test
    void testAlexIsMale() throws Exception {
        Alex alex = new Alex(feline);
        assertTrue(alex.doesHaveMane());
    }

    /**
     * Тест успешного создания объекта.
     */
    @Test
    void testAlexConstructor() {
        assertDoesNotThrow(() -> new Alex(feline));
    }
}