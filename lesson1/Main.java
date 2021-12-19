import java.util.Arrays;
import java.util.Random;

public class Main {
    //    Задание 1.
//    Случайности складываются
//    - Создать массив на 10 чисел типа int
//    - Заполнить массив случайными числами, используя класс Random и функцию nextInt()
//    - Вывести массив на экран одной строкой, разделив элементы пробелом
//    - Посчитать сумму всех элементов и вывести на экран
//    - Найти минимальный элемент и вывести на экран его индекс в массиве и значение
    public static void main(String[] args) {
        Random random = new Random();
        int[] arrs = new int[10];
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = random.nextInt(10);
        }
        for (int arr : arrs) {
            System.out.print(arr + " ");
        }
        System.out.println();

        long sum = 0;
        for (int arr : arrs) {
            sum = sum + arr;
        }
        System.out.println(sum);

        int min = arrs[0];
        int k = 0;
        for (int i = 0; i < arrs.length; i++) {
            if (min > arrs[i] && k != i) {
                min = arrs[i];
                k = i;
            }
        }
        System.out.println(k);
    }
}
