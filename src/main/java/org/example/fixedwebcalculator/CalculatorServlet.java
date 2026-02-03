package org.example.fixedwebcalculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/calculator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String operation = req.getParameter("operation");

        Calculator calculator = new Calculator();
        OperationType operationType = OperationType.valueOf(operation.toUpperCase());
        double result = calculator.calculate(operationType, num1, num2);

        List<String> history = (List<String>) getServletContext().getAttribute("history");
        if (history == null) {
            history = new ArrayList<>();
            getServletContext().setAttribute("history", history);
        }
        history.add(num1 + " " + operationType + " " + num2 + " = " + calculator.getResult(operationType, num1, num2));

        req.setAttribute("result", result);
        req.setAttribute("num1", num1);
        req.setAttribute("num2", num2);
        req.setAttribute("operation", operation);

        req.getRequestDispatcher("/calculator.jsp").forward(req, resp);
    }
}
