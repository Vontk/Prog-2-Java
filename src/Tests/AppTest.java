package Tests;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static TP3.RecursiveFunctions.*;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void testRecursiveIndexOf() {
        assertEquals(2, recursiveIndexOf(List.of("a", "b", "c"), "c"));
        assertEquals(-1, recursiveIndexOf(List.of("a", "b", "c"), "d"));
        assertEquals(0, recursiveIndexOf(List.of("a", "b", "c"), "a"));
        assertEquals(1, recursiveIndexOf(List.of("a", "b", "c"), "b"));
        assertEquals(-1, recursiveIndexOf(List.of("a", "b", "c"), "e"));
        assertEquals(-1, recursiveIndexOf(List.of("a", "b", "c"), "f"));
        assertEquals(-1, recursiveIndexOf(List.of("a", "b", "c"), "g"));
        assertEquals(-1, recursiveIndexOf(List.of("a", "b", "c"), "h"));
    }

    @Test
    public void testRecursiveIndexOfByIndex() {
        assertEquals(2, recursiveIndexOfByIndex(List.of("a", "b", "c"), "c", 0));
        assertEquals(-1, recursiveIndexOfByIndex(List.of("a", "b", "c"), "d", 0));
        assertEquals(0, recursiveIndexOfByIndex(List.of("a", "b", "c"), "a", 0));
        assertEquals(1, recursiveIndexOfByIndex(List.of("a", "b", "c"), "b", 1));
        assertEquals(-1, recursiveIndexOfByIndex(List.of("a", "b", "c"), "e", 1));
        assertEquals(-1, recursiveIndexOfByIndex(List.of("a", "b", "c"), "f", 1));
        assertEquals(-1, recursiveIndexOfByIndex(List.of("a", "b", "c"), "g", 1));
        assertEquals(2, recursiveIndexOfByIndex(List.of("a", "b", "c"), "c", 2));
        assertEquals(2, recursiveIndexOfByIndex(List.of("a", "b", "c"), "c", 1));
    }

    @Test
    public void testRecursiveIndexOfEmpty() {
        assertEquals(-1, recursiveIndexOfEmpty(List.of("a", "b", "c")));
        assertEquals(3, recursiveIndexOfEmpty(List.of("a", "b", "c", "")));
        assertEquals(3, recursiveIndexOfEmpty(List.of("a", "b", "c", "", "")));
        assertEquals(3, recursiveIndexOfEmpty(List.of("a", "b", "c", "", "", "")));
        assertEquals(3, recursiveIndexOfEmpty(List.of("a", "b", "c", "", "", "", "")));
        assertEquals(-1, recursiveIndexOfEmpty(List.of("a", "b", "c")));
    }

    @Test
    public void testRecursivePut() {
        List<String> list1 = new ArrayList<>(List.of("a", "", "c"));
        assertEquals(1, recursivePut("d", list1));

        List<String> list2 = new ArrayList<>(List.of("a", "b", "c"));
        assertEquals(-1, recursivePut("d", list2));

        List<String> list3 = new ArrayList<>(List.of("a", "b", ""));
        assertEquals(2, recursivePut("d", list3));
    }

    @Test
    public void testRecursiveRemove() {
        assertEquals(1, recursiveRemove(new ArrayList<>(List.of("a", "b", "c")), "c"));
        assertEquals(3, recursiveRemove(new ArrayList<>(List.of("b", "b", "b")), "b"));
        assertEquals(0, recursiveRemove(new ArrayList<>(List.of("c", "b", "c")), "a"));
    }

    @Test
    public void testRecursiveSum() {
        assertEquals(15, recursiveSum(List.of(1, 2, 3, 4, 5)));
        assertEquals(21, recursiveSum(List.of(1, 2, 3, 4, 5, 6)));
        assertEquals(28, recursiveSum(List.of(1, 2, 3, 4, 5, 6, 7)));
        assertEquals(36, recursiveSum(List.of(1, 2, 3, 4, 5, 6, 7, 8)));
        assertEquals(45, recursiveSum(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        assertEquals(55, recursiveSum(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertEquals(66, recursiveSum(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        assertEquals(78, recursiveSum(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
        assertEquals(91, recursiveSum(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)));
        assertEquals(105, recursiveSum(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)));
        assertEquals(120, recursiveSum(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)));
        assertEquals(136, recursiveSum(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)));
    }

    @Test
    public void testRecursiveFactorial() {
        assertEquals(1, recursiveFactorial(1));
        assertEquals(2, recursiveFactorial(2));
        assertEquals(6, recursiveFactorial(3));
        assertEquals(24, recursiveFactorial(4));
        assertEquals(120, recursiveFactorial(5));
        assertEquals(720, recursiveFactorial(6));
        assertEquals(5040, recursiveFactorial(7));
        assertEquals(40320, recursiveFactorial(8));
        assertEquals(362880, recursiveFactorial(9));
        assertEquals(3628800, recursiveFactorial(10));
        assertEquals(39916800, recursiveFactorial(11));
        assertEquals(479001600, recursiveFactorial(12));
    }

    @Test
    public void testRecursivePow() {
        assertEquals(2, recursivePow(2, 1));
        assertEquals(4, recursivePow(2, 2));
        assertEquals(8, recursivePow(2, 3));
        assertEquals(16, recursivePow(2, 4));
        assertEquals(32, recursivePow(2, 5));
        assertEquals(64, recursivePow(2, 6));
        assertEquals(128, recursivePow(2, 7));
        assertEquals(256, recursivePow(2, 8));
        assertEquals(512, recursivePow(2, 9));
        assertEquals(1024, recursivePow(2, 10));
        assertEquals(2048, recursivePow(2, 11));
        assertEquals(4096, recursivePow(2, 12));
        assertEquals(8192, recursivePow(2, 13));
        assertEquals(16384, recursivePow(2, 14));
        assertEquals(32768, recursivePow(2, 15));
        assertEquals(65536, recursivePow(2, 16));
    }

    @Test
    public void testRecursiveFibonacci() {
        assertEquals(1, recursiveFibonacci(1));
        assertEquals(1, recursiveFibonacci(2));
        assertEquals(2, recursiveFibonacci(3));
        assertEquals(3, recursiveFibonacci(4));
        assertEquals(5, recursiveFibonacci(5));
        assertEquals(8, recursiveFibonacci(6));
        assertEquals(13, recursiveFibonacci(7));
    }

    @Test
    public void testPalindrome() {
        assertTrue(recursivePalindrome("racecar"));
        assertTrue(recursivePalindrome("radar"));
        assertTrue(recursivePalindrome("level"));
        assertTrue(recursivePalindrome("rotor"));
        assertTrue(recursivePalindrome("civic"));
        assertTrue(recursivePalindrome("deified"));

        assertFalse(recursivePalindrome("hello"));
        assertFalse(recursivePalindrome("world"));
        assertFalse(recursivePalindrome("java"));
        assertFalse(recursivePalindrome("programming"));
    }
}
