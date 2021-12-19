import java.util.Random;

public class Task2 {
    //    Задание 2. Случайности расходятся
//    - Создать массив на 5 элементов типа int и вывести на экран
//    - Разделить на два других - в первом массиве только четные числа,
//    во втором - только нечетные. Оба массива вывести на экран.
//    - Найти среднее значение в каждом массива и вывести их на экран
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) - 5;
        }

        int k = 0;
        for (int i : array) {
            if (i >= 0) {
                k++;
            }
        }
        int[] positive = new int[k];
        int i = 0;
        int[] negative = new int[5 - k];
        int j = 0;
        for (int a : array) {
            if (a >= 0) {
                positive[i] = a;
                i++;
            } else {
                negative[j] = a;
                j++;
            }
        }
        for (int a : positive) {
            System.out.print(a + " ");
        }
        System.out.println();

        for (int a : negative) {
            System.out.print(a + " ");
        }
        System.out.println();

        if (k != 0) {
            int sr = 0;
            for (int a : positive) {
                sr += a;
            }
            System.out.println(sr / k);
        }
        if (k != 5) {
            int sr = 0;
            for (int a : negative) {
                sr += a;
            }
            System.out.println(sr / (5-k));
        }
    }
}
