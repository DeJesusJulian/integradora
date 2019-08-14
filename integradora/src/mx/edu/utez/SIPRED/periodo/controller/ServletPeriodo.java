package mx.edu.utez.SIPRED.periodo.controller;

import mx.edu.utez.SIPRED.periodo.dao.DaoPeriodo;
import mx.edu.utez.SIPRED.periodo.model.Periodo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletPeriodo")
public class ServletPeriodo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoPeriodo daoPeriodo = new DaoPeriodo();
        List<Periodo> periodos = daoPeriodo.ObtenerPeriodos();
        request.setAttribute("periodos", periodos);
        request.getRequestDispatcher("Periodo/consultarPeriodos.jsp").forward(request, response);
    }
}
