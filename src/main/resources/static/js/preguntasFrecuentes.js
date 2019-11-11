var DNI = JSON.parse(sessionStorage.getItem("data"));
function cerrarSesion (){
	
	sessionStorage.removeItem("data");
	setTimeout(location.href = 'https://app-sanidad.herokuapp.com/', 10000);
	
}