<%--
  Created by IntelliJ IDEA.
  User: Luis
  Date: 08/08/2019
  Time: 09:54 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:if test="${usuario==null}">
    <c:redirect url="index.jsp"></c:redirect>
</c:if>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/index.css">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <script src="js/jquery-3.4.1.min.js" type="application/javascript"></script>
    <script src="js/bootstrap.min.js" type="application/javascript"></script>
    <script src="js/alumnosAsincrono.js" type="application/javascript"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <title>index</title>
</head>
<body>
<div class="contenedor">
    <header>
        <div class="container titulos">
            <h2 class="titulo1">SIED</h2>
            <div class="menuUsuario">
                <select class="botonMenu" aria-labelledby="Menu" id="op">
                    <option value="">Perfil</option>
                    <option>Editar perfil</option>
                    <option value="cerrar" id="cerrarSesion" class="cerrar">Cerrar sesion
                    </option>
                </select>
                <form action="" id="cs">
                    <input type="hidden" name="accion">
                </form>
            </div>
            <h5 class="titulo2">Sistema De Evaluaci&oacute;n Docente</h5>
        </div>
    </header>
    <aside>
        <div class="img">
            <img src="src/logoDatic.png" alt="Logo DATIC" class="responsive-image imagen">
        </div>
        <div class="menu">
            <a href="index.html"><input type="button" class=" botonInicio" value="INICIO"></a>
            <a href="ServletDocente"><button class="boton">DOCENTES</button></a>
            <a href="preguntas.html"><input type="button" class="boton" value="PREGUNTAS"></a>
            <a href="AlumnoServlet"><button class="boton">ALUMNOS</button></a>
            <a href="ServletDocente"><button class="boton">CARRERAS</button></a>
            <form action="" id="dc">
                <input type="hidden" name="accion">
            </form>
        </div>
    </aside>
    <section class="row">
        <div class="col-md-2" id="cajas">
            <div class="evaluacion">
                <h6>Crear evaluaci&oacute;n</h6>
                <button id="crearEvaluacion">
                    <a href="crearEvaluacion.html">
                        <img src="src/mas.png" alt="imagen" id="btnAgregar">
                    </a>
                </button>
            </div>
            <div class="evaluacion">
                <h6>Seguimiento</h6>
                <button id="crearEvaluacion">
                    <a href="crearEvaluacion.html">
                        <img src="src/comprobado.png" alt="imagen" id="btnAgregar">
                    </a>
                </button>
            </div>
        </div>
        <div class="col-md-10 tabla">
            <h6>EVALUACI&Oacute;N PERIODO MAYO-AGOSTO</h6>
            <div class="table-wrapper-scroll-y my-custom-scrollbar">
                <table class="table table-bordered table-striped mb-0">
                    <thead>
                    <tr>
                        <th scope="col">DOCENTE</th>
                        <th scope="col">ACCI&Oacute;N</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row" id="nombreDocente">Fernando</th>
                        <th><a href="">ver</a></th>
                    </tr>
                    <tr>
                        <th scope="row" id="nombreDocente">Uli</th>
                        <th><a href="">ver</a></th>
                    </tr>
                    <tr>
                        <th scope="row" id="nombreDocente">Poncho</th>
                        <th><a href="">ver</a></th>
                    </tr>
                    <tr>
                        <th scope="row" id="nombreDocente">Sharon</th>
                        <th><a href="">ver</a></th>
                    </tr>
                    <tr>
                        <th scope="row" id="nombreDocente">Dulce</th>
                        <th><a href="">ver</a></th>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</div>
</body>
</html>
