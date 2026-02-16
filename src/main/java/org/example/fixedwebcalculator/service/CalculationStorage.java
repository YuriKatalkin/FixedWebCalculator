package org.example.fixedwebcalculator.service;

import org.example.fixedwebcalculator.model.Calculation;

import java.util.List;

public interface CalculationStorage {
    void save(Calculation calculation);
    List<Calculation> getAllHistory();
}
