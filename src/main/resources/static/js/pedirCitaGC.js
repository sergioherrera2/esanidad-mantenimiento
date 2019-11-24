var contenidoDespegable = true;
var estadoMostrarHora = true;
var inputDNI = document.getElementById("dni").value = JSON.parse(sessionStorage.getItem("dniPacienteGC"));







function controlTipodni() {
	
	var Dni = document.getElementById("dni").value;
    var letraDNI = Dni.charAt(Dni.length - 1);
    
    var numeroDNI = parseInt(Dni.substr(0, Dni.length - 1));
    var numeroDNIString = Dni.substr(0, Dni.length - 1);
    
   
    if (((Number.isInteger(numeroDNI) == false) && (isNaN(letraDNI) == false)) || (numeroDNIString.length != 8)) {
        alert("¡Has introducido el DNI incorrectamente!");
    } else {
        var cadena = "TRWAGMYFPDXBNJZSQVHLCKET";
        var posicion = numeroDNI % 23;
        var letra = cadena.substring(posicion, posicion + 1);
       
        var dniComparar = numeroDNI + letra;
        var dniComparar2 = numeroDNI + letra;
        if(letraDNI != letra) {
            alert("¡Has introducido mal la letra de su DNI!");
        }else{
        	if(dniComparar == dniComparar2){
        		
        		pedirCita ();
        	}
        }
    }


}


function mostrarEspecializaciones(){
	var nombreEspecialidad = [];
	var duracionCita = [];
	var horaInicio = [];
	var horaFin = [];
	
	
	if(contenidoDespegable == true){
    var recurso = "http://localhost:8080/consultaEspecialidades";
        var data = {
           dni:""
        };
        data = JSON.stringify(data);

        setTimeout($.ajax({
                url: recurso,
                type: "POST",
                data: data,
                headers: {
                    'Content-Type': 'application/json'
                },
            })
        .done(function(data, textStatus, jqXHR) {
            console.log(data.type);
            if (data.type == "OK") {
            	var combo = document.getElementById("especialidad");
            	for (var i = 0; i < (data.numero); i++) {

            	  
            			  
            			
            		nombreEspecialidad[i] = data['nombreEspecialidad' + i];
            		duracionCita[i] = data['duracionCita' + i];
            		horaInicio[i] = data['horaInicio'+ i];
            		horaFin[i] = data['horaFin'+ i];
            		
            		var x = document.getElementById("especialidad");
            		var option = document.createElement("option");
            		option.text = nombreEspecialidad[i];
            		x.add(option);
            		contenidoDespegable = false;
            	
            		
        		}
            	
            	
                
            	
            } else {
                if (data.type="error") {
                    alert("Error al obtener las especialidades de las citas, contacte con el servicio de soporte.");
                }
                

            }
            


        }), 10000);



	}
}

function mostrarHora() {

	var data = ['15:30:00','16:20:00','18:25:00'];
	var selectHora = document.getElementById("horaFecha");
	var option = document.createElement("option");
	if(estadoMostrarHora == true){
		
		for(var i=0;i<data.length;i++){
			var option = document.createElement("option");
		option.text =data[i];
		selectHora.add(option);}
		estadoMostrarHora = false;
	}
	
	
	
}
function pedirCita() {
    var fecha = document.getElementById("fecha").value;
    var hora = document.getElementById("horaFecha").value;
    var especialidad = document.getElementById("especialidad").value;
    var DNI = document.getElementById("dni").value;
    
    
  fecha= fecha+' '+hora;	  
  fecha =fecha.substring(8,10)+fecha.substring(4,8)+fecha.substring(0,4)+fecha.substring(10,fecha.length)+":00";
  fecha=fecha.replace("T"," ");
  fecha=fecha.replace("-","/");
  fecha=fecha.replace("-","/");
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
            	alert("OK: se ha procesado correctamente la petición de creación de la cita.");
            	setTimeout(location.href = 'http://localhost:8080/gestorCitas', 10000);
            	

            } else {
                if (data.type="error") {
                    alert("Error: se ha procesado incorrectamente la petición de creación de la cita.");
                }
                

            }

        }), 10000);
        
    }
