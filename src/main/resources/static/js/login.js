function validateLogin() {
    var usuario = document.getElementById("username").value;
    var contraseña = document.getElementById("password").value;

        var recurso = "https://app-sanidad.herokuapp.com/autenticar";
        var data = {
      dni: usuario,
      pass: contraseña,
     };
        data = JSON.stringify(data);
        setTimeout(  $.ajax({
          url : recurso,
          type : "POST",
          data : data,
          xhrFields:{
            withCredentials: true
          },
          headers : {
            'Content-Type' : 'application/json'
          },
        })
        .done(function( data, textStatus, jqXHR ) {
          console.log(data.type+"HOLA");
          if ( data.type=="OK" ) {
             setTimeout( location.href='https://app-sanidad.herokuapp.com/paciente',10000);
           
          }else{
          	if(usuario == "medico") {
          	setTimeout( location.href='https://app-sanidad.herokuapp.com/indexD',10000);
          	}
            window.alert(data.message)
            console.log(data.message)
          }
          
        }),10000);
        
        
  }