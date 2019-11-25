
function mandarDatosEnter(event) {

	if (event.keyCode === 13) {
		validateLogin();
	}

}

function validateLogin() {
	var Dni = document.getElementById("username").value;
	var contraseña = document.getElementById("password").value;

	controlLogin(Dni, contraseña);

	function mandarDatos(Dni, contraseña) {
		var recurso = "http://localhost:8080/autenticar";
		var data = {
			dni : Dni,
			pass : contraseña,
		};
		data = JSON.stringify(data);
		setTimeout(
				$
						.ajax({
							url : recurso,
							type : "POST",
							data : data,
							xhrFields : {
								withCredentials : true
							},
							headers : {
								'Content-Type' : 'application/json'
							},
						})
						.done(
								function(data, textStatus, jqXHR) {
									console.log(data.type + "HOLA");
									if (data.type == "OK") {
										
										
										
										if(data.especialidad == 'Gestor Citas'){
											
											setTimeout(location.href = 'http://localhost:8080/gestorCitas',10000);
										}else{
											if(data.especialidad == 'Gestor Sistema') {
												setTimeout(location.href = 'http://localhost:8080/gestor',10000);
											} else {
											
											if (data.especialidad != null && data.especialidad != undefined && data.especialidad != 'Gestor Citas' && data.especialidad != 'Gestor Sistema') {
												sessionStorage.setItem("dniDoctor",JSON.stringify(Dni))
												sessionStorage.setItem("especialidadMedico",JSON.stringify(data.especialidad));
											}else{
												sessionStorage.setItem("data", JSON.stringify(Dni));
											}
											setTimeout(location.href = 'http://localhost:8080/paciente',10000);
										}
										
										}

									} else {

										if (data.type == "error") {
											alert("¡Las contraseña o el DNI introducido son incorrectos!");
										}

										console.log(data.message);
									}

								}), 10000);

	}

	function controlLogin(Dni, contraseña) {

		if (Dni == '' || contraseña == '') {
			alert("¡Debes de rellenar el campo DNI y el campo contraseña!");
		} else {
			if (Dni != '' && contraseña != '') {
				mandarDatos(Dni, contraseña);
			}
		}

	}

}
