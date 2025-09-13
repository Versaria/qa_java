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
 * Каждый тест проверяет только одну функциональность.
 */
@ExtendWith(MockitoExtension.class)
class CatTest {
    @Mock
    Feline feline;

    /**
     * Тест возврата корректного звука.
     */
    @Test
    void testGetSound() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    /**
     * Тест возврата корректного списка пищи.
     */
    @Test
    void testGetFoodReturnsCorrectValue() throws Exception {
        Cat cat = new Cat(feline);
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }

    /**
     * Тест вызова метода eatMeat у Feline.
     */
    @Test
    void testGetFoodCallsEatMeat() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        verify(feline, times(1)).eatMeat();
    }

    /**
     * Тест успешного создания объекта.
     */
    @Test
    void testCatConstructor() {
        assertDoesNotThrow(() -> new Cat(feline));
    }
}