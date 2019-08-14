<%--
  Created by IntelliJ IDEA.
  User: Luis
  Date: 13/08/2019
  Time: 08:58 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="css/nuevaPantalla.css">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
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

            <a href="index.html"><input type="button" class=" botonInicio" value="INICIO"></a>
            <a href="docentes.html"><input type="button" class="boton" value="DOCENTES"></a>
            <a href="preguntas.html"><input type="button" class="boton" value="PREGUNTAS"></a>
            <a href="preguntas.html"><input type="button" class="boton" value="ALUMNOS"></a>
            <a href="carreras.html"><input type="button" class=" boton" value="CARRERAS"></a>
        </div>

    </aside>
    <section>
        <div class="contenedorSecundario">
            <div class="periodo">

                <h6>DESDE:</h6>
                <input type="date" id="fechaInicio">
                <h6>HASTA:</h6>
                <input type="date" id="fechaFinal">
                <h6>PERIODOS:</h6>
                <select class="listaPeriodos">
                    <option>Primer periodo</option>
                    <option>Segundo periodo</option>
                    <option>Tercer periodo</option>
                </select>
            </div>

            <a href="index.html"><input type="button" class=" botonCancelar " value="Cancelar"></a>
            <a href="crearEvaluacion.html"><input type="button" class=" botonSiguiente" value="Siguiente"></a>
        </div>

    </section>
</div>
</body>

</html>
