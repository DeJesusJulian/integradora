package mx.edu.utez.SIPRED.carrera.controller;

import mx.edu.utez.SIPRED.carrera.dao.DaoCarrera;
import mx.edu.utez.SIPRED.carrera.model.Carrera;
import mx.edu.utez.SIPRED.docente.dao.DaoDocente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletCarreras")
public class ServletCarreras extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {

            case "cargar": {
                break;
            }
            case "eliminar": {
                int id = Integer.parseInt(request.getParameter("id"));
                System.out.println("id: " + id);
                DaoCarrera daoCarrera = new DaoCarrera();
                PrintWriter out = response.getWriter();
                if (daoCarrera.eliminarCarrera(id)) {
                    //Devolver al js un true
                    out.print("true");
                } else {
                    //Devolver al js un false
                    out.print("false");
                }
                break;
            }
            case "redi": {
                response.sendRedirect("ServletCarreras");
                break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoCarrera daoCarrera = new DaoCarrera();
        List<Carrera> carreras = daoCarrera.consultarCarreras();
        request.setAttribute("carreras", carreras);
        request.getRequestDispatcher("Carrera/consultarCarreras.jsp").forward(request, response);
    }
}
