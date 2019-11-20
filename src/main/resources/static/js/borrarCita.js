var DNI = JSON.parse(sessionStorage.getItem("data"));
function cerrarSesion (){
	
	sessionStorage.removeItem("data");
	setTimeout(location.href = 'http://localhost:8080/', 10000);
	
}