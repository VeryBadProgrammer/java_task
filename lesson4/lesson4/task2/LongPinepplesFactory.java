package lesson4.task2;

import lesson4.task1.Fruit;
import lesson4.task1.Pineapple;

import java.util.concurrent.ThreadLocalRandom;

import static lesson4.task1.Pineapple.MAX_TOTAL_HEIGHT;

public class LongPinepplesFactory extends AbstractFabric{
    @Override
    Pineapple makeFruit() {
        return new Pineapple(ThreadLocalRandom.current().nextInt(10, MAX_TOTAL_HEIGHT));
    }
}
