<%--
  Created by IntelliJ IDEA.
  User: Alfonso Maldonado
  Date: 02/08/2019
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--------------------------------------------------------------------------------------------------------->
<c:if test="${usuario==null}">
    <c:redirect url="/index.jsp"></c:redirect>
</c:if>
<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="css/docentes.css">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="js/jquery-3.4.1.min.js" type="application/javascript"></script>
    <script src="js/ajax.js"></script>
    <script src="js/bootstrap.min.js" type="application/javascript"></script>
    <script src="js/all.min.js" type="application/javascript"></script>
    <script src="js/sweetalert2.min.js" type="application/javascript"></script>
    <script src="js/carrerasAsincrono.js" type="application/javascript"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/all.min.css" type="text/css">
    <link rel="stylesheet" href="css/sweetalert2.min.css">
    <title>docentes</title>
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
            <a href="docentes.html"><input type="button" class="boton" value="DOCENTES"></a>
            <a href="preguntas.html"><input type="button" class="boton" value="PREGUNTAS"></a>
            <a href="alumnos.html"><input type="button" class="boton" value="ALUMNOS"></a>
            <a href="carreras.html"><input type="button" class=" boton" value="CARRERAS"></a>
        </div>

    </aside>
    <section>
        <div class="cajaDocente">
            <h6>CARRERAS</h6>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Busca una carrera"
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
                        <th>
                            Carrera
                        </th>
                        <th>
                            Acci&oacute;n
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${carreras}" var="carrera">
                        <tr>
                            <td>${carrera.nombreCarrera}</td>
                            <td>
                                <button data-id="${carrera.idCarreras}" class="btn btn-primary">Editas</button>
                                <button data-id="${carrera.idCarreras}" class="btn btn-danger">Borrar</button>
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
                                <h5 class="modal-title" id="exampleModalLabel">Editar esta carrera</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Carrera:</label>
                                        <input type="text" class="form-control" id="recipient-name">
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
                                <h5 class="modal-title" id="exampleModalLabel">Agregar carrera</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="form-group">
                                        <label for="recipient-name" class="col-form-label">Carrera nueva:</label>
                                        <input type="text" class="form-control" id="recipient-name">
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary"
                                        data-dismiss="modal">Cancelar
                                </button>
                                <button type="button" class="btn btn-primary">Agregar</button>
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
