package mx.edu.utez.SIPRED.Evaluacion.controller;

import mx.edu.utez.SIPRED.periodo.dao.DaoPeriodo;
import mx.edu.utez.SIPRED.periodo.model.Periodo;
import mx.edu.utez.SIPRED.pregunta3.dao.DaoPregunta3;
import mx.edu.utez.SIPRED.pregunta3.model.Pregunta3;
import mx.edu.utez.SIPRED.preguntas1.dao.DaoPregunta1;
import mx.edu.utez.SIPRED.preguntas1.model.Pregunta1;
import mx.edu.utez.SIPRED.preguntas2.dao.DaoPregunta2;
import mx.edu.utez.SIPRED.preguntas2.model.pregunta2;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet(name = "ServletEvaluacion", urlPatterns = "/ServletEvaluacion")
public class ServletEvaluacion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String[] pregunta1 = request.getParameterValues("pregunta1");
                for (int i = 0; i < pregunta1.length; i++){*/
        String accion = request.getParameter("accion");
        switch (accion) {
            case "crear": {


                DaoPregunta1 daoPregunta1 = new DaoPregunta1();
                DaoPregunta2 daoPregunta2 = new DaoPregunta2();
                DaoPregunta3 daoPregunta3 = new DaoPregunta3();
                List<Pregunta1> preguntas1 = daoPregunta1.obtenerConsulta();
                List<pregunta2> preguntas2 = daoPregunta2.obtenerPreguntas();
                List<Pregunta3> preguntas3 = daoPregunta3.obtenerPregunta();
                request.setAttribute("preguntas1", preguntas1);
                request.setAttribute("preguntas2", preguntas2);
                request.setAttribute("preguntas3", preguntas3);
                request.getRequestDispatcher("evaluacion/preguntasCrearEvaluacion.jsp").forward(request, response);
                break;
            }

            case "periodos": {
                DaoPeriodo daoPeriodo = new DaoPeriodo();
                List<Periodo> periodos = daoPeriodo.ObtenerPeriodos();
                request.setAttribute("periodos", periodos);
                request.getRequestDispatcher("evaluacion/crearEvaluacion.jsp").forward(request, response);
            }
        }

//hacer un for para obtener los id de las preguntas
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
