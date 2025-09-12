package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Параметризованные тесты для класса Lion.
 * Использует Mockito для создания мок-объектов.
 */
@ExtendWith(MockitoExtension.class)
class LionParameterizedTest {
    @Mock
    Predator predator; // Мок-объект интерфейса Predator

    /**
     * Параметризованный тест допустимых значений пола.
     * @param sex допустимое значение пола
     */
    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void testValidSex(String sex) {
        assertDoesNotThrow(() -> new Lion(sex, predator),
                "Конструктор не должен выбрасывать исключение для допустимых значений пола");
    }

    /**
     * Параметризованный тест недопустимых значений пола.
     * @param sex недопустимое значение пола
     */
    @ParameterizedTest
    @ValueSource(strings = {"", "Неизвестный", "Male", "Female"})
    void testInvalidSex(String sex) {
        assertThrows(Exception.class, () -> new Lion(sex, predator),
                "Конструктор должен выбрасывать исключение для недопустимых значений пола");
    }
}