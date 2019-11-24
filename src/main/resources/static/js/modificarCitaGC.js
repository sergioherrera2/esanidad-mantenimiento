function modificarCita (){

		var fechaActual = JSON.parse(sessionStorage.getItem("fechaPacienteGC"));
		var fecha = document.getElementById("fecha").value;
		var especialidad = JSON.parse(sessionStorage.getItem("especialidadPacienteGC"));
		var DNI = JSON.parse(sessionStorage.getItem("dniPacienteGC"));
		fecha = fecha + ' 12:30:00';
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
					
					
					/*document.write("<script type='text/javascript' src='js/gestorSistema.js'></script>");
					mostrarCitas ();*/
					alert("OK: se ha procesado correctamente la petición de modificación de la cita.");
					setTimeout(location.href = 'http://localhost:8080/gestorCitas', 10000);
					
					/*sessionStorage.removeItem("fechaPacienteGC");
					sessionStorage.removeItem("especialidadPacienteGC");
					sessionStorage.removeItem("dniPacienteGC");*/
					
	
				} else {
					if (data.type="error") {
						alert("Error: se ha procesado incorrectamente la petición de eliminación de la cita.");
						sessionStorage.removeItem("fechaPacienteGC");
						sessionStorage.removeItem("especialidadPacienteGC");
						sessionStorage.removeItem("dniPacienteGC");
					}
					sessionStorage.removeItem("fechaPacienteGC");
					sessionStorage.removeItem("especialidadPacienteGC");
					sessionStorage.removeItem("dniPacienteGC");
				}
	
			}), 10000);
			
		}