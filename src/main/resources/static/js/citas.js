
	var nombreEspecialidad = [];
	var duracionCita = [];
	var horaInicio = [];
	var horaFin = [];
	
    var recurso = "http://localhost:8080/consultaEspecialidades";
        var data = {
           
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
            		
            		/* Para obtener el texto */
            		//combo.options[i].text="caca";
            		
            		
        		}
            	
            	
                
            	
            } else {
                if (data.type="error") {
                    alert("Error al obtener las especialidades de las citas, contacte con el servicio de soporte.");
                }
                

            }
            


        }), 10000);





function pedirCita() {
    var fecha = document.getElementById("fecha").value;
    var especialidad = document.getElementById("especialidad").value;
    var DNI = JSON.parse(sessionStorage.getItem("data"));

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
              
                setTimeout(location.href = 'http://localhost:8080/paciente', 10000);

            } else {
                if (data.type="error") {
                    alert("Error al crear cita, contacte con el servicio de soporte.");
                }
                

            }

        }), 10000);
        
    }
