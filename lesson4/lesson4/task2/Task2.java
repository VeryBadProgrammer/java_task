package lesson4.task2;

import lesson4.task1.Apple;
import lesson4.task1.Fruit;
import lesson4.task1.Orange;
import lesson4.task1.Pineapple;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//2. Фруктовая абстрактность
// Создать класс AbstractFabric с одним абстрактным методом makeFruit(), который возвращает фрукт.
// Создайте следующие подклассы:
//ThinOrangeFactory - которая создает только апельсины с толщиной кожуры от 1 до 5
// RedApplesFactory - которая создает только красные яблоки
// GreenApplesFactory - которая создает только зеленые яблоки.
// LongPinepplesFactory - которая создает только ананасы с длиной хвоста больше 10
//Создайте массив на 10 элементов и поместите туда 10 случайных фабрик одного из 4 описанных выше типов.
// Создайте массив типа Fruit на 20 элементов и заполните его фруктами
// из всех фабрик - по 2 фрукта от одной фабрики.
public class Task2 {
    public static void main(String[] args) {
        List<AbstractFabric> fabrics = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            fabrics.add(getRandomFabric());
        }

        List<Fruit> fruits = new ArrayList<>();
        for (AbstractFabric fabric: fabrics) {
            fruits.add(fabric.makeFruit());
            fruits.add(fabric.makeFruit());
        }
        System.out.println(fruits);

    }

    static AbstractFabric getRandomFabric() {
        int nextInt = ThreadLocalRandom.current().nextInt(4);
         return switch (nextInt) {
            case 0 -> new ThinOrangeFactory();
            case 1 -> new RedApplesFactory();
            case 2 -> new GreenApplesFactory();
            default -> new LongPinepplesFactory();
        };
    }
}
