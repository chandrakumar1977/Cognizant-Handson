package com.example;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void studentLogin() {
        System.out.println("Student logged in");
    }

    @Test
    @Order(2)
    void viewMarks() {
        System.out.println("Marks displayed");
    }

    @Test
    @Order(3)
    void studentLogout() {
        System.out.println("Student logged out");
    }
}