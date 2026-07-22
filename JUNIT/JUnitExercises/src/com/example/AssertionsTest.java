package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class AssertionsTest {

    @Test
    public void testAssertions() {

        // Assert Equals
        assertEquals(5, 2 + 3);

        // Assert True
        assertTrue(10 > 5);

        // Assert False
        assertFalse(10 < 5);

        // Assert Null
        String name = null;
        assertNull(name);

        // Assert Not Null
        String college = "SKCT";
        assertNotNull(college);
    }
}