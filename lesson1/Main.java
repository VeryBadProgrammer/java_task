import java.util.Arrays;
import java.util.Random;

public class Main {
    //    Написать программу, в которой есть две переменные типа Integer со значениями.
//    Значения можно указать в коде программы или ввести с клавиатуры или взять из аргументов.
//    3. Если первое число больше второго – написать на экран «Число %s больше %s».
//    4. Если первое число меньше второго – написать на экран «Число %s меньше %s».
//    5. В любом случае, вывести на экран сумму чисел.
    public static void main(String[] args) {
        Integer first = 5;
        Integer second = 7;
        if (first > second) {
            System.out.println(String.format("Число %s больше %s", first, second));
        } else if (second > first) {
            System.out.println(String.format("Число %s меньше %s", first, second));
        }
        System.out.println("Sum: " + (first + second));
    }
}
