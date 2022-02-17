package com.homework.lesson11.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    public Calculator() {
        operationList.put("multiplication", (x, y) -> x * y);
        operationList.put("division", (x, y) -> x / y);
        operationList.put("addition", (x, y) -> x + y);
        operationList.put("subtraction", (x, y) -> x - y);
        operationList.put("exponentiation", (x, y) -> Math.pow(x, y));
        operationList.put("root", (x, y) -> Math.pow(x, 1 / y));
    }

    private final Map<String, Operation> operationList = new HashMap<>();


    public Double calculate(String operationName, Double number1, Double number2) {
        if (!operationList.containsKey(operationName)){
            throw new ArithmeticException("No operetion");
        }
        return operationList.get(operationName).doOperation(number1, number2);
    }

    public boolean addOperation(String operationName, Operation implementation) {
        if(!operationList.containsKey(operationName)) {
            operationList.put(operationName, implementation);
            return true;
        }
        return false;
    }

}


interface Operation {
    Double doOperation(Double number1, Double number2);
}
