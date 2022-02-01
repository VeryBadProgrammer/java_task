package com.homework.lesson10;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

//Домашнее задание 10
//
//        .Многопоточность.
//
//        1. Создайте коллекцию из трех http ссылок
//
//        2. Загрузите содержимое всех трем ссылкам последовательно.
//
//        3. Выведите на экран:
//
//        - время, которое потребовалось, чтобы загрузить всё содержимое
//
//        - суммарный размер содержимого всех трех ссылок в байтах.
//
//        Пояснение: 1. Нужно вывести время, которой потратилось на загрузку всех трех ссылок, а не время, которое было потрачено на загрузки одной ссылки. Идея в том, чтобы сравнить последовательную и параллельную загрузку. Параллельная должна быть быстрее (раза в три). 2. Нужно вывести суммарный размер (размер ссылки1 + размер ссылки 2 + размер ссылки 3). Идея в том, что вы должно не просто запускать код асинхронно, но потом и иметь возможность дождаться результатов каждой задачи.
//
//        4. Теперь загрузите содержимое параллельно, используя три потока, выведите на экран тоже самое (время и размер).
//
//        Советы:
//
//        - Для хранения содержимого разных ссылок используйте потокобезопасные коллекции:
//
//        ConcurrentHashMap,ConcurrentHashSet, CopyOnWriteArrayList, ConcurrentLinkedQueue
//
//        - Для получения содержимого используйте new URL().openStream() (не забывайте закрывать поток)
public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<String> httpsString =
                Arrays.asList("https://habr.com/", "https://github.com/", "https://www.google.com/");
        runSeries(httpsString);

        runParallel(httpsString);
    }

    public static void runSeries(List<String> httpsString) {
        List<Integer> lengths = new CopyOnWriteArrayList<>();
        long start = System.currentTimeMillis();
        for (String http : httpsString) {
            lengths.add(getInfoFromLink(http));
        }
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed);
        System.out.println("Общий размер: " + lengths.stream().reduce(Integer::sum));
    }

    public static void runParallel(List<String> httpsString) throws ExecutionException, InterruptedException {
        List<Integer> lengths = new CopyOnWriteArrayList<>();
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(httpsString.size());
        for (String http : httpsString) {
            lengths.add(executorService.submit(() -> getInfoFromLink(http)).get());
        }
        executorService.shutdown();
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed);
        System.out.println("Общий размер: " + lengths.stream().reduce(Integer::sum));
    }

    public static Integer getInfoFromLink(String http) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new URL(http).openStream())) {
            return inputStream.readAllBytes().length;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
