function pedirCita() {
    var fecha = document.getElementById("fecha").value;
    var especialidad = document.getElementById("especialidad").value;
    var DNI = JSON.parse(sessionStorage.getItem("data"));

    var recurso = "http://localhost:8080/pedirCita";
        var data = {
            type: "cita",
            dniPaciente: DNI,
            fecha : fecha,
            especialidad : especialidad
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
            if (data.type == "OK") {
            	
                setTimeout(location.href = 'http://localhost:8080/paciente', 10000);

            } else {
                if (data.type="error") {
                    alert("Error al crear cita, contacte con el servicio de soporte.");
                }
                

            }

        }), 10000);
        
    }