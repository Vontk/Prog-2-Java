package com.template;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AppTest {

    App exercises = new App();

    @Test
    public void testSum() {
        assertEquals(5, exercises.sum(2, 3));
        assertEquals(0, exercises.sum(-1, 1));
    }

    @Test
    public void testIsEven() {
        assertTrue(exercises.isEven(4));
        assertFalse(exercises.isEven(3));
    }

    @Test
    public void testMax() {
        assertEquals(5, exercises.max(3, 5));
        assertEquals(10, exercises.max(10, 2));
    }

    @Test
    public void testFactorial() {
        assertEquals(120, exercises.factorial(5));
        assertEquals(1, exercises.factorial(0));
    }

    @Test
    public void testCountChars() {
        assertEquals(5, exercises.countChars("Hello"));
        assertEquals(0, exercises.countChars(""));
    }

    @Test
    public void testReverse() {
        assertEquals("olleH", exercises.reverse("Hello"));
        assertEquals("", exercises.reverse(""));
    }

    @Test
    public void testIsPrime() {
        assertTrue(exercises.isPrime(7));
        assertFalse(exercises.isPrime(4));
    }

    @Test
    public void testFindMin() {
        assertEquals(1, exercises.findMin(new int[]{3, 1, 4, 1, 5}));
        assertEquals(-1, exercises.findMin(new int[]{0, -1, 1}));
    }

    @Test
    public void testArraySum() {
        assertEquals(10, exercises.arraySum(new int[]{1, 2, 3, 4}));
        assertEquals(0, exercises.arraySum(new int[]{}));
    }

    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(32.0, exercises.celsiusToFahrenheit(0.0));
        assertEquals(212.0, exercises.celsiusToFahrenheit(100.0));
    }
}
