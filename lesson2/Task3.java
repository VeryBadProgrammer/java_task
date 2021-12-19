import java.util.Arrays;
import java.util.Random;

public class Task3 {
    //    Задание 3. Противоположности притигиваются
//    - Создайте два массива на 7 элементов.
//    - Используюте функцию Random.nextInt() чтобы полностью заполнить два массива:
//    в первом массиве должно оказаться ровно 7 положительных чисел,
//    во втором - ровно 7 отрицательных.
//    Подсказка: используйте цикл while во время генерации случайных чисел
//    и проверку на заполненность массива, прежде, чем записывать туда элемент.
//    - Выведите оба массива на экран - Создайте новый массив на 7 элементов.
//    Значением на каждой позиции является суммой значений на позициях с тем же
//    индексом из положительного и отрицательного массива.
    public static void main(String[] args) {
        Random random = new Random();
        int[] array1 = new int[7];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = random.nextInt(10);
        }
        int[] array2 = new int[7];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = random.nextInt(10) - 10;
        }

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));

        int[] all = new int[7];
        for (int i = 0; i < 7; i++) {
            all[i]=array1[i]+array2[i];
        }
        System.out.println(Arrays.toString(all));
    }
}
