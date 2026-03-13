package com.telusko.learn.health;

public class SwitchTest {
    static void main() {
        String name = "naveen";

        switch (name) {
            case String s when s.equals("naveen") -> System.out.println("He is naveen");
            default -> System.out.println("Its not");
        }
    }
}
