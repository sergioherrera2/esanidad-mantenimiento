if (sessionStorage.getItem("data") == null) {
    alert("no tienes acceso a esta vista");
    location.href = 'http://localhost:8080/'
} else {
    var DNI = JSON.parse(sessionStorage.getItem("data"));
    var recurso = "http://localhost:8080/consultaCentros";
    var datosCentro = [];
    console.log('hola');
    var data = {
        dni: DNI,
        
    };
    data = JSON.stringify(data);
    setTimeout($.ajax({
        url: recurso,
        type: "POST",
        data: data,
        xhrFields: {
            withCredentials: true
        },
        headers: {
            'Content-Type': 'application/json'
        },
    }).done(function(data, textStatus, jqXHR) {
        if (data.type == "OK") {
            for (var i = 0; i < (data.numero); i++) {
                datosCentro[i] = data['nombreCentro' + i];
            }
            
            mostrarCentros(datosCentro);
        }
    }), 10000);
}

function mostrarCentros(datosCentro) {
    var select_centros = "";

    for (var i = 0; i < datosCentro.length; i++) {
        select_centros += '<option>' + datosCentro[i] + '</option>';
    }
    $("#nombreCentro").append(select_centros);
}

function asignarCentro() {
    var dni = document.getElementById("dni").value;
    var especialidad = document.getElementById("centro").value;
    var DNI = JSON.parse(sessionStorage.getItem("data"));

    var recurso = "http://localhost:8080/asignarCentro";
    var data = {
        type: "medico",
        dni: dni,
        centro: centro
    };
    data = JSON.stringify(data);
    setTimeout($.ajax({
            url: recurso,
            type: "POST",
            data: data,
            xhrFields: {
                withCredentials: true
            },
            headers: {
                'Content-Type': 'application/json'
            },
        })
        .done(function(data, textStatus, jqXHR) {
            console.log(data.type);
            console.log(data.message);
            if (data.type == "OK") {
                setTimeout(location.href = 'http://localhost:8080/gestor', 10000);
            } else {
                if (data.type = "error") {
                    alert("Error al asignar centro al médico, contacte con el servicio de soporte.");
                }
            }
        }), 10000);
}

function cerrarSesion() {
    sessionStorage.removeItem("data");
    setTimeout(location.href = 'http://localhost:8080/', 10000);
}