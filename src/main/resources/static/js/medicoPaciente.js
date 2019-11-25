function crearMedicoPaciente() {
    var medico = document.getElementById("dniMedico").value;
    var paciente = document.getElementById("dniPaciente").value;

    var recurso = "http://localhost:8080/crearMedicoPaciente";
    var data = {
        type: "medico-paciente",
        dniMedico: medico,
        dniPaciente: paciente
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
            if (data.type="error") {
                alert("Error al crear la relación médico-paciente, contacte con el servicio de soporte.");
            }
        }
    }), 10000);
}

function cerrarSesion (){
    sessionStorage.removeItem("data");
    setTimeout(location.href = 'http://localhost:8080', 10000);
}
