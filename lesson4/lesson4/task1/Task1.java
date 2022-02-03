package lesson4.task1;
//1. Фруктовая неоднозначность
// Создать класс Fruit со свойством "вес" типа int и методом toString
// Создать наследники:
// Apple - с дополнительным свойством цвет (красное, зеленое, желтое) - String
// Orange - с дополнительном свойством толщина кожуры - int от 0 до 20
// Pineapple - с дополнительным свойством - высота хвоста - int, от 5 до 20
//
//переопределить во всех фруктах toString, чтобы выводил все свойства фрукта
// и тип фрукта (яблоко, апельсин, ананас)
//
//создать метод getRandomFruit - которое возвращает случаный фрукт со случайными характеристиками.
// Создать массив типа Fruit, заполнить его 4 разными случаными фруктами и вывести их на экран

import java.util.concurrent.ThreadLocalRandom;

public class Task1 {
    static Fruit getRandomFruit() {
        int nextInt = ThreadLocalRandom.current().nextInt(3);
        return switch (nextInt) {
            case 0 -> new Apple();
            case 1 -> new Orange();
            case 2 -> new Pineapple();
            default -> new Fruit();
        };
    }

    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[4];
        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = getRandomFruit();
            System.out.println(fruits[i]);
        }

    }
}
