package lesson4.task2;

import lesson4.task1.Apple;
import lesson4.task1.Fruit;

import static lesson4.task1.Apple.Color.RED;

public class RedApplesFactory extends AbstractFabric {
    @Override
    Apple makeFruit() {
        return new Apple(RED);
    }
}
