package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(Factorial.factorial(5));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}