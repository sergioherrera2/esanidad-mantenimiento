function validate() {
    var nom = document.getElementById("name").value;
    var Apellidos = document.getElementById("apellido").value;
    var contraseña = document.getElementById("password").value;
    var contraseña2 = document.getElementById("confirm").value;
    var nss = document.getElementById("nss").value;
    var Dni = document.getElementById("dni").value;
    var hola = document.getElementById("dni");

    controlTipoContraseña(contraseña, contraseña2);
    controlTipodni(Dni);
    controlEspacioVacio(nom, Apellidos, contraseña, fecha, Dni);
    controlNumeroSS(nss);

    function controlNumeroSS(nss) {

        if (nss.length != 12) {
            alert("¡Debe introducir correctamente su nº de Seguridad Social!");
        }

    }
  
    function controlTipoContraseña(contraseña, contraseña2) {

        if (contraseña == contraseña2) {


            var contadorMayuscula = 0;
            var contadorMinuscula = 0;
            var contadorNumerico = 0;
            for (i = 0; i <= contraseña.length - 1; i++) {
                //var letra = contraseña.charAt(i);
                // var letra2 = contraseña.charAt(i).toUpperCase();
                if (contraseña.charAt(i) == contraseña.charAt(i).toUpperCase() && (isNaN(contraseña.charAt(i)) == true)) {
                    contadorMayuscula++;
                }
                if (contraseña.charAt(i) == contraseña.charAt(i).toLowerCase() && (isNaN(contraseña.charAt(i)) == true)) {
                    contadorMinuscula++;
                }
                if (contraseña.charAt(i) == parseInt(contraseña.charAt(i))) {
                    contadorNumerico++;
                }


            }
            if (contadorMayuscula < 1 || contadorMinuscula < 1 || contadorNumerico < 1)
                alert("¡Has introducido las contraseñas incorrectamente!")

        } else {
            alert("¡Deben de coincidir las dos contraseñas!")
        }
    }

    function controlTipodni(Dni) {

        var letraDNI = Dni.charAt(Dni.length - 1);
        var numeroDNI = parseInt(Dni.substr(0, Dni.length - 1));
        var numeroDNIString = Dni.substr(0, Dni.length - 1);
        // var estado1 = Number.isInteger(numeroDNI);
        // var estado2 = isNaN(letraDNI);
        if (((Number.isInteger(numeroDNI) == false) && (isNaN(letraDNI) == false)) || (numeroDNIString.length != 8)) {
            alert("¡Has introducido el DNI incorrectamente!");
        } else {
            var cadena = "TRWAGMYFPDXBNJZSQVHLCKET";
            var posicion = numeroDNI % 23;
            var letra = cadena.substring(posicion, posicion + 1);
            if (letraDNI != letra) {
                alert("¡Has introducido mal la letra de su DNI!");
            }
        }


    }

    function controlEspacioVacio(nom, Apellidos, contraseña, fecha, Dni) {

        if (nom == "" || Apellidos == "" || contraseña == "" || fecha == "" || Dni == "") {

            alert("¡Debe introducir todos los campos para registrarse!");
        } else {
            enviarContenido(nom, Apellidos, contraseña, fecha, Dni);
        }


    }

    function enviarContenido(nom, Apellidos, contraseña, fecha, Dni) {

        var recurso = "https://hola1233.herokuapp.com/register";
        var data = {
            type: "register",
            nombre: nom,
            apellidos: Apellidos,
            pass: contraseña,
            numSS: nss,
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
            success: function(response) {
                window.location.href = "https://localhost:8080/";
            },
            error: function(error) {
                alert("no funciona");
            }
        });
    }




}
