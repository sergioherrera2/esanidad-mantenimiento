function validate() {
    var usuario = document.getElementById("username").value;
    var contraseña = document.getElementById("password").value;



    var recurso = "https://app-sanidad.herokuapp.com/autenticar";
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
    },
    success : function(response){
                       window.location.href = "https://app-sanidad.herokuapp.com/paciente";
                },
                error: function(error){
                      alert("no funciona");
                }
    });

}