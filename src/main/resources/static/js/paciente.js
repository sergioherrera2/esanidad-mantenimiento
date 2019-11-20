var DNI = JSON.parse(sessionStorage.getItem("data"));
var recurso = "http://localhost:8080/citasPaciente";
var datosDNIP = [];
var datosES = [];
var datosF = [];
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
		console.log("FUNCIONA");

		for (var i = 0; i < (data.numero); i++) {

			datosDNIP[i] = data['dniPaciente' + i];
			datosES[i] = data['especialidad' + i];
			datosF[i] = data['fecha'+ i];
		}
		mostrarContenido(datosDNIP,datosES,datosF);
	}
	$("#table-basic").DataTable();
}), 10000);

/*
 * var datos = [cita1 :{ "fecha": "12/05/19", "hora": "15:01", "centroDeSalud":
 * "LA SOLANA", "especialidad": " ONCOLOGÍA", }, { "fecha": "12/12/19", "hora":
 * "15:41", "centroDeSalud": "MANZANARES", "especialidad": " ONCOLOGÍA", }, {
 * "fecha": "11/05/19", "hora": "05:01", "centroDeSalud": "TOLEDO",
 * "especialidad": " ONCOLOGÍA", }, { "fecha": "12/05/29", "hora": "12:01",
 * "centroDeSalud": "CIUDAD REAL", "especialidad": " ONCOLOGÍA", } ];
 */
function eliminarCita(id) {
	var recurso = "http://localhost:8080/anularCita";
	var data = {
		dniPaciente : datosDNIP[id],
		especialidad : datosES[id],
		fecha : datosF[id]
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
			console.log("eliminar");
			console.log(data);
		}
	}), 10000);
}

function modificarCita(id){
	sessionStorage.setItem("fecha", JSON.stringify(datosF[id]));
	sessionStorage.setItem("dni", JSON.stringify(datosDNIP[id]));
	sessionStorage.setItem("especialidad", JSON.stringify(datosES[id]));
	location.href = 'https://app-sanidad.herokuapp.com/modificarCita'
}

function mostrarContenido(datosDNIP,datosES,datosF) {
	var cuerpo = "";
	var recurso = "http://localhost:8080/anularCita";

	var cabecera = '<tr>' + '<th>FECHA</th>' + '<th>DNI PACIENTE</th>'
			+ '<th>ESPECIALIDAD</th>' + '</tr>';

	for (var i = 0; i < datosDNIP.length; i++) {
		var data = {
			dniPaciente : datosDNIP[i],
			especialidad : datosES[i],
			fecha :  datosF[i]
		};
		data = JSON.stringify(data);
		cuerpo += '<tr>' + '<td>' + datosF[i] + '</td>' + '<td>'
				+ datosDNIP[i] + '</td>' + '<td>' + datosES[i]
				+ '</td>' + '<td><a id='+i+' href="javascript:void(0);" onclick="eliminarCita(id);">' + 'Eliminar' + '</a></td>' + '<td><a id='+i+' href="javascript:void(0);" onclick="modificarCita(id);">' + 'Modificar' + '</a></td>' + '</tr>';
	}
	$("#tablaCabecera").append(cabecera);
	$("#tablaCuerpo").append(cuerpo);
}
function cerrarSesion (){
	
	sessionStorage.removeItem("data");
	setTimeout(location.href = 'http://localhost:8080/', 10000);
	
}
