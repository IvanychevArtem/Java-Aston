package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void testFactorialZero() {
        assertEquals(1, Factorial.factorial(0), "Факториал 0 должен быть 1");
    }

    @Test
    void testFactorialOne() {
        assertEquals(1, Factorial.factorial(1), "Факториал 1 должен быть 1");
    }

    @Test
    void testFactorialFive() {
        assertEquals(120, Factorial.factorial(5), "Факториал 5 должен быть 120");
    }

    @Test
    void testFactorialTen() {
        assertEquals(3628800, Factorial.factorial(10), "Факториал 10 должен быть 3 628 800");
    }

    @Test
    void testNegativeNumber() {
        assertEquals(0, Factorial.factorial(-1), "Факториал отрицательных чисел должен быть 0");
    }
}