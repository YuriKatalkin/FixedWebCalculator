package org.example.fixedwebcalculator.service;

import org.example.fixedwebcalculator.model.Calculation;
import org.example.fixedwebcalculator.model.OperationType;

public class CalculatorService {
    private final Calculator calculator;
    private final CalculationStorage storage;

    public CalculatorService(Calculator calculator, CalculationStorage storage) {
        this.calculator = calculator;
        this.storage = storage;
    }

    public Calculation execute(double num1, double num2, OperationType operationType) {
        double result = calculator.calculate(operationType, num1, num2);
        Calculation calculation = new Calculation(num1, num2, operationType.name(), result);

        storage.save(calculation);
        return calculation;

    }
}
