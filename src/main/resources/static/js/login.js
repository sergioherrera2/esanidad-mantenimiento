function validate() {
    var usuario = document.getElementById("username").value;
    var contraseña = document.getElementById("password").value;



    var recurso = "http://localhost:8080/autenticar";
   	var data = {
    	type: "autenticar",
  		dni: usuario,
    	pass: contraseña,
    
     };
     data = JSON.stringify(data);
    $.ajax({
     url: recurso,
     type: "POST",
     data: data,
    headers: {
       'Content-Type': 'application/json'
    }
    })
    .done(function(response, textStatus, jqXHR) {
    	console.log(response.type);
    	location.href='http://localhost:8080/paciente';
    	});

	}