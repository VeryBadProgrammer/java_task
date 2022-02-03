package lesson4.task2;

import lesson4.task1.Apple;

import static lesson4.task1.Apple.Color.GREEN;

public class GreenApplesFactory extends AbstractFabric {

    @Override
    Apple makeFruit() {
        return new Apple(GREEN);
    }
}
