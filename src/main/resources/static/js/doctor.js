
	
	var año = (document.getElementById("fecha").value).substr(0,4);
	var mes = (document.getElementById("fecha").value).substr(5,2);
	var dia = (document.getElementById("fecha").value).substr(8,2);

	var fecha = dia+'/'+mes+'/'+año+' 00:00:00';
	console.log(fecha);
	var especialidadD = document.getElementById("especialidadDoctor").value = JSON.parse(sessionStorage.getItem("especialidadMedico"));
	var hola = document.getElementById("especialidadDoctor");
	hola.value = 'hola';
	
function cambioRolPaciente(){
	
	setTimeout(location.href = 'http://localhost:8080/paciente', 10000);
}

/*var DNI = JSON.parse(sessionStorage.getItem("dniDoctor"));
var recurso = "http://localhost:8080/getCitas";
var datosDNIP = [];
var datosES = [];
var datosF = [];
var datosH = [];



var data = {
	dni : DNI,
	fecha : Fecha,
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
}), 10000);*/

/*
 * var datos = [cita1 :{ "fecha": "12/05/19", "hora": "15:01", "centroDeSalud":
 * "LA SOLANA", "especialidad": " ONCOLOGÍA", }, { "fecha": "12/12/19", "hora":
 * "15:41", "centroDeSalud": "MANZANARES", "especialidad": " ONCOLOGÍA", }, {
 * "fecha": "11/05/19", "hora": "05:01", "centroDeSalud": "TOLEDO",
 * "especialidad": " ONCOLOGÍA", }, { "fecha": "12/05/29", "hora": "12:01",
 * "centroDeSalud": "CIUDAD REAL", "especialidad": " ONCOLOGÍA", } ];
 */
/*function eliminarCita(id) {
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
			setTimeout(location.href = 'http://localhost:8080/paciente', 10000);
		}
	}), 10000);
}*/


/*function mostrarContenido(datosDNIP,datosES,datosF) {
	var cuerpo = "";
	

	var cabecera = '<tr>' + '<th>FECHA</th>' + '<th>HORA</th>'
			+'<th>DNI PACIENTE</th>'+'<th>ESPECIALIDAD</th>' + '</tr>';

	for (var i = 0; i < datosDNIP.length; i++) {
		var data = {
			dniPaciente : datosDNIP[i],
			especialidad : datosES[i],
			fecha :  datosF[i]
		};
		data = JSON.stringify(data);
		cuerpo += '<tr>' + '<td>' + datosF[i] + '</td>' + '<td>'
				+ datosDNIP[i] + '</td>' + '<td>' + datosES[i]
				+ '</td>' + '<td><a id='+i+' href="javascript:void(0);" onclick="eliminarCita(id);">' + 'Eliminar' + '</a></td>' + '</tr>';
	}
	$("#tablaCabecera").append(cabecera);
	$("#tablaCuerpo").append(cuerpo);
}*/
/*function cerrarSesion (){
	
	sessionStorage.removeItem("dniDoctor");
	setTimeout(location.href = 'http://localhost:8080/', 10000);
	
}*/