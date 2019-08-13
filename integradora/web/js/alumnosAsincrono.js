$(document).ready(() => {

    $(".cerrar").click((evento) => {
        $("#cs input").val("cerrar");
        $("#cs").attr("action", "UsuarioServlet");
        $("#cs").attr("method", "POST");
        $("#cs").submit();
    });

    $(".docente").click((evento) => {
        $("#dc input").val("redi");
        $("#dc").attr("action", "ServletDocente");
        $("#dc").attr("method", "POST");
        $("#dc").submit();
    });

    $(".carreras").click((evento) => {
        $("#dc input").val("redi");
        $("#dc").attr("action", "ServletCarreras");
        $("#dc").attr("method", "POST");
        $("#dc").submit();
    });

    $("body").on("click", ".btn-Actualizar", function () {
        let formulario = document.getElementById("formAlumno");
        formulario.reset();
        let dataid = this.getAttribute("data-id");
        console.log("dataid Valor: " + dataid);
        $("#idRegistro").val(dataid);
        $.ajax({
            url: "AlumnoServlet",
            method: "POST",
            data: {
                id: dataid,
                accion: "cargarUsuario"
            }
        }).done((response) => {

            /*let json = JSON.parse(response);
            console.log(json);*/
            console.log(response);
            /*$("#matricula").val(json.matricula);
            $("#grupo").val(json.grupo);
            $("#cuatrimestre").val(json.Cuatrimestre.cuatrimestre);
            $("#carrera").val(json.nombreCarrera);*/
        }).fail(() => {
            alert("La peticion no pudo realizarse");
        });
    });
    $("body").on("click", ".btn-danger", function () {
        Swal.fire({
            title: 'Advertencia',
            text: "¿Estás seguro que deseas eliminar?",
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Aceptar',
            cancelButtonText: 'Cancelar'
        }).then((result) => {
            if (result.value) {
                Swal.fire(
                    'Eliminado!',
                    'Eliminado correctamente',
                    'success'
                )
                let dataid = this.getAttribute("data-id");
                let boton = this;
                $.ajax({
                    method: "POST",
                    url: "AlumnoServlet",
                    data: {
                        id: dataid,
                        accion: "eliminar"
                    }
                }).done((response) => {
                    if (response == "true") {
                        //eliminar la fila de la tabla
                        boton.parentElement.parentElement.remove();
                    } else {
                        alert("El registro no pudo eliminarse");
                    }
                }).fail(() => {
                    alert("Fallo la peticion");
                });
            }
        })
    });

    $(".btn-agregar").submit(function () {
        Swal.fire({
            type: 'success',
            title: 'Se inserto correctamente',
            showConfirmButton: false,
            timer: 1500
        });
    });

});
