package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator c = new Calculator();
        assertEquals(10, c.add(5, 5));
    }

    @Test
    public void testSubtract() {
        Calculator c = new Calculator();
        assertEquals(3, c.subtract(5, 2));
    }

    @Test
    public void testMultiply() {
        Calculator c = new Calculator();
        assertEquals(20, c.multiply(5, 4));
    }
}