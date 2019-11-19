package HIS_E2.app_sanidad;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.TestContextManager;

import HIS_E2.app_sanidad.model.Especialidad;
import HIS_E2.app_sanidad.model.Medico;
import HIS_E2.app_sanidad.repositories.MedicoRepository;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class StepsdefsSprint4adminMedicos {
	private WebDriver driver;
	OkHttpClient client;
	Request request;
	private String medico_dni;
	private String medico_especialidad;
	private Medico medico;
	private MedicoRepository medicoRepo;
	
	
	
	
	
	
	
	
	
	
	
	@Given("^Tengo de un medico dni \"([^\"]*)\", especialidad \"([^\"]*)\"$")
	public void tengo_de_un_medico_dni_especialidad(String arg1, String arg2) {
		try {
			new TestContextManager(getClass()).prepareTestInstance(this);
		} catch (Exception e) {
			e.getMessage();
		}
		medico_dni = arg1;
		medico_especialidad = arg2;
	}

	@When("^creo el medico \"([^\"]*)\"$")
	public void creo_el_medico(String arg1) {
		try {
			
			
			   // medico = Manager.get().crearMedico("dni","especialidad");
				} catch( Exception e) {
					if(!arg1.equals("Error")) {
						fail("Debería haberse creado la especialidad");
					}
				
				}
			 throw new PendingException();
		
	}

	@Then("^el medico ha sido guardado correctamente dni \"([^\"]*)\", especialidad \"([^\"]*)\", response \"([^\"]*)\"$")
	public void el_medico_ha_sido_guardado_correctamente_dni_especialidad_response(String arg1, String arg2, String arg3) {
		if(arg3.equals("OK")) {
			medico = medicoRepo.findByDni(arg1);
			assertNotNull(medico);
		}
			
	}

	@Then("^borro el medico dni \"([^\"]*)\", especialidad \"([^\"]*)\", response \"([^\"]*)\"$")
	public void borro_el_medico_dni_especialidad_response(String arg1, String arg2, String arg3) {
		if(arg3.equals("OK")) {
			//Medico medico = medicoRepo.deleteByDni(arg1);
			Medico medico_borrado = medicoRepo.findByDni(arg1);
			assertNull(medico_borrado);
			
		}
	}
	
	
	@Given("^ClienteHttpCrearMedico$")
	public void clientehttpcrearmedico() {
		try {
			new TestContextManager(getClass()).prepareTestInstance(this);
		} catch (Exception e) {
		}
		client = new OkHttpClient();
		throw new PendingException();
	}

	@When("^Envio peticion crear medico dni \"([^\"]*)\",especialidad \"([^\"]*)\", response \"([^\"]*)\"$")
	public void envio_peticion_crear_medico_dni_especialidad_response(String arg1, String arg2, String arg3) {
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\"dni\":\""+arg1+"\",\"especialidad\":\""+arg2+"\"}");
		 request = new Request.Builder()
		  .url("https://app-sanidad.herokuapp.com/crearMedico")
		  .post(body)
		  .addHeader("Content-Type", "application/json")
		  .addHeader("cache-control", "no-cache")
		  .addHeader("Postman-Token", "774c3406-0328-4313-88f8-56ac75e600a2")
		  .build();
	}
	
	@Then("^Recibo una respuesta response \"([^\"]*)\"$")
	public void recibo_una_respuesta_response(String arg1) {
		try {
			Response response = client.newCall(request).execute();
			String prueba= response.body().string();
			JSONObject jsonObject = new JSONObject(prueba);
			if(arg1.equals("OK")) {
				if(jsonObject.get("type").equals("error")) {
					fail("Respuesta fallida pero debería ser correcta");
				}
			}else if(arg1.equals("Error")){
				if(!jsonObject.get("type").equals("error")) {
					fail("Respuesta debería ser fallida pero es correcta");
				}
			}
		} catch (Exception e) {
			fail("Error recibiendo la respuesta");
		}
	    throw new PendingException();
	}

}
