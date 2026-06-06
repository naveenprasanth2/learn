package com.telusko.learn.valhalla;

public class TestValueClass {
    static void main() {
        ValueClassExample pointerTax = new ValueClassExample(9, 9);
        System.out.println(pointerTax.x() + pointerTax.y());
    }
}
