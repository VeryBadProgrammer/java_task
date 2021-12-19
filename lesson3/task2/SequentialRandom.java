package task2;

import java.util.Random;

public class SequentialRandom {
    private static int value;
    static boolean isRandom = true;
    private static Random random = new Random();

    public SequentialRandom() {
        if (isRandom) {
            value = random.nextInt(50);
            isRandom = false;
        } else {
            value++;
        }
    }

    public static void resetRandom() {
        isRandom = true;
    }

    public int getValue() {
        return value;
    }
}
