package com.homework.lesson10;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
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
    static long startCount2=0;
    public static void main(String[] args) throws InterruptedException {
        List<String> https = new CopyOnWriteArrayList<>();
        https.add("https://habr.com/");
        https.add("https://github.com/");
        https.add("https://www.google.com/");
        long start = System.currentTimeMillis();
        long startCount = 0;
        for (String http : https) {
            try (InputStream inputStream = new URL(http).openStream()) {
                final byte[] bytes = inputStream.readAllBytes();
                startCount += bytes.length;
                System.out.println(startCount);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed);
        System.out.println("Общий размер: " + startCount);

        long start2 = System.currentTimeMillis();
        Thread thread1 = new Thread(() -> {
            try (InputStream inputStream = new URL(https.get(0)).openStream()) {
                final byte[] bytes = inputStream.readAllBytes();
                startCount2 += bytes.length;
                System.out.println(startCount2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try (InputStream inputStream = new URL(https.get(1)).openStream()) {
                final byte[] bytes = inputStream.readAllBytes();
                startCount2 += bytes.length;
                System.out.println(startCount2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try (InputStream inputStream = new URL(https.get(2)).openStream()) {
                final byte[] bytes = inputStream.readAllBytes();
                startCount2 += bytes.length;
                System.out.println(startCount2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        long finish2 = System.currentTimeMillis();
        long elapsed2 = finish2 - start2;
        System.out.println("Прошло времени, мс: " + elapsed2);
        System.out.println("Общий размер: " + startCount2);
    }
}
