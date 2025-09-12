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
 */
@ExtendWith(MockitoExtension.class)
class AlexTest {
    @Mock
    Predator predator; // Мок-объект интерфейса Predator

    /**
     * Тест метода getFriends.
     */
    @Test
    void testGetFriends() throws Exception {
        Alex alex = new Alex(predator);
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        assertEquals(expectedFriends, alex.getFriends());
    }

    /**
     * Тест метода getPlaceOfLiving.
     */
    @Test
    void testGetPlaceOfLiving() throws Exception {
        Alex alex = new Alex(predator);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    /**
     * Тест переопределенного метода getKittens.
     */
    @Test
    void testGetKittens() throws Exception {
        Alex alex = new Alex(predator);
        assertEquals(0, alex.getKittens());
        verify(predator, never()).getKittens();
    }

    /**
     * Тест, что Алекс является самцом.
     */
    @Test
    void testAlexIsMale() throws Exception {
        Alex alex = new Alex(predator);
        assertTrue(alex.doesHaveMane());
    }

    /**
     * Тест конструктора Alex.
     */
    @Test
    void testAlexConstructor() {
        assertDoesNotThrow(() -> new Alex(predator));
    }
}