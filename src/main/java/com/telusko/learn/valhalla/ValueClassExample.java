package com.telusko.learn.valhalla;

public value class ValueClassExample {
    private final int x;
    private final int y;

    public ValueClassExample(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {return this.x;};
    public int y() {return this.y;};
}
