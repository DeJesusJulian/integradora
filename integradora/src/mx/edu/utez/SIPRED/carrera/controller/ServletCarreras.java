package mx.edu.utez.SIPRED.carrera.controller;

import mx.edu.utez.SIPRED.carrera.dao.DaoCarrera;
import mx.edu.utez.SIPRED.carrera.model.Carrera;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletCarreras")
public class ServletCarreras extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoCarrera daoCarrera = new DaoCarrera();
        List<Carrera> carreras = daoCarrera.consultarCarreras();
        request.setAttribute("carreras", carreras);
        request.getRequestDispatcher("Carrera/consultarCarreras.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoCarrera daoCarrera = new DaoCarrera();
        List<Carrera> carreras = daoCarrera.consultarCarreras();
        request.setAttribute("carreras", carreras);
        request.getRequestDispatcher("Carrera/consultarCarreras.jsp").forward(request, response);
    }
}
