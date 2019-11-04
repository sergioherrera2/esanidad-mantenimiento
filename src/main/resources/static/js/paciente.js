var datos = [{
        "fecha": "12/05/19",
        "hora": "15:01",
        "centroDeSalud": "LA SOLANA",
        "especialidad": " ONCOLOGÍA",
    },
    {
        "fecha": "12/12/19",
        "hora": "15:41",
        "centroDeSalud": "MANZANARES",
        "especialidad": " ONCOLOGÍA",
    },
    {
        "fecha": "11/05/19",
        "hora": "05:01",
        "centroDeSalud": "TOLEDO",
        "especialidad": " ONCOLOGÍA",
    },
    {
        "fecha": "12/05/29",
        "hora": "12:01",
        "centroDeSalud": "CIUDAD REAL",
        "especialidad": " ONCOLOGÍA",
    }
];

var cuerpo = "";
var cabecera = '<tr>' +
    '<th>FECHA</th>' +
    '<th>HORA</th>' +
    '<th>CENTRO DE SALUD</th>' +
    '<th>ESPECIALIDAD</th>' +
    '</tr>';

for (var i = 0; i < datos.length; i++) {
    cuerpo += '<tr>' +
        '<td>' + datos[i].fecha + '</td>' +
        '<td>' + datos[i].hora + '</td>' +
        '<td>' + datos[i].centroDeSalud + '</td>' +
        '<td>' + datos[i].especialidad + '</td>' +
        '</tr>';
}
$("#tablaCabecera").append(cabecera);
$("#tablaCuerpo").append(cuerpo);