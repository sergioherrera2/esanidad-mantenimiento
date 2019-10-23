package HIS_E2.app_sanidad.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		int numSS = -1;
		int idEspecialidad = -1;
		
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
	
	@ExceptionHandler(Exception.class)
	public Map<String, String> handleException(Exception ex) {
		Map<String, String> resultado = new HashMap<String, String>();
		resultado.put("type", "error");
		resultado.put("message", ex.getMessage());
	    return resultado;
	}
}
