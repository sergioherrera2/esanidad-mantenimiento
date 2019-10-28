function validate() {
    var nom = document.getElementById("name").value;
    var Apellidos = document.getElementById("email").value;
    var usuario = document.getElementById("username").value;
    var contraseña = document.getElementById("password").value;
    var fecha = document.getElementById("BornDate").value;
    var Dni = document.getElementById("dni").value;





  var recurso = "https://app-sanidad.herokuapp.com/register";
   var data = {
      type: "register",
  nombre: nom,
    apellidos: Apellidos,
    userName: usuario,
     pass: contraseña,
    fechaN: fecha,
     dni: Dni
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
                       window.location.href = "https://app-sanidad.herokuapp.com/";
                },
                error: function(error){
                      alert("no funciona");
                }
    });

}

