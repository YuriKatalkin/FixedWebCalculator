package org.example.fixedwebcalculator;

public class DivideOperation implements Operation {
    @Override
    public double calculate(double num1, double num2) {
        if (num2 == 0) return 0;
        return num1 / num2;
    }
}
