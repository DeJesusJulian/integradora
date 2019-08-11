package mx.edu.utez.SIPRED.preguntas1.controller;

import mx.edu.utez.SIPRED.preguntas1.dao.DaoPregunta1;
import mx.edu.utez.SIPRED.preguntas1.model.Pregunta1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletPregunta1")
public class ServletPregunta1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion){
            case "registrar":{
                String pregunta = request.getParameter("pregunta");
                Pregunta1 pregunta1 = new Pregunta1();
                pregunta1.setPregunta(pregunta);
                DaoPregunta1 daoPregunta1 = new DaoPregunta1();
                daoPregunta1.registrarPregunta(pregunta1);

                List<Pregunta1> preguntas = daoPregunta1.obtenerConsulta();
                request.setAttribute("preguntas", preguntas);
                request.getRequestDispatcher("Pregunta1/consultarPregunta1.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoPregunta1 daoPregunta1 = new DaoPregunta1();
        List<Pregunta1> preguntas = daoPregunta1.obtenerConsulta();
        request.setAttribute("preguntas", preguntas);
        request.getRequestDispatcher("Pregunta1/consultarPregunta1.jsp").forward(request, response);
    }
}
