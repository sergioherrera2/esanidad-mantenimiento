function crearEspecialidad() {
  var dni = document.getElementById("dni").value;
  var especialidad = document.getElementById("especialidad").value;
  var DNI = JSON.parse(sessionStorage.getItem("data"));

  var recurso = "http://localhost:8080/crearMedico";
  var data = {
      type: "medico",
      dni: dni,
      especialidad: especialidad
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
        setTimeout(location.href = 'http://localhost:8080/gestor', 10000);
    } else {
        if (data.type="error") {
            alert("Error al crear el médico, contacte con el servicio de soporte.");
        }
    }
  }), 10000);
}
