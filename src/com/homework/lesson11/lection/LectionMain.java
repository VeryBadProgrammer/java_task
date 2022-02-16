package com.homework.lesson11.lection;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Задание 3. Потоковые лекции
//
//Создайте класс Lection с полями : название, дата проведения. Описывает лекцию по какой-то дисциплине в определенную дату.
//
//В качестве даты можете использовать LocalDate, используя конструктор LocalDate.of
//
//Создайте класс Student с полями имя (строка) и список посещенных курсов в формате Set<Lection>.
//
//Создайте List<Student> students и заполните его 10 студентами, которые посетили 5 разных курсов (матанализ,философия, английкий язык, история, физкультура).
//
//Количество посещений придумайте самостоятельно.
//
//Теперь проведем аналитику:
//
//Для всех заданий используй students.stream() и операции с потоками.
//
//1. Выведите список студентов, которые хоть раз посещали матанализ.
//
//2. Выведите статистику посещений для каждого студентам в формате: имя - количество посщенных лекций.
//
//3. Выведите название дисциплин, имеющих наибольшее количество посещений.
//
//Если два разных студента посещают одну лекцию в один день, то это считается как два посещения.
//
//4. Выведите имена студентов, которые посетили наибольшее количество лекций в день.
//
//5. Выведите статистику по курсам в формате:
//
//название курсов - количество разных студентов, которые посетили хотя бы одно занятие. (т.е. в лучше случае это будет 10)
//
//Обратите внимание, что большинство заданий не предполагает "однострочного" решения цепочкой stream'ов.
//
//Где-то придется заводить временные переменные или методы.
//
//не забывайте, что логика по работе лежит не только в классе Stream, но еще Collectors, в частности, полезным может оказаться
//
//grouppingBy
public class LectionMain {
    public static void main(String[] args) {
        List<Student> students = createStudents();
        System.out.println("Выведите список студентов, которые хоть раз посещали матанализ.");
        students.stream().filter(x->x.getLectionSet().stream().anyMatch(l->l.getName().equals("матанализ"))).forEach(System.out::println);

        System.out.println("Выведите статистику посещений для каждого студентам в формате: имя - количество посщенных лекций.");
        students.stream().forEach(x -> System.out.println(x.getName() + " - " + x.getLectionSet().size()));

        System.out.println("Выведите название дисциплин, имеющих наибольшее количество посещений.");
        Map<String, Long> mapCountLection = students.stream()
                .map(Student::getLectionSet)
                .flatMap(x -> x.stream())
                .collect(Collectors.groupingBy(x -> x.getName(), Collectors.counting()));
        Long max = mapCountLection.values().stream().max(Comparator.comparingLong(Object::hashCode)).get();
        mapCountLection.keySet().stream().filter(x -> mapCountLection.get(x) == max).forEach(System.out::println);

        System.out.println("Выведите имена студентов, которые посетили наибольшее количество лекций в день.");
        Map<String, Long> studentWithCount = students.stream().collect(Collectors.toMap(x -> x.getName(),
                x -> x.getLectionSet().stream()
                        .collect(Collectors.groupingBy(l -> l.getDate(), Collectors.counting()))
                        .values().stream().max(Long::compare).get()));
        Long max1 = studentWithCount.values().stream().max(Long::compare).get();
        studentWithCount.keySet().stream().filter(x -> studentWithCount.get(x) == max1).forEach(System.out::println);

        System.out.println("Выведите статистику по курсам в формате:");
        System.out.println("название курсов - количество разных студентов, которые посетили хотя бы одно занятие. (т.е. в лучше случае это будет 10)");
        Map<String, Long> lections = students.stream()
                .flatMap(x -> x.getLectionSet().stream())
                .collect(Collectors.groupingBy(x->x.getName(), Collectors.counting()));
        System.out.println(lections);
    }

    public static List<Student> createStudents() {
        List<Student> students = new ArrayList<>();
        Lection lection1 = new Lection("матанализ", LocalDate.of(2020, Month.APRIL, 1));
        Lection lection2 = new Lection("философия", LocalDate.of(2020, Month.MARCH, 15));
        Lection lection3 = new Lection("английкий язык", LocalDate.of(2021, Month.AUGUST, 20));
        Lection lection4 = new Lection("история", LocalDate.of(2020, Month.APRIL, 1));
        Lection lection5 = new Lection("физкультура", LocalDate.of(2020, Month.APRIL, 28));
        students.add(new Student("name1", Set.of(lection1, lection3)));
        students.add(new Student("name2", Set.of(lection4, lection3)));
        students.add(new Student("name3", Set.of(lection5)));
        students.add(new Student("name4", Set.of(lection1, lection2)));
        students.add(new Student("name5", Set.of(lection1, lection4, lection5)));
        students.add(new Student("name6", Set.of(lection5, lection3)));
        students.add(new Student("name7", Set.of(lection1, lection2, lection5)));
        students.add(new Student("name8", Set.of(lection3, lection1)));
        students.add(new Student("name9", Set.of(lection1)));
        students.add(new Student("name10", Set.of(lection1, lection2)));

        return students;
    }
}
