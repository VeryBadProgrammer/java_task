package com.homework.lesson5.task1;

public class Circle extends Figure {
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        if (radius > 10) {
            this.radius = 10;
        } else if (radius < 0) {
            this.radius = 0;
        } else {
            this.radius = radius;
        }
    }

    @Override
    public double square() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle - " + square();
    }
}
