package org.example.fixedwebcalculator.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.fixedwebcalculator.model.Calculation;
import org.example.fixedwebcalculator.model.OperationType;
import org.example.fixedwebcalculator.service.CalculationStorage;
import org.example.fixedwebcalculator.service.Calculator;
import org.example.fixedwebcalculator.service.CalculatorService;
import org.example.fixedwebcalculator.storage.JDBCCalculatorStorage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

    private final CalculatorService service = new CalculatorService(
            new Calculator(),
            JDBCCalculatorStorage.getInstance()
    );

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/calculator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            double num1 = Double.parseDouble(req.getParameter("num1"));
            double num2 = Double.parseDouble(req.getParameter("num2"));
            String operation = req.getParameter("operation");
            OperationType operationType = OperationType.valueOf(operation.toUpperCase());

            Calculation calculation = service.execute(num1, num2, operationType);

            req.setAttribute("result", calculation.getResult());
            req.setAttribute("num1", num1);
            req.setAttribute("num2", num2);
            req.setAttribute("operation", operation);

        } catch (Exception e) {
            req.setAttribute("error", "Ошибка: " + e.getMessage());
        }
        req.getRequestDispatcher("/calculator.jsp").forward(req, resp);
    }
}