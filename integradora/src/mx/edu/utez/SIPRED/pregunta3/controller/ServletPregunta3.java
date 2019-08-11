package mx.edu.utez.SIPRED.pregunta3.controller;

import mx.edu.utez.SIPRED.pregunta3.dao.DaoPregunta3;
import mx.edu.utez.SIPRED.pregunta3.model.Pregunta3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletPregunta3")
public class ServletPregunta3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoPregunta3 daoPregunta3 = new DaoPregunta3();
        List<Pregunta3> preguntas = daoPregunta3.obtenerPregunta();
        request.setAttribute("preguntas", preguntas);
        request.getRequestDispatcher("Pregunta3/consultarPregunta3.jsp").forward(request,response);
    }
}
