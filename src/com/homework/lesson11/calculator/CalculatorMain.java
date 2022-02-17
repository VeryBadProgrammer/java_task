package com.homework.lesson11.calculator;

//Задание 2.Расширяемый калькулятор Создать класс Calculator, который может выполнять операции на двумя числами. определить метод calculate(String operationName, Double number1, Double number2); Операции могут быть разными и хранятся внутри калькулятора.
//
//Определите интерфейс interface Operation { Double doOperation(Double number1, Double number2) throw ArithmeticException; } в классе калькудятор создайте метод, который добавляет новыую операцию в калькулятор: void addOperation(String operationName, Operation implementation); Добавьте в калькулятор операции: Умножение Деление Сложение Вычитание Возведение в степень Извлечение корня степени n Для опредления тела операции используйте лямбда выражения Например: Calculator calc = new Calculator(); calc.add("sum", (a,b) -> a+b); calc.calculate("sum",2,3);// выводит 5
public class CalculatorMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate("multiplication", 1D, 2D));
        calculator.addOperation("sum", (a, b) -> a + b);
        System.out.println(calculator.calculate("sum", 1D, 2D));
    }
}
