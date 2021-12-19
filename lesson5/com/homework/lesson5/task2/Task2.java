package com.homework.lesson5.task2;

import javax.swing.*;
import java.util.Arrays;

//2. Сезонные радости
//
//Создайте enum Season с 4 временами года.
//
//Создайте enum Games с 4 играми.
//
//В каждое время года можно играть ровно в одну игру:
//
//Зима - снежки
//
//Весна - запуск корабликов по ручьям
//
//Лето - собирание и поедание ягод
//
//Осень - измерение глубины луж методом "сапога"
//
//Создайте класс Person. У него есть имя и любимый сезон.
//
//Создайте массив на 10 элементов с людьми со случайными именами и любимыми сезонами.
//
//Для каждого человека выведите любимую игру.
//
//Рекомендации:
//
//в Season определите дополнительное поле - игра для сезона.
public class Task2 {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Vasya", Season.AUTUMN),
                new Person("Masha", Season.SPRING),
                new Person("Katya", Season.SUMMER),
                new Person("Ola", Season.WINTER),
                new Person("Petay", Season.WINTER),
                new Person("Yula", Season.AUTUMN),
                new Person("Sergey", Season.WINTER),
                new Person("more name", Season.SUMMER),
                new Person("other name", Season.SPRING),
                new Person("new", Season.AUTUMN)
        };
        System.out.println(Arrays.toString(people));
    }
}
