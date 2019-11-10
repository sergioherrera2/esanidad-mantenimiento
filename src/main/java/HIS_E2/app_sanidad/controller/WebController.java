package HIS_E2.app_sanidad.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import HIS_E2.app_sanidad.model.Cita;
import HIS_E2.app_sanidad.model.Usuario;

@RestController
public class WebController {

	/**Controla el mapeo de la página de incio.
	 * @return Devuelve el html del index.
	 */
	@GetMapping("/home")
	public String home() {
		return "index.html";
	}
	
	/**Controlador mapeo de la página de citas.
	 * @return Devuelve el html de la página de citas.
	 */
	@GetMapping(value = "/citas")
	public String getCitas() {
		return "views/citas.html";
	}
	
	@PostMapping("/register")
	public Map<String, Object> register(@RequestBody Map<String, String> jso) throws Exception {
		String dni = jso.get("dni");
		String nombre = jso.get("nombre");
		String apellidos = jso.get("apellidos");
		String contrs = jso.get("pass");
		String numSS = jso.get("numSS");
		int idEspecialidad = 0;
		Usuario usuario = Manager.get().register(dni, nombre, apellidos, contrs, numSS, idEspecialidad);
		Map<String, Object> respuesta=new HashMap<String, Object>();
		respuesta.put("type", "OK");
		respuesta.put("resultado", new ObjectMapper().writeValueAsString(usuario));
		return respuesta;
	}
	
	@PostMapping("/getCitas")
	public Map<String, Object> getCitas(@RequestBody Map<String, String> jso) throws Exception {
		String dni = jso.get("dni");
		String pass = jso.get("pass");
		List<Cita> list = Manager.get().getCitasMedico(dni, pass);
		Map<String, Object> respuesta=new HashMap<String, Object>();
		if (list == null) {
			respuesta.put("type", "ERROR");
			respuesta.put("message", "contraseña incorrecta");
		} else {
			respuesta.put("type", "OK");
			for(int i = 0; i<list.size(); i++) {
				respuesta.put("cita"+i, new ObjectMapper().writeValueAsString(list.get(i)));
			}
		}
		
		return respuesta;
	}
	
	@PostMapping("/citasPaciente")
	public Map<String, Object> citasPaciente(@RequestBody Map<String, String> jso) throws Exception {
		String dni = jso.get("dni");
		List<Cita> list = Manager.get().getCitasPaciente(dni);
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("type", "OK");
		for(int i = 0; i<list.size(); i++) {
			respuesta.put("cita"+i, new ObjectMapper().writeValueAsString(list.get(i)));
		}
		return respuesta;
	}
	
	@CrossOrigin(origins = "*", allowCredentials = "true")
	@PostMapping(value = "/autenticar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String autenticar(@RequestBody Map<String, String> jso) throws Exception {
		String dni = jso.get("dni");
		String pass = jso.get("pass");
		JSONObject resultado=new JSONObject();

		if(Manager.get().autenticar(dni, pass)) {
			resultado.put("type", "OK");
			resultado.put("resultado", "login correcto");
		} else {
			throw new Exception("Credenciales invalidas");
		}
		return resultado.toString();
	}
	
	@PostMapping(value = "/pedirCita")
	public Map<String, Object> pedirCita(@RequestBody Map<String, String> jso) throws Exception{
		String dniPaciente = jso.get("dniPaciente");
		String fecha = jso.get("fecha");
		String especialidad = jso.get("especialidad");
		Cita cita = Manager.get().pedirCita(dniPaciente, fecha, especialidad);
		Map<String, Object> respuesta=new HashMap<String, Object>();
		respuesta.put("type", "OK");
		respuesta.put("resultado", new ObjectMapper().writeValueAsString(cita));
		return respuesta;
	}
	
	@PostMapping(value = "/citasDisponibles")
	public Map<String, Object> citasDisponibles(@RequestBody Map<String, String> jso) throws Exception {
		String dniPaciente = jso.get("dniPaciente");
		String especialidad = jso.get("especialidad");
		List<Date> fechas = Manager.get().getCitas(dniPaciente, especialidad);
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("type", "OK");
		for(int i = 0; i<fechas.size(); i++) {
			respuesta.put("fecha"+i, new ObjectMapper().writeValueAsString(fechas.get(i)));
		}
		return respuesta;
	}
	
	@PostMapping(value = "/modificarCita")
	public Map<String, Object> modificarCita(@RequestBody Map<String, String> jso) throws Exception{
		String dniPaciente = jso.get("dniPaciente");
		String especialidad = jso.get("especialidad");
		String fechaActual = jso.get("fechaActual");
		String fechaModificar = jso.get("fechaModificar");
		Cita cita = Manager.get().modificarCita(dniPaciente, especialidad, fechaActual, fechaModificar);
		Map<String, Object> respuesta = new HashMap<String, Object>();
		respuesta.put("type", "OK");
		respuesta.put("cita", new ObjectMapper().writeValueAsString(cita));
		return respuesta;
	}
	
	@ExceptionHandler(Exception.class)
	public Map<String, String> handleException(Exception ex) {
		Map<String, String> resultado = new HashMap<String, String>();
		resultado.put("type", "error");
		resultado.put("message", ex.getMessage());
	    return resultado;
	}
}