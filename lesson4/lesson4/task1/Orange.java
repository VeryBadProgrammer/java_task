package lesson4.task1;

import java.util.Random;

public class Orange extends Fruit {
    //    толщина кожуры - int от 0 до 20
    final int peelThickness;
    public static final int MAX_PEEL_THICKNESS = 20;
    public static final int MIN_PEEL_THICKNESS = 0;

    public Orange() {
        this.peelThickness = new Random().nextInt(21);
    }

    public Orange(int peelThickness) {
        if (peelThickness > MAX_PEEL_THICKNESS) {
            this.peelThickness = MAX_PEEL_THICKNESS;
        } else if (peelThickness < MIN_PEEL_THICKNESS) {
            this.peelThickness = MIN_PEEL_THICKNESS;
        } else {
            this.peelThickness = peelThickness;
        }
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + getWeight() +
                ", peelThickness=" + peelThickness +
                '}';
    }
}
