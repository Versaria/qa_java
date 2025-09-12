package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Тесты для класса Cat.
 * Использует Mockito для создания мок-объектов.
 */
@ExtendWith(MockitoExtension.class)
class CatTest {
    @Mock
    Predator predator; // Мок-объект интерфейса Predator

    /**
     * Тест метода getSound.
     */
    @Test
    void testGetSound() {
        Cat cat = new Cat(predator);
        assertEquals("Мяу", cat.getSound());
    }

    /**
     * Тест метода getFood с использованием мока.
     */
    @Test
    void testGetFood() throws Exception {
        Cat cat = new Cat(predator);
        when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
        verify(predator, times(1)).eatMeat();
    }

    /**
     * Тест конструктора Cat.
     */
    @Test
    void testCatConstructor() {
        assertDoesNotThrow(() -> new Cat(predator));
    }
}