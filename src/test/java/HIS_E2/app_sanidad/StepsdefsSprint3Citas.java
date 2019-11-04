package HIS_E2.app_sanidad;

import static org.junit.Assert.fail;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestContextManager;

import HIS_E2.app_sanidad.controller.Manager;
import HIS_E2.app_sanidad.model.Cita;
import HIS_E2.app_sanidad.model.Paciente;
import HIS_E2.app_sanidad.model.Usuario;
import HIS_E2.app_sanidad.repositories.CitaRepository;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class StepsdefsSprint3Citas extends JunitTests2{
	private WebDriver driver;
	OkHttpClient client;
	Request request;
	@Autowired CitaRepository citasRepo;
	Cita cita;
	@Given("^Abro Firefox y entro en la aplicacion citas$")
	public void abro_Firefox_y_entro_en_la_aplicacion_citas() {
		try {
			new TestContextManager(getClass()).prepareTestInstance(this);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    try {
		    System.setProperty("webdriver.gecko.driver", "src/test/resources/HIS_E2/app_sanidad/geckodriver.exe");					

		    DesiredCapabilities dc = new DesiredCapabilities();
		    dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		    driver = new FirefoxDriver();		
		    driver.manage().window().maximize();
		    
	    driver.get("https://app-sanidad.herokuapp.com/register");
	    }catch(Exception e) {
	    	driver.quit();
	    	fail("Can't connect to application");
	    }
	}

	@Given("^Me autentico como un usuario$")
	public void me_autentico_como_un_usuario() {
		try {
		       driver.findElement(By.name("username")).sendKeys("05726690N");							
		       driver.findElement(By.name("password")).sendKeys("Antonio123");
		}catch(Exception e) {
			driver.quit();
			fail("No se encuentran los campos");
		}
		try {
			 driver.findElement(By.name("btnLogin")).click();
		}catch(Exception e) {
			fail("No se encuentra el boton de login");
		
	}
	}

	@When("^Pido una cita dni-user \"([^\"]*)\", especialidad \"([^\"]*)\", fecha \"([^\"]*)\"$")
	public void pido_una_cita_dni_user_especialidad_fecha(String arg1, String arg2, String arg3) {
		try {
		       driver.findElement(By.name("txt-especialidad")).sendKeys(arg1);							
		       driver.findElement(By.name("txt-fecha")).sendKeys(arg2);
		}catch(Exception e) {
			driver.quit();
			fail("No se encuentran los campos");
		}
		try {
			 driver.findElement(By.name("btnPedirCita")).click();
		}catch(Exception e) {
			fail("No se encuentra el boton de pedir cita");
		
	}
	}

	@Then("^Recibo una respuesta de cita \"([^\"]*)\"$")
	public void recibo_una_respuesta_de_cita(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Borro la cita si ha sido insertada con exito \"([^\"]*)\", especialidad \"([^\"]*)\", fecha \"([^\"]*)\"$")
	public void borro_la_cita_si_ha_sido_insertada_con_exito_especialidad_fecha(String arg1, String arg2, String arg3) {
		/**
		 * La cita debe ser borrada si se inserta proporcionando dni-user, especialidad y fecha
		 */
	   // Cita cita_borrar=new Cita(0, arg3, arg3, arg3);
	}
	
	
	
	
	@Given("^ClienteHttpPedirCita$")
	public void clientehttppedircita() {
		client = new OkHttpClient();
		try {
			new TestContextManager(getClass()).prepareTestInstance(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("^Envío petición Post con todos los campos de pedir cita dni-user \"([^\"]*)\", especialidad \"([^\"]*)\" , fecha \"([^\"]*)\"$")
	public void envío_petición_Post_con_todos_los_campos_de_pedir_cita_dni_user_especialidad_fecha(String arg1, String arg2, String arg3) {
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\"dni-user\":\""+arg1+"\",\"especialidad\":\""+arg2+"\",\"fecha\":\""+arg3+"\"}");
		 
		 request = new Request.Builder()
				  .url("https://app-sanidad.herokuapp.com/pedirCita")
				  .post(body)
				  .addHeader("Content-Type", "application/json")
				  .addHeader("User-Agent", "PostmanRuntime/7.19.0")
				  .addHeader("Accept", "*/*")
				  .addHeader("Cache-Control", "no-cache")
				  .addHeader("Postman-Token", "026c8d66-5ccb-453f-b1b4-c6f351f126ee,ca3db196-6148-4d81-a889-94d79002afe4")
				  .addHeader("Host", "app-sanidad.herokuapp.com")
				  .addHeader("Accept-Encoding", "gzip, deflate")
				  .addHeader("Content-Length", "84")
				  .addHeader("Connection", "keep-alive")
				  .addHeader("cache-control", "no-cache")
				  .build();

	}

	@Then("^Recibo una respuesta de cita Result \"([^\"]*)\" dni-user \"([^\"]*)\", especialidad \"([^\"]*)\" , fecha \"([^\"]*)\"$")
	public void recibo_una_respuesta_de_cita_Result_dni_user_especialidad_fecha(String arg1, String arg2, String arg3, String arg4) {
		try {
			Response response = client.newCall(request).execute();
			System.out.println(response.toString());
			String prueba= response.body().string();
			JSONObject jsonObject = new JSONObject(prueba);
			
			
			if(arg1.equals("OK")) {
				if(jsonObject.get("type").equals("error")) {
					fail("Respuesta fallida pero debería ser correcta");
				}
			}else if(arg1.equals("Error")){
				if(!jsonObject.get("type").equals("error")) {
					try {
					/**
					 * Necesaria implementación del metodo
						citasRepo.deleteByDniPacienteAndEspecialidadAndFecha(arg1);
						 */
					}catch(Exception e) {
						
					}
					fail("Respuesta debería ser fallida pero es correcta");
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Error recibiendo la respuesta");
		}
	}
	
	
	@Given("^Una cita con todos los campos dni-user \"([^\"]*)\" , especialidad \"([^\"]*)\", fecha \"([^\"]*)\"$")
	public void una_cita_con_todos_los_campos_dni_user_especialidad_fecha(String arg1, String arg2, String arg3) {
		try {
			new TestContextManager(getClass()).prepareTestInstance(this);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 //cita =new Cita(, arg1, arg2, arg3); Crear constructor
		
	}

	@When("^pido la cita \"([^\"]*)\"$")
	public void pido_la_cita(String arg1) {
		try {
			
		   // Manager.get().pedirCita(cita.getDniPaciente(),cita.getFecha(),cita.getEspecialidad); Hay que definir este metodo y sus entradas
			} catch( Exception e) {
				if(!arg1.contentEquals("Error")) {
					fail("Register should work here");
				}
			
			}
	}

	@Then("^Se guarda correctamente la cita dni-user \"([^\"]*)\" , especialidad \"([^\"]*)\", fecha \"([^\"]*)\" Result \"([^\"]*)\"$")
	public void se_guarda_correctamente_la_cita_dni_user_especialidad_fecha_Result(String arg1, String arg2, String arg3, String arg4) {
		throw new PendingException();
	/**
		if(arg2.equals("OK")) {
			
			Cita cita1=citasRepo.findByDniPacienteAndEspecialidadAndFecha(arg1,arg2,arg3); //
			
			if(cita1 ==null) {
				fail("user is not inserted");
			}
		}
		
			
	}
	**/
	}


}
