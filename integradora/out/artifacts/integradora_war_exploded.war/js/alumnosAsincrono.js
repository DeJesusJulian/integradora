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
    /*
        $("body").on("click", ".btn-agregar", (evento) => {
            let formulario = document.getElementById("formUsuario");
            formulario.reset();
            $("#idRegistro").val("");
            $(".btn-registrar").html("Registrar");
            $(".modal-title").html("Registrar usuario");
        });
     */
    $("body").on("click", ".btn-Actualizar", function () {
        let formulario = document.getElementById("formAlumno");
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
            url: "AlumnoServlet",
            method: "POST",
            data: {
                id: dataid,
                accion: "cargarUsuario"
            }
        }).done((response) => {
            let json = JSON.parse(response);
            $("#matricula").val(json.matricula);
            $("#grupo").val(json.grupo);
            $("#cuatrimestre").val(json.Cuatrimestre.cuatrimestre);
            $("#carrera").val(json.nombreCarrera);
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

    /*$(".btn-registrar").click(function () {
        //obtener los datos del formulario
        // let formulario = document.getElementById("formAlumno");
        let formulario = document.getElementById("formAlumno");
        let datos = new FormData(formulario);
        //cuando usamos el formData usa el name que le ponemos a la etiqueta no el id
        if ($("#idRegistro").val() == "") {
            datos.append("accion", "registrar");
        } else {
            datos.append("accion", "actualizar");
        }
        //llamamos asincrona para enviar los datos al servlet

        $.ajax({
            url: "AlumnoServlet",
            method: "POST",
            processData: false,
            contentType: false,
            data: datos,
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
                $("#matricula").focus();
            } else if (response == "Ok") {
                Swal.fire({
                    type: 'success',
                    title: 'Se inserto correctamente',
                    showConfirmButton: false,
                    timer: 1500
                });
                $("#matricula").focus();
            } else {
                alert("Algo paso!");
            }
        }).fail(() => {
            alert("La peticion no pudo realizarse");
        }).always(() => {
            $.ajax({
                url: "AlumnoServlet",
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
                    let matriculaCelda = document.createElement("td");
                    let carreraCelda = document.createElement("td");
                    let accionesCelda = document.createElement("td");
                    let grupoCelda = document.createElement("td");
                    let cuatrimestreCelda = document.createElement("td");
                    let gTexto = document.createTextNode(arreglo[i].grupo);
                    let cuTexto = document.createTextNode(arreglo[i].cuatrimestre.cuatrimestre)
                    let mTexto = document.createTextNode(arreglo[i].matricula);
                    let caTexto = arreglo[i].carrera.nombreCarrera;
                    let input = document.createElement("input");
                    console.log(caTexto);


                    matriculaCelda.appendChild(mTexto);
                    cuatrimestreCelda.appendChild(cuTexto);
                    grupoCelda.appendChild(gTexto);
                    carreraCelda.appendChild(input);

                    let bEleminar = document.createElement("button");
                    bEleminar.className = "btn btn-danger";
                    bEleminar.setAttribute("data-id", arreglo[i].matricula);

                    //let iEliminar = document.createElement("i");
                    //iEliminar.className = "fas fa-user-times";
                    let etexto = document.createTextNode("Borrar");
                    bEleminar.appendChild(etexto);

                    let bActualizar = document.createElement("button");
                    bActualizar.className = "btn btn-primary btn-Actualizar";
                    bActualizar.setAttribute("data-id", arreglo[i].matricula);
                    bActualizar.setAttribute("data-toggle", "modal");
                    bActualizar.setAttribute("data-target", "#exampleModal");
                    bActualizar.setAttribute("value", "Editar");
                    let edtexto = document.createTextNode("Editar");
                    bActualizar.appendChild(edtexto);

                    input.setAttribute("type", "text");
                    input.setAttribute("value", "" + caTexto);
                    input.setAttribute("disabled", "disabled");
                    //input.value = "" + caTexto;

                    let iActualizar = document.createElement("i");
                    iActualizar.className = "fas fa-user-edit";
                    bActualizar.appendChild(iActualizar);

                    accionesCelda.appendChild(bActualizar);
                    accionesCelda.appendChild(bEleminar);

                    fila.appendChild(matriculaCelda);
                    fila.appendChild(cuatrimestreCelda);
                    fila.appendChild(grupoCelda);
                    fila.appendChild(carreraCelda);
                    fila.appendChild(accionesCelda);

                    tbody.appendChild(fila);
                }
            });
        });
    });*/
});
