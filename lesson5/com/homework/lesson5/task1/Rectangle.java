package com.homework.lesson5.task1;

public class Rectangle extends Figure {
    private int length;
    private int width;

    public Rectangle(int x, int y, int length, int width) {
        super(x, y);
        if (length <= 0 || width <= 0) {
            this.length = 0;
            this.width = 0;
            return;
        }
        this.length = length > 20 ? 20 : length;
        this.width = width > 20 ? 20 : width;
    }

    @Override
    public double square() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Rectangle - " + square();
    }
}
