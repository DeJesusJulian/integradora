package mx.edu.utez.SIPRED.preguntas2.controller;

import mx.edu.utez.SIPRED.preguntas2.dao.DaoPregunta2;
import mx.edu.utez.SIPRED.preguntas2.model.pregunta2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletPregunta2")
public class ServletPregunta2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion){
            case "registrar":{
                String pregunta = request.getParameter("pregunta");
                pregunta2 pregunta1 = new pregunta2();
                pregunta1.setPregunta(pregunta);
                DaoPregunta2 daoPregunta2 = new DaoPregunta2();
                daoPregunta2.registrarPregunta(pregunta1);

                List<pregunta2>preguntas = daoPregunta2.obtenerPreguntas();
                request.setAttribute("preguntas", preguntas);
                request.getRequestDispatcher("Pregunta2/consultarPreguntas2.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoPregunta2 daoPregunta2 = new DaoPregunta2();
        List<pregunta2>preguntas = daoPregunta2.obtenerPreguntas();
        request.setAttribute("preguntas", preguntas);
        request.getRequestDispatcher("Pregunta2/consultarPreguntas2.jsp").forward(request,response);
    }
}
