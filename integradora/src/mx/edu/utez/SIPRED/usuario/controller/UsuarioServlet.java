package mx.edu.utez.SIPRED.usuario.controller;

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

@MultipartConfig
@WebServlet(name = "UsuarioServlet", urlPatterns = "/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "login": {
                String usuario = request.getParameter("email");
                String contrasena = request.getParameter("pwd");
                String msj = "";
                System.out.println(usuario);
                System.out.println(contrasena);

                Usuario user = new Usuario();
                user.setUsuario(usuario);
                user.setContrasena(contrasena);

                UsuarioDao usuarioDao = new UsuarioDao();
                user = usuarioDao.obtenerUsuario(user);
                msj = Integer.toString(user.getIdAdministrador());

                HttpSession sesion = request.getSession();

                if (user.getIdAdministrador() == 0) {
                    request.setAttribute("error", "El nombre de usuario o contraseña no existen");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    System.out.println("entre usuarioServlet else");
                    sesion.setAttribute("usuario", user);
                    response.sendRedirect("UsuarioServlet");
                }
                break;
            }
            case "cerrar": {
                System.out.println("entre a cerrar");
                HttpSession sesion = request.getSession();
                sesion.removeAttribute("usuario");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String accion = request.getParameter("accion") == null ? "" : request.getParameter("accion");
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("usuario");
        System.out.println(accion + "entre doget");
        if (user == null) {
            System.out.println(accion + "entre if null");
            sesion.removeAttribute("usuario");
            response.sendRedirect("index.jsp");
        } else {
            System.out.println("else doget inicio.jsp");
            request.getRequestDispatcher("inicio.jsp").forward(request, response);
        }
    }
}
