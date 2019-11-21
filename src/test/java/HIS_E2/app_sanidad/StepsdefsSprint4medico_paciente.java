package HIS_E2.app_sanidad;

import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.springframework.test.context.TestContextManager;

import HIS_E2.app_sanidad.controller.Manager;
import HIS_E2.app_sanidad.model.PacienteMedico;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class StepsdefsSprint4medico_paciente {
	private WebDriver driver;
	OkHttpClient client;
	Request request;
	private String dni_medico;
	private String dni_paciente;
	private PacienteMedico  pacienteMedico = new PacienteMedico(dni_medico, dni_medico, dni_medico);
	
	
	
	@Given("^Tengo dni-user \"([^\"]*)\", dni-medico \"([^\"]*)\", Response \"([^\"]*)\"$")
	public void tengo_dni_user_dni_medico_Response(String arg1, String arg2, String arg3) {
		try {
			new TestContextManager(getClass()).prepareTestInstance(this);
		} catch (Exception e) {
			e.getMessage();
		}
		dni_paciente = arg1;
		dni_medico = arg2;
	}

	@When("^creo la relacion \"([^\"]*)\"$")
	public void creo_la_relacion(String arg1) {
		try {
			
			
		     ////////////////////////////////////////////////////////////////////
		     if(arg1.equals("Error")){
		    	 fail("debería haber un error al insertar (Borrar de la base de datos)");
		     }
			} catch( Exception e) {
				if(!arg1.equals("Error")) {
					fail("Debería haberse creado la relación Médico-Paciente");
				}
			
			}
	}

	@Then("^la relacion ha sido guardada dni-user \"([^\"]*)\", dni-medico \"([^\"]*)\", Response \"([^\"]*)\"$")
	public void la_relacion_ha_sido_guardada_dni_user_dni_medico_Response(String arg1, String arg2, String arg3) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^borro la relacion dni-user \"([^\"]*)\", dni-medico \"([^\"]*)\", Response \"([^\"]*)\"$")
	public void borro_la_relacion_dni_user_dni_medico_Response(String arg1, String arg2, String arg3) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
