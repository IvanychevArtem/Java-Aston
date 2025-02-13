package org.example;

public class Factorial {
    public static long factorial(int n) {
        if (n < 0) {
            System.out.println("Факториал не определен для отрицательных чисел");
            return 0;
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}