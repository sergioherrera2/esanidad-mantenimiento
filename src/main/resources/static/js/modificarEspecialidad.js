var tiempo = JSON.parse(sessionStorage.getItem("tiempo"));
var inicio = JSON.parse(sessionStorage.getItem("inicio"));
var fin = JSON.parse(sessionStorage.getItem("fin"));
document.getElementById("tiempoCita").value = tiempo;
document.getElementById("horaInicio").value = inicio;
document.getElementById("horaFin").value = fin;

function modificarEspecialidad (){
	var nombre = JSON.parse(sessionStorage.getItem("nombre"));
	var tiempo = JSON.parse(sessionStorage.getItem("tiempo"));
	var duracionNew = document.getElementById("tiempoCita").value;
	var inicio = JSON.parse(sessionStorage.getItem("inicio"));
	var horaInicioNew = document.getElementById("horaInicio").value;
	var fin = JSON.parse(sessionStorage.getItem("fin"));
	var horaFinNew = document.getElementById("horaFin").value;

	var recurso = "http://localhost:8080/modificarEspecialidad";
	var data = {
		type: "modificar especialidad",
		nombreEspecialidad: nombre,
		duracionNew: duracionNew,
		duracionOld: tiempo,
		horaInicioNew: horaInicioNew,
		horaInicioOld: inicio,
		horaFinNew: horaFinNew,
		horaFinOld: fin
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
			setTimeout(location.href = 'http://localhost:8080/gestor', 10000);
			sessionStorage.removeItem("tiempo");
			sessionStorage.removeItem("inicio");
			sessionStorage.removeItem("fin");
		} else {
			if (data.type="error") {
				alert("Error al modificar la especialidad, contacte con el servicio de soporte.");
				sessionStorage.removeItem("tiempo");
				sessionStorage.removeItem("inicio");
				sessionStorage.removeItem("fin");
			}
			sessionStorage.removeItem("tiempo");
			sessionStorage.removeItem("inicio");
			sessionStorage.removeItem("fin");
		}

	}), 10000);
}