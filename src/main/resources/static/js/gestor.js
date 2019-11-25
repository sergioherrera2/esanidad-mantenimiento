var DNI = JSON.parse(sessionStorage.getItem("data"));
var recurso = "https://app-sanidad.herokuapp.com/consultaEspecialidades";
var datosNombre = [];
var datosDuracion = [];
var datosHoraInicio = [];
var datosHoraFin = [];

var data = {
	dni : DNI,
};
data = JSON.stringify(data);
setTimeout($.ajax({
	url : recurso,
	type : "POST",
	data : data,
	xhrFields : {
		withCredentials : true
	},
	headers : {
		'Content-Type' : 'application/json'
	},
}).done(function(data, textStatus, jqXHR) {
	if (data.type == "OK") {
		for (var i = 0; i < (data.numero); i++) {
			datosNombre[i] = data['nombreEspecialidad' + i];
			datosDuracion[i] = data['tiempoCita'+ i];
			datosHoraInicio[i] = data['horaInicio' + i];
			datosHoraFin[i] = data['horaFin' + i];
		}
		mostrarEspecialidades(datosNombre, datosDuracion, datosHoraInicio, datosHoraFin);
	}
}), 10000);

function mostrarEspecialidades(datosNombre, datosDuracion, datosHoraInicio, datosHoraFin) {
	var cuerpo_especialidades = "";

	for (var i = 0; i < datosNombre.length; i++) {
		var data = {
			nombre: datosNombre[i],
      tiempo: datosDuracion[i],
      inicio: datosHoraInicio[i],
      fin: datosHoraFin[i]
		};
		data = JSON.stringify(data);
		cuerpo_especialidades += '<tr>' + '<td>' + datosNombre[i] + '</td>' + '<td>'
				+ datosDuracion[i] + '</td>' + '<td>' + datosHoraInicio[i] + '</td>' + '<td>' + datosHoraFin[i] + '</td>'
				+ '<td><a id='+ i +' href="javascript:void(0);" onclick="eliminarEspecialidad(id);">' + 'Eliminar' + '</a></td>'
				+ '<td><a id='+ i +' href="javascript:void(0);" onclick="modificarEspecialidad(id);">' + 'Modificar' + '</a></td>' + '</tr>';
	}
	$("#tablaEspecialidadCuerpo").append(cuerpo_especialidades);
}

var recurso = "https://app-sanidad.herokuapp.com/listaMedicos";
var datosDNI = [];
var datosEspecialidad = [];

var data = {
	dni : DNI,
};
data = JSON.stringify(data);
setTimeout($.ajax({
	url : recurso,
	type : "POST",
	data : data,
	xhrFields : {
		withCredentials : true
	},
	headers : {
		'Content-Type' : 'application/json'
	},
}).done(function(data, textStatus, jqXHR) {
	if (data.type == "OK") {
		for (var i = 0; i < (data.numero); i++) {
			datosDNI[i] = data['dni' + i];
			datosEspecialidad[i] = data['especialidad' + i];
		}
		mostrarMedicos(datosDNI, datosEspecialidad);
	}
}), 10000);

function mostrarMedicos(datosDNI, datosEspecialidad) {
	var cuerpo_medico = "";

	for (var i = 0; i < datosDNI.length; i++) {
		var data = {
			dni : datosDNI[i],
			especialidad: datosEspecialidad[i]
		};
		data = JSON.stringify(data);
		cuerpo_medico += '<tr>' + '<td>' + datosDNI[i] + '</td>' + '<td>' + datosEspecialidad[i] + '</td>'
				+ '<td><a id='+ i +' href="javascript:void(0);" onclick="eliminarMedico(id);">' + 'Eliminar' + '</a></td>';
	}
	$("#tablaMedicoCuerpo").append(cuerpo_medico);
}

function eliminarEspecialidad(id) {
	var recurso = "https://app-sanidad.herokuapp.com/eliminarEspecialidad";
	var data = {
		especialidad: datosNombre[id]
	}
	data = JSON.stringify(data);
	setTimeout($.ajax({
		url : recurso,
		type : "POST",
		data : data,
		xhrFields : {
			withCredentials : true
		},
		headers : {
			'Content-Type' : 'application/json'
		},
	}).done(function(data) {
		if (data.type == "OK") {
			console.log(data);
			console.log("especialidad eliminada");
		}
	}), 10000);
}

function eliminarMedico(id) {
	var recurso = "https://app-sanidad.herokuapp.com/eliminarMedico";
	var data = {
		dni: datosDNI[id]
	}
	data = JSON.stringify(data);
	setTimeout($.ajax({
		url : recurso,
		type : "POST",
		data : data,
		xhrFields : {
			withCredentials : true
		},
		headers : {
			'Content-Type' : 'application/json'
		},
	}).done(function(data) {
		if (data.type == "OK") {
			console.log(data);
			console.log("médico eliminado");
		}
	}), 10000);
}

function modificarEspecialidad(id){
	sessionStorage.setItem("tiempo", JSON.stringify(datosDuracion[id]));
	sessionStorage.setItem("inicio", JSON.stringify(datosHoraInicio[id]));
	sessionStorage.setItem("fin", JSON.stringify(datosHoraFin[id]));
	location.href = 'https://app-sanidad.herokuapp.com/modificarEspecialidad'
}

function cerrarSesion (){
	sessionStorage.removeItem("data");
	setTimeout(location.href = 'https://app-sanidad.herokuapp.com/', 10000);
}
