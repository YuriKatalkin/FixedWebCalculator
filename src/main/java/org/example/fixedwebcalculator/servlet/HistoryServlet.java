package org.example.fixedwebcalculator.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.fixedwebcalculator.model.Calculation;
import org.example.fixedwebcalculator.service.CalculationStorage;
import org.example.fixedwebcalculator.storage.JDBCCalculatorStorage;

import java.io.IOException;
import java.util.List;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {

    private final CalculationStorage storage = JDBCCalculatorStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Calculation> history = storage.getAllHistory();
        req.setAttribute("history", history);
        req.getRequestDispatcher("/history.jsp").forward(req, resp);
    }
}
