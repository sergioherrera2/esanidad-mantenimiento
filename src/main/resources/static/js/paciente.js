var DNI = JSON.parse(sessionStorage.getItem("data"));
var recurso = "http://localhost:8080/citasPaciente";
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

		var datosDNIP = [];
		var datosES = [];
		var datosF = [];
		for (var i = 0; i < (data.numero); i++) {

			datosDNIP[i] = data['dniPaciente' + i];
			datosES[i] = data['especialidad' +i];
			datosF[i] = data['fecha'+i];
		}
		mostrarContenido(datosDNIP,datosES,datosF);
	}

}), 10000);

/*
 * var datos = [cita1 :{ "fecha": "12/05/19", "hora": "15:01", "centroDeSalud":
 * "LA SOLANA", "especialidad": " ONCOLOGÍA", }, { "fecha": "12/12/19", "hora":
 * "15:41", "centroDeSalud": "MANZANARES", "especialidad": " ONCOLOGÍA", }, {
 * "fecha": "11/05/19", "hora": "05:01", "centroDeSalud": "TOLEDO",
 * "especialidad": " ONCOLOGÍA", }, { "fecha": "12/05/29", "hora": "12:01",
 * "centroDeSalud": "CIUDAD REAL", "especialidad": " ONCOLOGÍA", } ];
 */

function mostrarContenido(datosDNIP,datosES,datosF) {
	var cuerpo = "";
	var cabecera = '<tr>' + '<th>FECHA</th>' + '<th>DNI PACIENTE</th>'
			+ '<th>ESPECIALIDAD</th>' + '</tr>';

	for (var i = 0; i < datosDNIP.length; i++) {
	
		cuerpo += '<tr>' + '<td>' + datosF[i] + '</td>' + '<td>'
				+ datosDNIP[i] + '</td>' + '<td>' + datosES[i]
				+ '</td>' + '</tr>';
	}
	$("#tablaCabecera").append(cabecera);
	$("#tablaCuerpo").append(cuerpo);
}
function cerrarSesion (){
	
	sessionStorage.removeItem("data");
	setTimeout(location.href = 'http://localhost:8080/', 10000);
	
}