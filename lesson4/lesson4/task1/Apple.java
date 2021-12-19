package lesson4.task1;

import java.util.Random;

import static lesson4.task1.Apple.Color.*;

public class Apple extends Fruit {
    public enum Color {
        RED("red"), GREEN("green"), YELLOW("yellow");
        private String name;

        public String getName() {
            return name;
        }

        Color(String name) {
            this.name = name;
        }
    }

    final String color;

    public Apple() {
        this.color = switch (new Random().nextInt(3)) {
            case 0 -> RED.getName();
            case 1 -> GREEN.getName();
            default -> YELLOW.getName();
        };
    }

    public Apple(Color color) {
        this.color = color.name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + getWeight() +
                '}';
    }
}
