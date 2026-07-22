package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8,10,11})
    public void testEvenNumbers(int number) {

        // Arrange
        EvenChecker checker = new EvenChecker();

        // Act
        boolean result = checker.isEven(number);

        // Assert
        assertTrue(result);

    }

}