package org.example.fixedwebcalculator;

public class DiffOperation implements Operation {
    @Override
    public double calculate(double num1, double num2) {
        return num1 - num2;
    }
}
