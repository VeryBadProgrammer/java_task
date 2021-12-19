package com.homework.lesson6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    //    Создать свой класс MyArrayList, который хранит максимум 10 объектов любого типа (по аналогии с ArrayList).
//
//Если попытаться добавить больше, чем 10 элементов, то должно выкинуться unchecked исключение - MyArrayStoreException.
//
//Используйте обощенный класс для этого (generic) с типом T.
//
//- Реализуйте методы:
//
//1. void add(T) - добавляет элемент в коллекцию
//
//2. boolean remove(T) - возвращает true, если элемент был найден и удален
//
//3. T[] toArray() - возвращает массив из всех текущих элементов
//
//4. int size()
//
//5. T get(int) - взять элемент по индексу.
//
//- Создайте класс Bycicle, определите у него свойства String modelName; int maxSpeed (от 5 до 50км\ч);
//
//Переопределите equals и hashCode, который используют оба свойства велосипеда.
//
//- Создайте 11 случайных велосипедов и попытайтесь их добавить их в новый экземпляр MyArrayList.
//
//Если какой-то велосипед добавить не получилось - то в лог выведите какой велосипед не добавился.
//
//- Проверьте, что все методы работают правильно:
//
//1. Возьмите случайное число от 0 до 50.
//
//2. Удалите из коллекции все велосипеды со скоростью меньше этого случайного числа.
//
//- Теперь создайте новый экземпляр MyArrayList
//
//- Добавьте в него 10 случайных чисел от 1 до 10
//
//- удалите все четные числа
//
//- Выведите оставшиеся числа на экран.
    public static void main(String[] args) {
        //Создайте 11 случайных велосипедов
        MyArrayList<Bycicle> bycicles = new MyArrayList<>();
        for (int i = 0; i < 11; i++) {
            Bycicle element = new Bycicle("name" + i, (ThreadLocalRandom.current().nextInt(5, 50)));
            try {
                bycicles.add(element);
            } catch (MyArrayStoreException e) {
                System.out.printf("Can't add element with index:%s and info:%s\n", i, element);
            }
        }
        System.out.println(bycicles);

        //Удалите из коллекции все велосипеды со скоростью меньше
        int randomNumber = new Random().nextInt(45) + 5;
        System.out.println("random number is : " + randomNumber);
        Iterator<Bycicle> bycicleIterator = bycicles.iterator();
        while (bycicleIterator.hasNext()) {
            Bycicle next = bycicleIterator.next();
            if (next.getMaxSpeed() < randomNumber) {
                bycicleIterator.remove();
            }
        }
        System.out.println(bycicles);


        //удалите все четные числа
        MyArrayList<Integer> numbers = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i * 7);
        }
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(numbers.get(i));
            }
        }
        System.out.println(numbers);
    }
}
