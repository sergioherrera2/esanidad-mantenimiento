function crearEspecialidad() {
  var nombre = document.getElementById("nombreEspecialidad").value;
  var tiempo = document.getElementById("tiempoCita").value;
  var inicio = document.getElementById("horaInicio").value;
  var fin = document.getElementById("horaFin").value;
  var DNI = JSON.parse(sessionStorage.getItem("data"));

  var recurso = "http://localhost:8080/crearEspecialidad";
  var data = {
      type: "especialidad",
      nombre: nombre,
      tiempo: tiempo,
      inicio: inicio,
      fin: fin
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
            alert("Error al crear la especialidad, contacte con el servicio de soporte.");
        }
    }
  }), 10000);
}
