<%--
  Created by IntelliJ IDEA.
  User: Alfonso Maldonado
  Date: 01/08/2019
  Time: 09:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">

<head>
    <link rel="stylesheet" href="css/login.css">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/all.min.js"></script>
    <script src="js/fontawesome.min.js"></script>
    <script src="js/sweetalert2.min.js"></script>
    <script src="js/alumnosAsincrono.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/sweetalert2.min.css" type="text/css">
    <link rel="stylesheet" href="css/all.min.css" type="text/css">
    <link rel="stylesheet" href="css/fontawesome.min.css" type="text/css">
    <title>index</title>
</head>
<body>
<div class="contenedor">
    <header>
        <div class="container titulos">
            <h2 class="titulo1">SIED</h2>
            <h5 class="titulo2">Sistema De Evaluaci&oacute;n Docente</h5>
        </div>
    </header>
    <aside>
        <div class="formulario">
            <div class="formulario2">
                <img src="src/usuario.png" alt="imagen de usuario" id="imgUsuario">
                <form role="form" action="UsuarioServlet" method="post" id="form">
                    <div class="form-group">
                        <label for="email">Usuario</label>
                        <div class="input-group-prepend">
                            <div class="input-group-text"><i class="fas fa-user"></i></div>
                            <input type="text" class="form-control" name="email" id="email"
                                   placeholder="Ingresa tu usuario">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pwd">Contraseña</label>
                        <div class="input-group-append">
                            <div class="input-group-text"><i class="fas fa-lock"></i></div>
                            <input type="password" class="form-control" name="pwd" id="pwd"
                                   placeholder="Ingresa tu usuario">
                        </div>
                    </div>
                    <div class="botonIniciar">
                        <input type="hidden" value="login" name="accion"/>
                        <input type="submit" class=" boton" value="INICIAR" id="boton"/>
                    </div>
                </form>
            </div>
        </div>
    </aside>
</div>
<script>
    let msj = "${error}";
    if (msj == "El nombre de usuario o contraseña no existen") {
        Swal.fire({
            type: 'error',
            title: 'Error',
            text: 'Usuario o contraseña incorrectos',
        });
    }
</script>
</body>
</html>
