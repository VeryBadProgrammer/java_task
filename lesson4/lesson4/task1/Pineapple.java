package lesson4.task1;

import java.util.Random;

public class Pineapple extends Fruit {
    //    высота хвоста - int, от 5 до 20
    final int tailHeight;
    public static final int MAX_TOTAL_HEIGHT = 20;
    public static final int MIN_TOTAL_HEIGHT = 5;


    public Pineapple() {
        this.tailHeight = new Random().nextInt(15) + 5;
    }

    public Pineapple(int tailHeight) {
        if (tailHeight > MAX_TOTAL_HEIGHT) {
            this.tailHeight = MAX_TOTAL_HEIGHT;
        } else if (tailHeight < MIN_TOTAL_HEIGHT) {
            this.tailHeight = MIN_TOTAL_HEIGHT;
        } else {
            this.tailHeight = tailHeight;
        }
    }

    @Override
    public String toString() {
        return "Pineapple{" +
                "weight=" + getWeight() +
                ", tailHeight=" + tailHeight +
                '}';
    }
}
