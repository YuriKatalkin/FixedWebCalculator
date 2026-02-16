package org.example.fixedwebcalculator.storage;

import org.example.fixedwebcalculator.configuration.PostgresConnection;
import org.example.fixedwebcalculator.model.Calculation;
import org.example.fixedwebcalculator.service.CalculationStorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCCalculatorStorage implements CalculationStorage {

    private static JDBCCalculatorStorage INSTANCE;

    private JDBCCalculatorStorage() {

    }

    public static JDBCCalculatorStorage getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new JDBCCalculatorStorage();
        }
        return INSTANCE;
    }

    @Override
    public void save(Calculation calculation) {
        try (Connection connection = PostgresConnection.getConnection()) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO table_name (num1, num2, operation, result) VALUES (?, ?, ?, ?)");
            preparedStatement.setDouble(1, calculation.getNum1());
            preparedStatement.setDouble(2, calculation.getNum2());
            preparedStatement.setString(3, calculation.getOperation());
            preparedStatement.setDouble(4, calculation.getResult());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Calculation> getAllHistory() {
        List<Calculation> history = new ArrayList<>();

        try (Connection connection = PostgresConnection.getConnection()) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT num1, num2, operation, result FROM table_name ORDER BY id DESC");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                double num1 = resultSet.getDouble("num1");
                double num2 = resultSet.getDouble("num2");
                String operation = resultSet.getString("operation");
                double result = resultSet.getDouble("result");

                history.add(new Calculation(num1, num2, operation, result));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return history;
    }
}
