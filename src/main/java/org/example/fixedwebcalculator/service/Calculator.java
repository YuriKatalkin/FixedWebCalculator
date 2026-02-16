package org.example.fixedwebcalculator.service;

import org.example.fixedwebcalculator.model.OperationType;

import java.util.Map;

public class Calculator {
    private final Map<OperationType, Operation> operations = Map.of(
            OperationType.SUM, new SumOperation(),
            OperationType.DIFF, new DiffOperation(),
            OperationType.MULTIPLY, new MultiplyOperation(),
            OperationType.DIVIDE, new DivideOperation()
    );

    public double calculate(OperationType op, double num1, double num2) {
        Operation operation = operations.get(op);
        if (operation == null) {
            throw new IllegalArgumentException("Неизвестная операция: " + op);
        }
        return operation.calculate(num1, num2);
    }
}
