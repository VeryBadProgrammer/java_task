package com.homework.lesson9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Потоки и файлы.
//
//Задание 1. Файловый произвол - Создате новую папку с названием SE2020_LESSON9 в любом месте - Создайте от 1 до 3 (произвольное число) вложенных папок. Название папки - Directory_<уровень вложенности>
//
//Пример, какие папки могут получится SE2020_LESSON9/1 - если создалась всего одна папка SE2020_LESSON9/1/2- если создались две папки. SE2020_LESSON9/1/2/3 - если создались все три папки. Обратите внимание, что папка 3 - вложена в папку 2, а папка 2 - в папку 1.
//
//- В каждой папке (включая корень SE2020_LESSON9) создайте 1-3 файла: содержимое каждого файла - 10-200 случайных цифр (цифр, а не чисел). название файла - File_<номер файла, начиная с 1>
//
//- выведите на экран полный путь до всех файлов (но не папок, вложенные файлы тоже считаются)) в папке SE2020_LESSON9 Совет: Для обхода можно использовать Files.walkFileTree
//
//Задание 2. Фильтрованные атрибуты Используйте структуру файлов и папок из Задания 1.
//
//- Выведите полное название и содержимое самого маленького файла. Если таких файлов несколько - выведите их все
// - Выведите полное название и первые 10 символов самого большого файла.
// - Удалите папку SE2020_LESSON9 и все вложенные файлы и папки.
public class Main {
    final static String DEFAULT_FOLDER_NAME = "SE2020_LESSON9";

    public static void main(String[] args) throws IOException {
        File file = createFolder(DEFAULT_FOLDER_NAME);
        createRandomCountOfFile(file.getPath());
        Random random = new Random();
        int countOfFolder = random.nextInt(3);
        for (int i = 0; i <= countOfFolder; i++) {
            file = createFolder(file.getPath() + "//" + (i + 1));
            createRandomCountOfFile(file.getPath());
        }
        List<Path> allPath = getAllPath(Path.of(DEFAULT_FOLDER_NAME));
        allPath.forEach(System.out::println);

        printMinFile(allPath);
        printMaxFile(allPath);
        File fileToRemove = new File(DEFAULT_FOLDER_NAME);
        removeFolder(fileToRemove);
    }

    private static void removeFolder(File file) throws IOException {
        final File[] array = file.listFiles();
        if (array != null) {
            Arrays.stream(array).forEach(x -> {
                try {
                    removeFolder(x);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        file.delete();
    }

    private static void printMinFile(List<Path> allPath) {
        Path minPath = allPath.stream().min(Comparator.comparing(x -> x.toFile().length())).get();
        allPath.forEach(x -> {
            if (x.toFile().length() == minPath.toFile().length()) {
                String body = null;
                try (FileInputStream inputStream = new FileInputStream(x.toFile())) {
                    body = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.printf("Min has path %1$s, and body: %2$s\n", x.toAbsolutePath(), body);
            }
        });
    }

    private static void printMaxFile(List<Path> allPath) {
        Path max = allPath.stream().max(Comparator.comparing(x -> x.toFile().length())).get();
        String body = null;
        try (FileInputStream inputStream = new FileInputStream(max.toFile())) {
            body = new String(inputStream.readNBytes(10));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Max path is %s and first 10 symbols are: %s", max.getFileName(), body);
    }

    public static File createFolder(String pathName) {
        File file = new File(pathName);
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private static void createRandomCountOfFile(String path) throws IOException {
        int countOfFile = new Random().nextInt(1, 3);
        for (int j = 0; j <= countOfFile; j++) {
            createFileWithRandomBody(path + "//File_" + (j + 1));
        }
    }

    public static File createFileWithRandomBody(String pathName) throws IOException {
        File file = new File(pathName);
        if (!file.exists()) {
            file.createNewFile();
        }
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        int count = random.nextInt(10, 200);
        for (int i = 0; i < count; i++) {
            builder.append(random.nextInt(10));
        }
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(builder.toString().getBytes());
        }
        return file;
    }

    private static List<Path> getAllPath(Path path) throws IOException {
        List<Path> result;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        }
        return result;
    }
}
