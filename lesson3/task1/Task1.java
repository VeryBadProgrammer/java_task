package task1;

import java.util.Random;

public class Task1 {
//    Задание 1. Цифровая персонализация
//    - Создать класс task1.Person с двумя полями типа String: firstName, lastName
//    - создать один публичный конструктор с аргументами firstName и lastName.
//    В конструкторе инициализировать поля класса значениями из аргументов.
//    - Для каждого поля определить только getter'ы (без setter'ов)
//    - getFirstName, getLastName , который возвращают соответствующее поле
//    - Создать метод toString() который возвращает человека в формате "Фамилия, Имя"
//
//      в методе main
//      - Создать массив типа String на 5 элементов
//      - туда записать какие-нибудь реальные имена.
//      - Создать массив типа String на 6 элементов
//      - туда записать какие-нибудь реальные фамилии
//      - Создать массив типа task1.Person на 50 элементов
//      - туда записать людей со случайными фамилиями из массивов выше
//      - Вывести всех людей из массива в формате "Человек №{индекс в массиве} - Фамилия, Имя"

    public static void main(String[] args) {
        String[] names = {"Vasya", "Petya", "Dima", "Alex", "Misha"};
        String[] surnames = {"Sidorov", "Morozov", "Smirnov", "Pupkin", "Usachev", "Nosov"};
        Person[] persons = new Person[50];
        Random random = new Random();

        for (int i = 0; i < persons.length; i++) {
            persons[i] = new Person(names[random.nextInt(names.length)],
                    surnames[random.nextInt(surnames.length)]);
            System.out.println("Человек №" + i + " - " + persons[i]);
        }


    }
}
