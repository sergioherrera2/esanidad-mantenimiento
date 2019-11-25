package HIS_E2.app_sanidad;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.test.context.TestContextManager;

import HIS_E2.app_sanidad.controller.Manager;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class StepsdefsSprint4AutenticarMedico {
	private WebDriver driver;
	OkHttpClient client;
	Request request;
	private String dniMedico;
	private String contrasenia;
	private String especialidad;
	@Given("^un un medico \"([^\"]*)\" contrasenia \"([^\"]*)\"$")
	public void un_un_medico_contrasenia(String arg1, String arg2) {
		try {
			new TestContextManager(getClass()).prepareTestInstance(this);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dniMedico = arg1;
		contrasenia = arg2;
	}

	@When("^me autentico \"([^\"]*)\"$")
	public void me_autentico(String arg1) {
		try {
			
			
		     // especialidad = Manager.get().getEspecialidadMedico(dniMedico);
		     if(arg1.equals("Error")){
		    	 fail("debería haber un error al insertar (Borrar de la base de datos)");
		     }
			} catch( Exception e) {
				if(!arg1.equals("Error")) {
					fail("Debería haberse creado la especialidad");
				}
			
			}
	}


	@Given("^ClienteHttpAutenticarMedico$")
	public void clientehttpautenticarmedico() {
		client = new OkHttpClient();
		try {
			new TestContextManager(getClass()).prepareTestInstance(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("^Envio peticion autenticar \"([^\"]*)\" contrasenia \"([^\"]*)\" response \"([^\"]*)\"$")
	public void envio_peticion_autenticar_contrasenia_response(String arg1, String arg2, String arg3) {
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\"dni\":\""+arg1+"\",\"contrasenia\":\""+arg2+"\"}");
		 request = new Request.Builder()
		  .url("http://localhost:8080/autenticar")
		  .post(body)
		  .addHeader("Content-Type", "application/json")
		  .addHeader("cache-control", "no-cache")
		  .addHeader("Postman-Token", "af9231cc-f85a-4fbc-a63a-3c3ea6a900a6")
		  .build();
	}

	@Then("^Recibo una respuesta autenticar \"([^\"]*)\" contrasenia \"([^\"]*)\" response \"([^\"]*)\"$")
	public void recibo_una_respuesta_autenticar_contrasenia_response(String arg1, String arg2, String arg3) {
		try {
			Response response = client.newCall(request).execute();
			System.out.println(response.toString());
			String prueba= response.body().string();
			boolean isFound = prueba.contains("especialidad");
			if(!isFound) {
				fail("no contiene especialidad");
			}

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
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Error recibiendo la respuesta");
		}
	}

	@Given("^Abroo un buscador y entro en la aplicacion citas$")
	public void abroo_un_buscador_y_entro_en_la_aplicacion_citas() {
		try {
			new TestContextManager(getClass()).prepareTestInstance(this);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    try {
		    System.setProperty("webdriver.gecko.driver", "src/test/resources/HIS_E2/app_sanidad/geckodriver");					

		    DesiredCapabilities dc = new DesiredCapabilities();
		    dc.setCapability("marionatte", false);
		    //Syçstm.setProprty("webdriver.chrome.driver", "src/test/resources/HIS_E2/app_sanidad/chromedriver.exe");
		    // driver = new ChromeDriver();
		    System.out.println("TRAVIS PRUEBAAA1");
		    driver = new FirefoxDriver();
		    System.out.println("TRAVIS PRUEBAAA");
	    driver.get("https://app-sanidad.herokuapp.com/");
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	driver.quit();
	    	fail("Can't connect to application");
	    }
	    driver.quit(); //eliminarlo cuando se ejécuten los tests
	}

	@When("^me autentico$")
	public void me_autentico() {
		try {
		       driver.findElement(By.name("username")).sendKeys("dniMedico");							
		       driver.findElement(By.name("password")).sendKeys("contrasenia");
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

	@Then("^presiono el boton cambiar a vista de trabajo$")
	public void presiono_el_boton_cambiar_a_vista_de_trabajo() {
		try {
			 driver.findElement(By.name("btnVistaDeTrabajo")).click();
		}catch(Exception e) {
			fail("No se encuentra el boton de vista De Trabajo");
		
	  }
	}
	
	
	
	
	
	
	
	@Then("^recibo la especialidad de medico \"([^\"]*)\"$")
	public void recibo_la_especialidad_de_medico(String arg1) {
		if(arg1.equals("OK")) {
			assertNotNull(especialidad);
		}
		
		
		
	}

	@Then("^Cambio a vista de trabajo \"([^\"]*)\"$")
	public void cambio_a_vista_de_trabajo(String arg1) {
		
		if(arg1.equals("OK")) {
			String new_url = driver.getCurrentUrl();
			 assertTrue(new_url.equals("http://localhost:8080/trabajo"));
		}
		
	}


}
