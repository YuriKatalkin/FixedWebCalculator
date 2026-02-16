package org.example.fixedwebcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calculation {
    private double num1;
    private double num2;
    private double result;
    private String operation;

    public Calculation(double num1, double num2, String name, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = name;
        this.result = result;
    }

    @Override
    public String toString() {
        String sign = switch (operation) {
            case "SUM" -> "+";
            case "DIFF" -> "-";
            case "MULTIPLY" -> "*";
            case "DIVIDE" -> "/";
            default -> "?";

        };
        return String.format("%.2f %s %.2f = %.2f", num1, sign, num2, result);
    }
}
