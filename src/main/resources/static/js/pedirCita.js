var DNI = JSON.parse(sessionStorage.getItem("data"));
function validate(){

var idprovincia = document.getElementById("idprovincia");
var pro = idprovincia.options[idprovincia.selectedIndex].value;

}

function cerrarSesion (){
	
	sessionStorage.removeItem("data");
	setTimeout(location.href = 'https://app-sanidad.herokuapp.com/', 10000);
	
}