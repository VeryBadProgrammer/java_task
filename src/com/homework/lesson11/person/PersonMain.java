package com.homework.lesson11.person;

import java.util.ArrayList;
import java.util.List;

//Задание 1. создайте класс Person с полями имя:String, возраст:int
//
//Создайте коллекцию людей Отсортируйте коллекцию сначала по имени, выведите на экран Затем - по возрасту, выведите на экран.
//
//Для сортировки используйте Collecitons.sort(collection, comparator) компаратор задайте в виде лямбда выражения
public class PersonMain {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("1", 1));
        persons.add(new Person("2", 2));
        persons.add(new Person("3", 3));
        persons.add(new Person("4", 4));
        persons.add(new Person("9", 9));
        persons.add(new Person("6", 6));
        persons.add(new Person("7", 7));
        persons.add(new Person("8", 8));
        persons.stream().sorted((x1, x2) -> x1.getName().hashCode() - x2.getName().hashCode()).forEach(System.out::println);
        persons.stream().sorted((x1, x2) -> x1.getAge() - x2.getAge()).forEach(System.out::println);

    }
}
