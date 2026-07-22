package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorAAATest {
	// Arrange

    Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
        System.out.println("Before Test");
    }

    @After
    public void teardown() {
        System.out.println("After Test");
    }

    @Test
    public void testAdd() {

        
        

        // Act
        int result = calculator.add(20, 30);

        // Assert
        assertEquals(50, result);
    }

    @Test
    public void testSubtract() {

        int result = calculator.subtract(10, 4);

        assertEquals(6, result);
    }
}