<%--
  Created by IntelliJ IDEA.
  User: Luis
  Date: 13/08/2019
  Time: 12:11 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="js/jquery-3.4.1.min.js" type="application/javascript"></script>
    <script src="js/ajax.js"></script>
    <script src="js/bootstrap.min.js" type="application/javascript"></script>
    <script src="js/all.min.js" type="application/javascript"></script>
    <script src="js/sweetalert2.min.js" type="application/javascript"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/all.min.css" type="text/css">
    <link rel="stylesheet" href="css/sweetalert2.min.css">
    <link rel="stylesheet" href="css/crearEvaluacion.css">
    <title>index</title>
</head>
<body>
<div class="contenedor">
    <header>
        <div class="container titulos">
            <h2 class="titulo1">SIED</h2>
            <div class="menuUsuario">
                <select class="botonMenu" aria-labelledby="Menu">
                    <option>Editar perfil</option>
                    <option>Cerrar sesi&oacute;n</option>
                </select>
            </div>
            <h5 class="titulo2">Sistema De Evaluaci&oacute;n Docente</h5>

        </div>
    </header>
    <aside>
        <div class="img">
            <img src="src/logoDatic.png" alt="Logo DATIC" class="responsive-image imagen">
        </div>
        <div class="menu">
            <a href="inicio.jsp"><input type="button" class=" botonInicio" value="INICIO"></a>
            <a href="ServletDocente">
                <button class="boton">DOCENTES</button>
            </a>
            <a href="preguntas.html"><input type="button" class="boton" value="PREGUNTAS"></a>
            <a href="AlumnoServlet">
                <button class="boton">ALUMNOS</button>
            </a>
            <a href="ServletDocente">
                <button class="boton">CARRERAS</button>
            </a>
        </div>
    </aside>
    <section>

        <div class="contenedorSecundario">

            <div class="contenedorTerciario">
                <label>
                    <h6 class="tituloTabla1">Siempre, Casi siempre,Regularmente,Casi nunca, Nunca</h6>
                </label>
                <table class="table table-responsive table-stripped">
                    <thead>
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${preguntas1}" var="pregunta1">
                        <input type="checkbox" value="${pregunta1.idPregunta1}">${pregunta1.pregunta}
                    </c:forEach>
                    </tbody>
                </table>
            </div>


            <div class="cuartoContenedor">
                <label>
                    <h6 class="tituloTabla1">Comentarios</h6>
                </label>
                <table class="table table-responsive table-stripped">
                    <tbody>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="quintoContenedor">
                <label>
                    <h6 class="tituloTabla1">Excelente, Bueno, Regular, Malo, Muy malo</h6>
                </label>
                <table class="table table-responsive table-stripped">
                    <tbody>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    <tr>
                        <td><input type="checkbox"></td>
                        <td>Aqui va una pregunta aqui va una pregunta</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <a href="index.html"><input type="button" class=" botonCancelar " value="Cancelar"></a>
        <a href="agregarDocente.html"><input type="button" class=" botonSiguiente" value="Siguiente"></a>
    </section>
</div>
</body>
</html>