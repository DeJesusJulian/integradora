<%--
  Created by IntelliJ IDEA.
  User: Alfonso Maldonado
  Date: 07/08/2019
  Time: 04:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="css/docentes.css">
    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="js/jquery-3.4.1.min.js" type="application/javascript"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/all.min.js"></script>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/all.min.css">
    <title>docentes</title>
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
            <a href="ServletPregunta1">
                <button class="boton">PREGUNTAS</button>
            </a>
            <a href="AlumnoServlet">
                <button class="boton">ALUMNOS</button>
            </a>
            <a href="ServletDocente">
                <button class="boton">CARRERAS</button>
            </a>
            <form action="" id="dc">
                <input type="hidden" name="accion">
            </form>
        </div>

    </aside>
    <section>
        <div class="menuSuperior">
            <div class="losBotones">
                <a href="ServletPregunta1"><input type="button" class="opcionMenuSuperior" value="plantilla 1"></a>
                <a href="ServletPregunta2"><input type="button" class="opcionMenuSuperior" value="plantilla 2"></a>
                <a href="ServletPregunta3"><input type="button" class="opcionMenuSuperior" value="plantilla 3"></a>
            </div>
            <div>
                <label class="DescripcionPlantilla">
                    <strong>Plantilla 2 </strong>rubrica: COMENTARIOS
                </label>
            </div>
        </div>
        <div class="cajaDocente">
            <h6>PREGUNTAS</h6>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Busca una pregunta"
                       aria-label="Search">
                <button class="btn btn-outline-success " type="submit" id="btnAñadir">Buscar</button>
                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal2"
                        data-whatever="@mdo">Agregar
                </button>
            </form>
            <div id="cajaTabla">
                <table class="table table-striped ">
                    <thead>
                    <tr>
                        <th>idPregunta</th>
                        <th>pregunta</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${preguntas}" var="pregunta">
                        <tr>
                            <td>${pregunta.idPregunta}</td>
                            <td>${pregunta.pregunta}</td>
                            <td>
                                <button type="button" class="btn btn-primary" data-toggle="modal"
                                        data-target="#exampleModal" data-whatever="@mdo">Editar
                                </button>
                                <a href=""><input type="button" value="Borrar" class="btn btn-danger"></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Editar esta pregunta</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Pregunta:</label>
                                        <input type="text" class="form-control" id="recipient-name">

                                        <label for="recipient-name" class="col-form-label">Tipo de pregunta:</label>
                                        <select>
                                            <option>Evaluaci&oacute;n</option>
                                            <option>Comentarios/Abierta</option>
                                            <option>Desempe&ntilde;o</option>

                                        </select>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary"
                                        data-dismiss="modal">Cancelar
                                </button>
                                <button type="button" class="btn btn-primary">Actualizar</button>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Agregar pregunta</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="ServletPregunta2" method="post">
                                    <div class="form-group">
                                        <label for="pregunta" class="col-form-label">Pregunta:</label>
                                        <input type="text" class="form-control" id="pregunta" name="pregunta">
                                    </div>
                                    <div class="modal-footer">
                                        <input type="hidden" value="registrar" name="accion">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar
                                        </button>
                                        <button type="submit" class="btn btn-primary">Registrar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>
