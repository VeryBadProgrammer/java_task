package lesson4.task1;

import java.util.Random;

public class Fruit {
    private int weight;

    public Fruit() {
        this.weight = new Random().nextInt(10);
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "weight=" + weight +
                '}';
    }
}
