package mx.edu.utez.SIPRED.alumno.controller;

import com.google.gson.Gson;
import mx.edu.utez.SIPRED.alumno.dao.DaoAlumno;
import mx.edu.utez.SIPRED.alumno.model.Alumno;
import mx.edu.utez.SIPRED.carrera.dao.DaoCarrera;
import mx.edu.utez.SIPRED.carrera.model.Carrera;
import mx.edu.utez.SIPRED.cuatrimestre.dao.DaoCuatrimestre;
import mx.edu.utez.SIPRED.cuatrimestre.model.Cuatrimestre;
import mx.edu.utez.SIPRED.usuario.dao.UsuarioDao;
import mx.edu.utez.SIPRED.usuario.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig
@WebServlet(name = "AlumnoServlet", urlPatterns = "/AlumnoServlet")
public class AlumnoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "registrar": {
                String matricula = request.getParameter("matriculaRe");
                String grupo = request.getParameter("grupoRe");
                int cuatri = Integer.parseInt(request.getParameter("cuatrimestreRe"));
                int carrera = Integer.parseInt(request.getParameter("carreraRe"));
                Alumno alumno = new Alumno();
                Cuatrimestre cuatrimestre = new Cuatrimestre();
                cuatrimestre.setIdCuatrimestre(12);
                cuatrimestre.setCuatrimestre(cuatri);
                Carrera carrera1 = new Carrera();
                carrera1.setIdCarreras(carrera);
                System.out.println(carrera);
                alumno.setMatricula(matricula);
                alumno.setGrupo(grupo);
                alumno.setCuatrimestre(cuatrimestre);
                alumno.setCarrera(carrera1);
                DaoAlumno daoAlumno = new DaoAlumno();
                daoAlumno.registrarAlumno(alumno);

               /* PrintWriter out = response.getWriter();
                if (alumno.getMatricula() != null) {
                    out.print("true");
                } else {
                    out.print("false");
                }*/

                List<Alumno> alumnos = daoAlumno.consultarAlumnos();

                DaoCarrera daoCarrera = new DaoCarrera();

                List<Carrera> carreras = daoCarrera.consultarCarreras();
                request.setAttribute("carreras", carreras);
                request.setAttribute("alumnos", alumnos);
                request.getRequestDispatcher("Alumno/consultarAlumnos.jsp").forward(request, response);
                break;
            }
            case "cargar": {
                DaoAlumno daoAlumno = new DaoAlumno();
                List<Alumno> alumnos = daoAlumno.consultarAlumnos();

                PrintWriter out = response.getWriter();
                //Json
                Gson gson = new Gson();
                out.print(gson.toJson(alumnos));
                break;
            }
            case "cargarUsuario": {
                String matricula = request.getParameter("id");
                DaoAlumno daoAlumno = new DaoAlumno();
                Alumno alumno = daoAlumno.obtenerAlumno(matricula);

                if (alumno.getMatricula() != null) {
                    // 3. mandar el usuario de vuelta al jsp(en JSON)
                    //3.1 crear un pbjeto GSON
                    Gson gson = new Gson();
                    //3.2 convertir el usuario a JSON
                    //3.3 IMPRIMIR el JSON como respuesta del servlet
                    PrintWriter out = response.getWriter();
                    out.print(gson.toJson(alumno));
                }
                break;
            }
            case "eliminar": {
                String matricula = request.getParameter("id");
                DaoAlumno daoAlumno = new DaoAlumno();
                PrintWriter out = response.getWriter();
                if (daoAlumno.eliminarAlumno(matricula)) {
                    //Devolver al js un true
                    out.print("true");
                } else {
                    //Devolver al js un false
                    out.print("false");
                }

                break;
            }
            case "cerrar": {
                System.out.println("entre a cerrar");
                HttpSession sesion = request.getSession();
                sesion.removeAttribute("usuario");
                request.getRequestDispatcher("index.jsp").forward(request, response);
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
            DaoCarrera daoCarrera = new DaoCarrera();
            List<Carrera> carreras = daoCarrera.consultarCarreras();

            DaoAlumno daoAlumno = new DaoAlumno();
            List<Alumno> alumnos = daoAlumno.consultarAlumnos();

            DaoCuatrimestre daoCuatrimestre = new DaoCuatrimestre();
            List<Cuatrimestre> cuatrimestres = daoCuatrimestre.obtenerCuatrimestres();

            request.setAttribute("cuatrimestres", cuatrimestres);
            request.setAttribute("carreras", carreras);
            request.setAttribute("alumnos", alumnos);
            request.getRequestDispatcher("Alumno/consultarAlumnos.jsp").forward(request, response);
        }

    }
}
