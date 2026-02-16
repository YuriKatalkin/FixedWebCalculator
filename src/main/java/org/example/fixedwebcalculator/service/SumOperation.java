package org.example.fixedwebcalculator.service;

public class SumOperation implements Operation {
    @Override
    public double calculate(double num1, double num2) {
        return num1 + num2;
    }
}
