<%--
  Created by IntelliJ IDEA.
  User: Alfonso Maldonado
  Date: 01/08/2019
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:if test="${usuario==null}">
    <c:redirect url="/index.jsp"></c:redirect>
</c:if>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/docentes.css">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="js/jquery-3.4.1.min.js" type="application/javascript"></script>
    <script src="js/ajax.js"></script>
    <script src="js/bootstrap.min.js" type="application/javascript"></script>
    <script src="js/all.min.js" type="application/javascript"></script>
    <script src="js/sweetalert2.min.js" type="application/javascript"></script>
    <script src="js/alumnosAsincrono.js" type="application/javascript"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/all.min.css" type="text/css">
    <link rel="stylesheet" href="css/sweetalert2.min.css">
    <title>Alumnos</title>
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
        </div>
    </aside>
    <section>
        <div class="cajaDocente">
            <h6>ALUMNOS</h6>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Busca una carrera"
                       aria-label="Search">
                <button class="btn btn-outline-success " type="submit" id="btnAñadir">Buscar</button>
                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#modalRegistrar"
                        data-whatever="@mdo">Agregar
                </button>
            </form>
            <div id="cajaTabla">
                <table class="table table-striped ">
                    <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Carrera</th>
                        <th>Acci&oacute;n</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${alumnos}" var="alumno">
                        <tr>
                            <td>${alumno.matricula}</td>
                            <td>${alumno.grupo}</td>
                            <td>${alumno.cuatrimestre.cuatrimestre}</td>
                            <td><input type="text" class="carreraAlumno" value="${alumno.carrera.nombreCarrera}"
                                       disabled></td>
                            <td>
                                <button type="button" data-id="${alumno.matricula}"
                                        class="btn btn-primary btn-Actualizar" data-toggle="modal"
                                        data-target="#modalActualizar" data-whatever="@mdo">Editar
                                </button>
                                <button data-id="${alumno.matricula}" class="btn btn-danger">Borrar</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <!--inicio--->
                <div class="modal fade" id="modalRegistrar" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Registrar alumno</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="AlumnoServlet" method="post" id="formAlumnoRegistro">
                                    <div class="form-group">
                                        <label for="matricula" class="col-form-label">Matricula :</label>
                                        <input type="text" class="form-control" id="matriculaRe" name="matriculaRe">
                                        <label>Grupo: </label>
                                        <input type="text" class="form-control" name="grupoRe" id="grupoRe">
                                        <label>Cuatrimestre: </label>
                                        <select name="cuatrimestreRe" id="cuatrimestreRe">
                                            <c:forEach items="${cuatrimestres}" var="cuatrimestre">
                                                <option value="${cuatrimestre.idCuatrimestre}">${cuatrimestre.cuatrimestre}</option>
                                            </c:forEach>
                                        </select>
                                        <label class="col-form-label">Carrera</label>
                                        <select name="carreraRe" id="carreraRe">
                                            <c:forEach items="${carreras}" var="carrera">
                                                <option value="${carrera.idCarreras}">${carrera.nombreCarrera}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <!---<input type="hidden" value="" name="id" id="idRegistroModal"-->
                                    <div class="modal-footer">
                                        <input name="accion" type="hidden" value="registrar">
                                        <button type="button" class="btn btn-secondary"
                                                data-dismiss="modal">Cancelar
                                        </button>
                                        <button type="submit" class="btn btn-primary btn-agregar">Agregar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!--final-->

                <!--Inicio modal 2-->
                <div class="modal fade" id="modalActualizar" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel2">Modificar alumno</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form action="AlumnoServlet" method="post" id="formAlumno">
                                    <div class="form-group">
                                        <label for="matricula" class="col-form-label">Matricula :</label>
                                        <input type="text" class="form-control" id="matricula" name="matricula">
                                        <label>Grupo: </label>
                                        <input type="text" class="form-control" name="grupo" id="grupo">
                                        <div>
                                            <label>Cuatrimestre: </label>
                                            <select name="cuatrimestre" id="cuatrimestre">
                                                <c:forEach items="${cuatrimestres}" var="cuatrimestre">
                                                    <option value="${cuatrimestre.idCuatrimestre}">${cuatrimestre.cuatrimestre}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div>
                                            <label class="col-form-label">Carrera</label>
                                            <select name="carrera" id="carrera">
                                                <c:forEach items="${carreras}" var="carrera">
                                                    <option value="${carrera.idCarreras}">${carrera.nombreCarrera}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <input type="hidden" value="" name="id" id="idRegistro">
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                <button type="button" class="btn btn-primary btn-registrar">Registrar</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!---final--->
            </div>
        </div>
    </section>
</div>
</body>
</html>