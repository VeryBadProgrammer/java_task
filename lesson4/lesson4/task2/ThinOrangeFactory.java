package lesson4.task2;

import lesson4.task1.Fruit;
import lesson4.task1.Orange;

import java.util.concurrent.ThreadLocalRandom;

public class ThinOrangeFactory extends AbstractFabric {

    @Override
    Orange makeFruit() {
        return new Orange(ThreadLocalRandom.current().nextInt(1, 5));
    }
}
