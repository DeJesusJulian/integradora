$(document).ready(() => {
    //para botones fijos
    //$(".btn btn-danger").click(function(){...})
    //para botones denamicos
    console.log("entre")
    $(".cerrar").click((evento) => {
        $("#cs input").val("cerrar");
        $("#cs").attr("action", "UsuarioServlet");
        $("#cs").attr("method", "POST");
        $("#cs").submit();
    });
    $(".docente").click((evento) => {
        $("#dc input").val("docentes");
        $("#dc").attr("action", "ServletDocente");
        $("#dc").attr("method", "GET");
        $("#dc").submit();
    });

    $("body").on("click", ".btn-Actualizar", function () {
        let formulario = document.getElementById("formDoc");
        formulario.reset();
        let dataid = this.getAttribute("data-id");
        console.log("dataid Valor: " + dataid);
        /* if (evento.target.getAttribute("data-id") == null) {
             dataid = evento.target.parentElement.getAttribute("data-id");
         } else {
             dataid = evento.target.getAttribute("data-id");
         }*/
        $("#idRegistro").val(dataid);
        /*
        $(".btn-registrar").html("Actualizar");
        $(".modal-title").html("Actualizar registro");
        */
        $.ajax({
            url: "ServletDocente",
            method: "POST",
            data: {
                id: dataid,
                accion: "cargarUsuario"
            }
        }).done((response) => {
            let json = JSON.parse(response);
            $("#nombreDoc").val(json.nombreDocente);
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
                    url: "ServletDocente",
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
////////////////////////////////////////////////////

///////////////////////////////////////////////////
    $(".btn-agregar").submit(function () {
        Swal.fire({
            type: 'success',
            title: 'Se inserto correctamente',
            showConfirmButton: false,
            timer: 1500
        });
    });
});
