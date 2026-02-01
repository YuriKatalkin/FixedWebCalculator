package org.example.fixedwebcalculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<String> history = (List<String>) getServletContext().getAttribute("history");
        if (history == null) {
            history = new ArrayList<>();
        }
        req.setAttribute("history", history);
        req.getRequestDispatcher("/history.jsp").forward(req, resp);
    }
}
