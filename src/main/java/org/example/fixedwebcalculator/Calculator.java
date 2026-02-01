package org.example.fixedwebcalculator;

import java.util.Map;

public class Calculator {
    private final Map<String, Operation> operations = Map.of(
            "+", new SumOperation(),
            "-", new DiffOperation(),
            "*", new MultiplyOperation(),
            "/", new DivideOperation()
    );

    public double calculate(String op, double num1, double num2) {
        return operations.get(op).calculate(num1, num2);
    }
}
