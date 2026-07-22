package com.example;

public class ExceptionThrower {

    public void checkAge(int age) {

        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above");
        }

        System.out.println("Eligible");
    }
}