package mx.edu.utez.SIPRED.docente.controller;

import com.google.gson.Gson;
import mx.edu.utez.SIPRED.alumno.dao.DaoAlumno;
import mx.edu.utez.SIPRED.alumno.model.Alumno;
import mx.edu.utez.SIPRED.docente.dao.DaoDocente;
import mx.edu.utez.SIPRED.docente.model.Docente;
import mx.edu.utez.SIPRED.usuario.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletDocente")
public class ServletDocente extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        System.out.println("accion:" + accion);
        switch (accion) {
            case "registrar": {
                String nombre = request.getParameter("nombreDocente");
                Docente docente = new Docente();
                docente.setNombreDocente(nombre);
                DaoDocente daoDocente = new DaoDocente();
                daoDocente.registrarDocente(docente);

                List<Docente> docentes = daoDocente.obtenerDocentes();
                request.setAttribute("docentes", docentes);
                request.getRequestDispatcher("Docente/consultarDocentes.jsp").forward(request, response);
            }
            case "cargarUsuario": {
                int id = Integer.parseInt(request.getParameter("id"));
                DaoDocente daoDocente = new DaoDocente();
                Docente docente = daoDocente.obtenerDocente(id);

                if (docente.getIdDocente() != 0) {
                    // 3. mandar el usuario de vuelta al jsp(en JSON)
                    //3.1 crear un pbjeto GSON
                    Gson gson = new Gson();

                    PrintWriter out = response.getWriter();
                    out.print(gson.toJson(docente));
                }
                break;
            }
            case "eliminar": {
                int id = Integer.parseInt(request.getParameter("id"));
                DaoDocente daoDocente = new DaoDocente();
                PrintWriter out = response.getWriter();
                if (daoDocente.eliminarDocente(id)) {
                    //Devolver al js un true
                    out.print("true");
                } else {
                    //Devolver al js un false
                    out.print("false");
                }

                break;
            }
            case "cargar": {
                DaoDocente daoDocente = new DaoDocente();
                List<Docente> docentes = daoDocente.obtenerDocentes();

                PrintWriter out = response.getWriter();
                //Json
                Gson gson = new Gson();
                out.print(gson.toJson(docentes));
                break;
            }
            case "editar": {
                String nombreDocente = request.getParameter("nombreDoc");
                int id = Integer.parseInt(request.getParameter("id"));
                Docente docente = new Docente();
                docente.setNombreDocente(nombreDocente);
                docente.setIdDocente(id);

                DaoDocente daoDocente = new DaoDocente();
                boolean valor = daoDocente.modificarDocente(docente);
                if (valor) {
                    request.getRequestDispatcher("Docente/consultarDocente.jsp").forward(request, response);
                }
                break;
            }
            case "redi": {
                response.sendRedirect("ServletDocente");
                break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("usuario");
        if (user == null) {
            sesion.removeAttribute("usuario");
            response.sendRedirect("index.jsp");
        } else {
            DaoDocente daoDocente = new DaoDocente();
            List<Docente> docentes = daoDocente.obtenerDocentes();
            request.setAttribute("docentes", docentes);
            request.getRequestDispatcher("Docente/consultarDocentes.jsp").forward(request, response);
        }
    }
}
