package com.homework.lesson5.task1;

public abstract class Figure {
    public enum Quadrant {ONE, TWO, THREE, FOUR}
    private int x;
    private int y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract double square();

    public Quadrant getQuadrant() {
        if (x >= 0 && y >= 0) {
            return Quadrant.ONE;
        }
        if (x >= 0) {
            return Quadrant.TWO;
        }
        if (y > 0) {
            return Quadrant.THREE;
        }
        return Quadrant.FOUR;
    }
}

