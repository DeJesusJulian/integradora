$(document).ready(() => {
    //para botones fijos
    //$(".btn btn-danger").click(function(){...})
    //para botones denamicos
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
        $("#idModificar").val(dataid);
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
                    url: "ServletCarreras",
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
///////////////////////////////////////////////
    /* $("body").on("click", ".btn-Actualizar", (evento) => {
         let formulario = document.getElementById("formDoc");
         formulario.reset();
         $("#idRegistro").val("");
     });*/
////////////////////////////////////////////////////
    $(".btn-modificar").click(function () {
        //obtener los datos del formulario
        // let formulario = document.getElementById("formAlumno");
        let formulario = document.getElementById("formDoc");
        let datos = new FormData(formulario);
        //cuando usamos el formData usa el name que le ponemos a la etiqueta no el id
        if ($("#idModificar").val() != "") {
            datos.append("accion", "editar");
        } else {
            datos.append("accion", "editar");
        }
        //llamamos asincrona para enviar los datos al servlet

        $.ajax({
            url: "ServletDocente",
            method: "POST",
            processData: false,
            contentType: false,
            data: {
                data: datos,
                accion: "editar",
            },
        }).done((response) => {
            if (response == "true") {
                //alert("El registro se inserto correctamente");
                Swal.fire({
                    type: 'success',
                    title: 'Se inserto correctamente',
                    showConfirmButton: false,
                    timer: 1500
                })
                formulario.reset();
                $("#nombreDoc").focus();
            } else if (response == "Ok") {
                Swal.fire({
                    type: 'success',
                    title: 'Se inserto correctamente',
                    showConfirmButton: false,
                    timer: 1500
                });
                $("#nombreDoc").focus();
            } else {
                alert("Algo paso!");
            }
        }).fail(() => {
            alert("La peticion no pudo realizarse");
        }).always(() => {
            $.ajax({
                url: "ServletDocente",
                method: "POST",
                data: {
                    accion: "cargar"
                }
            }).done((response) => {
                let tbody = document.querySelector("table tbody");
                while (hijo = tbody.lastChild) {
                    tbody.removeChild(hijo);
                }
                let arreglo = JSON.parse(response);

                for (let i in arreglo) {
                    //console.log(arreglo[i].usuario);
                    let fila = document.createElement("tr");
                    let nombreCelda = document.createElement("td");
                    let accionesCelda = document.createElement("td");
                    let nombreTexto = document.createTextNode(arreglo[i].nombreDocente);

                    nombreCelda.appendChild(nombreTexto);

                    let bEleminar = document.createElement("button");
                    bEleminar.className = "btn btn-danger";
                    bEleminar.setAttribute("data-id", arreglo[i].idDocente);

                    //let iEliminar = document.createElement("i");
                    //iEliminar.className = "fas fa-user-times";
                    let etexto = document.createTextNode("Borrar");
                    bEleminar.appendChild(etexto);

                    let bActualizar = document.createElement("button");
                    bActualizar.className = "btn btn-primary btn-Actualizar";
                    bActualizar.setAttribute("data-id", arreglo[i].idDocente);
                    bActualizar.setAttribute("data-toggle", "modal");
                    bActualizar.setAttribute("data-target", "#editarDocente");
                    bActualizar.setAttribute("value", "Editar");
                    let edtexto = document.createTextNode("Editar");
                    bActualizar.appendChild(edtexto);

                    accionesCelda.appendChild(bActualizar);
                    accionesCelda.appendChild(bEleminar);

                    fila.appendChild(nombreCelda);
                    fila.appendChild(accionesCelda);

                    tbody.appendChild(fila);
                }
            });
        });
    });
///////////////////////////////////////////////////
});
