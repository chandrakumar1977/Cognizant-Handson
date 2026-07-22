package com.example;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ExceptionThrowerTest {

    @Test
    void checkInvalidAge() {

        ExceptionThrower checker = new ExceptionThrower();

        assertThrows(IllegalArgumentException.class, () -> {
            checker.checkAge(15);
        });

    }

}