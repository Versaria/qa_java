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

 * Изменения:
 * 1. Мок Predator заменен на Feline
 */
@ExtendWith(MockitoExtension.class)
class CatTest {
    @Mock
    Feline feline; // Мок-объект класса Feline

    /**
     * Тест метода getSound.
     * Проверяет только возврат корректного звука.
     */
    @Test
    void testGetSound() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    /**
     * Тест метода getFood с использованием мока.
     * Проверяет только возврат корректного списка пищи.
     */
    @Test
    void testGetFood() throws Exception {
        Cat cat = new Cat(feline);
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
        verify(feline, times(1)).eatMeat();
    }

    /**
     * Тест конструктора Cat.
     * Проверяет только успешное создание объекта.
     */
    @Test
    void testCatConstructor() {
        assertDoesNotThrow(() -> new Cat(feline));
    }
}