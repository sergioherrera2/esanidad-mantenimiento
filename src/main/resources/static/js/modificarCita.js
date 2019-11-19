function modificarCita (){

		var fechaActual = JSON.parse(sessionStorage.getItem("fecha"));
		var fecha = document.getElementById("fecha").value;
		var especialidad = JSON.parse(sessionStorage.getItem("especialidad"));
		var DNI = JSON.parse(sessionStorage.getItem("dni"));
	
	  fecha =fecha.substring(8,10)+fecha.substring(4,8)+fecha.substring(0,4)+fecha.substring(10,fecha.length)+":00";
	  fecha=fecha.replace("T"," ");
	  fecha=fecha.replace("-","/");
	  fecha=fecha.replace("-","/");
		var recurso = "http://localhost:8080/modificarCita";
			var data = {
				type: "cita",
				dniPaciente: DNI,
				fechaActual : fechaActual,
				fechaModificar : fecha,
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
					sessionStorage.removeItem("fecha");
					sessionStorage.removeItem("especialidad");
					sessionStorage.removeItem("dni");
	
				} else {
					if (data.type="error") {
						alert("Error al crear cita, contacte con el servicio de soporte.");
						sessionStorage.removeItem("fecha");
						sessionStorage.removeItem("especialidad");
						sessionStorage.removeItem("dni");
					}
					sessionStorage.removeItem("fecha");
					sessionStorage.removeItem("especialidad");
					sessionStorage.removeItem("dni");
				}
	
			}), 10000);
			
		}