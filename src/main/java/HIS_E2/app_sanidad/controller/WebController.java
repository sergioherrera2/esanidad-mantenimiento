package HIS_E2.app_sanidad.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
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
		int numSS = 0;
		int idEspecialidad = 0;
		
		if(jso.get("numSS") == null) {
			numSS = -1;
		} else {
			numSS = Integer.parseInt(jso.get("numSS"));
		}
		
		if(jso.get("idEspecialidad") == null) {
			idEspecialidad = -1;
		} else {
			idEspecialidad = Integer.parseInt(jso.get("idEspecialidad"));
		}
		
		Usuario usuario = Manager.get().register(dni, nombre, apellidos, contrs, numSS, idEspecialidad);
		Map<String, Object> respuesta=new HashMap<String, Object>();
		respuesta.put("type", "OK");
		respuesta.put("resultado", new ObjectMapper().writeValueAsString(usuario));
		
		return respuesta;
	}
	
	@PostMapping("/getCitas")
	public Map<String, Object> getCitas(@RequestBody Map<String, String> jso) throws Exception{
		String dni = jso.get("dni");
		String pass = jso.get("pass");
		List<Cita> list = Manager.get().getCitas(dni, pass);
		Map<String, Object> respuesta=new HashMap<String, Object>();
		if(list == null) {
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
	
	@PostMapping("/autenticar")
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
	@ExceptionHandler(Exception.class)
	public Map<String, String> handleException(Exception ex) {
		Map<String, String> resultado = new HashMap<String, String>();
		resultado.put("type", "error");
		resultado.put("message", ex.getMessage());
	    return resultado;
	}
}
