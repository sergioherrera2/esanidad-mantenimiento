package HIS_E2.app_sanidad;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.test.context.TestContextManager;

import HIS_E2.app_sanidad.controller.Manager;
import HIS_E2.app_sanidad.model.Especialidad;
import HIS_E2.app_sanidad.model.Usuario;
import HIS_E2.app_sanidad.repositories.EspecialidadRepository;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class StepsdefsSprint4Especialidades {
	private WebDriver driver;
	OkHttpClient client;
	Request request;
	private String nombre_especialidad;
	private String duracion_especialidad;
	private String duracion_modificar_especialidad;
	private EspecialidadRepository especialidadRepo;
	private List<Especialidad> lista_especialidades;
	private Usuario user_admin;
	private Especialidad especialidad;
	
	
	@Given("^Tengo el nombre y la duracion de una especialidad \"([^\"]*)\",\"([^\"]*)\"$")
	public void tengo_el_nombre_y_la_duracion_de_una_especialidad(String arg1, String arg2) {
		try {
			new TestContextManager(getClass()).prepareTestInstance(this);
		} catch (Exception e) {
			e.getMessage();
		}
		nombre_especialidad = arg1;
	    duracion_especialidad = arg2;
	}

	@When("^creo la especialidad \"([^\"]*)\"$")
	public void creo_la_especialidad(String arg1) {
		
		try {
			
			
		   //  especialidad = Manager.get().crearEspecialidad(nombre_especialidad, duracion_especialidad)
			//RECORDAR QUE LA DURACION SE ENVIA COMO STRING
			} catch( Exception e) {
				if(!arg1.contentEquals("Error")) {
					fail("Debería haberse creado la especialidad");
				}
			
			}
		 throw new PendingException();
	}

	@Then("^La especialidad ha sido guardada \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void la_especialidad_ha_sido_guardada(String arg1, String arg2, String arg3) {
		

		if(arg3.equals("OK")) {
			List<Especialidad> especialidad =especialidadRepo.findCustomEspecialidad(arg1);
			int duracion=0;
			try {
				 duracion = Integer.parseInt(arg2);
			}catch(Exception e) {
				fail("La duración no es un número");
			}
			
			if(especialidad.get(0).getDuracionCita()!=duracion || !especialidad.get(0).getNombreEspecialidad().equals(arg1)){
				fail("La especialidad insertada y la guardada no coinciden");
				
			}
		}
		
	}

	@Then("^borro la especialidad \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void borro_la_especialidad(String arg1, String arg2, String arg3) {
		if(arg3.equals("OK")) {
			//Especialidad especialidad_borrada = especialidadRepo.deleteCustomespecialidad(arg1,arg2);
			//assertNotNull(especialidad_borrada);
		}
	}
	
	
	@Given("^ClienteHttpEspecialidad$")
	public void clientehttpespecialidad() {
		try {
			new TestContextManager(getClass()).prepareTestInstance(this);
		} catch (Exception e) {
		}
		client = new OkHttpClient();
	}

	@When("^Envio peticion crear especialidad nombre \"([^\"]*)\",duracion \"([^\"]*)\",response \"([^\"]*)\"$")
	public void envio_peticion_crear_especialidad_nombre_duracion_response(String arg1, String arg2, String arg3) {
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\"nombre\":\""+arg1+"\",\"duracion\":\""+arg2+"\"}");
		 request = new Request.Builder()
		  .url("http://app-sanidad.herokuapp.com/crearEspecialidad")
		  .post(body)
		  .addHeader("Content-Type", "application/json")
		  .addHeader("cache-control", "no-cache")
		  .addHeader("Postman-Token", "af9231cc-f85a-4fbc-a63a-3c3ea6a900a6")
		  .build();
	}

	@Then("^Recibo una respuesta \"([^\"]*)\", nombre \"([^\"]*)\",duracion \"([^\"]*)\"$")
	public void recibo_una_respuesta_nombre_duracion(String arg1, String arg2, String arg3) {
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
					try {
					//	Manager.get().eliminarEspecialidad(arg1, arg2);
					}catch(Exception e) {	
						fail("Respuesta debería ser fallida pero es correcta y no se ha podido eliminar");
				}
					fail("Respuesta debería ser fallida pero es correcta");
				}
			}
		} catch (Exception e) {
			fail("Error recibiendo la respuesta");
		}
	}
	
	
	@Given("^Abroo Firefox y entro en la aplicacion citas$")
	public void abroo_Firefox_y_entro_en_la_aplicacion_citas() {
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
		    
	    driver.get("http://app-sanidad.herokuapp.com");
	    }catch(Exception e) {
	    	driver.quit();
	    	fail("Can't connect to application");
	    }
	}
	
	
	
	@Given("^Entro en la vista del gestor dni\"([^\"]*)\" contraseña \"([^\"]*)\"$")
	public void entro_en_la_vista_del_gestor_dni_contraseña(String arg1, String arg2) {
		try {
		       driver.findElement(By.name("username")).sendKeys(arg1);							
		       driver.findElement(By.name("password")).sendKeys(arg2);
				 driver.findElement(By.name("btnLogin")).click();
		}catch(Exception e) {
			driver.quit();
			fail("No se encuentran los username o paswword");
		}
	}

	@When("^relleno los campos nombre \"([^\"]*)\", duracion \"([^\"]*)\"$")
	public void relleno_los_campos_nombre_duracion(String arg1, String arg2) {
		try {
		driver.findElement(By.name("href_pedirCita")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	       driver.findElement(By.name("nombre")).sendKeys(arg1);							
	       driver.findElement(By.name("duracion")).sendKeys(arg2);
		}catch(Exception e) {
			driver.quit();
			fail("no se encuentran los campos de nombre duración o boton crear especialidad");
		}
	}

	@Then("^Presiono el boton crear especialidad y recibo respuesta \"([^\"]*)\"$")
	public void presion_el_boton_crear_especialidad_y_recibo_respuesta(String arg1) {
		try {
			 driver.findElement(By.name("btnCrearEspecialidad")).click();
			   Alert alert = driver.switchTo().alert();
		        String alertText = alert.getText();
		        alert.accept();
		} catch (UnhandledAlertException f) {

		  } catch (NoAlertPresentException e) {
			  driver.quit();
			  if(arg1.equals("error")){
				  fail("Debería haber una alerta de error");
			  }
		        
		}catch(Exception e) {
			driver.quit();
			fail("No se puede encontrar boton de crear especialidad");
		
	}
	}
	
	
	@Then("^la especialidad ha sido borrada correctamente nombre \"([^\"]*)\", duracion \"([^\"]*)\",\"([^\"]*)\"$")
	public void la_especialidad_ha_sido_borrada_correctamente_nombre_duracion(String arg1, String arg2, String arg3) {
	   if(arg3.equals("OK")) {
		   List<Especialidad> especialidad = especialidadRepo.findCustomEspecialidad(arg1);
		   
		 assertNotNull(especialidad.get(0));
		 
	   }
	}
	@When("^Presiono el boton eliminar especialidad y recibo respuesta \"([^\"]*)\"$")
	public void presiono_el_boton_eliminar_especialidad_y_recibo_respuesta(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^la especialidad se ha borrado nombre \"([^\"]*)\",duracion\"([^\"]*)\",response\"([^\"]*)\"$")
	public void la_especialidad_se_ha_borrado_nombre_duracion_response(String arg1, String arg2, String arg3) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Envio peticion eliminar especialidad nombre \"([^\"]*)\",duracion \"([^\"]*)\",response \"([^\"]*)\"$")
	public void envio_peticion_eliminar_especialidad_nombre_duracion_response(String arg1, String arg2, String arg3) {
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\"nombre\":\""+arg1+"\",\"duracion\":\""+arg2+"\"}");
		 request = new Request.Builder()
		  .url("http://app-sanidad.herokuapp.com/eliminarEspecialidad")
		  .post(body)
		  .addHeader("Content-Type", "application/json")
		  .addHeader("cache-control", "no-cache")
		  .addHeader("Postman-Token", "af9231cc-f85a-4fbc-a63a-3c3ea6a900a6")
		  .build();
	}
	
	
	@Given("^usuario admin \"([^\"]*)\", contrasenia \"([^\"]*)\"$")
	public void usuario_admin_contrasenia(String arg1, String arg2) {
		user_admin.setDni(arg1);
		user_admin.setContrs(arg2);
	}

	@When("^Pido la lista de especialidades \"([^\"]*)\"$")
	public void pido_la_lista_de_especialidades(String arg1) {
	    //lista_especialidades = Manager.get().listaEspecialidades(user_admin);
	}
	


	@Then("^Tengo una lista de especialidades$")
	public void tengo_una_lista_de_especialidades() {
		//assertNotNull(lista_especialidades);
	}
	
	@Then("^Recibo una respuesta lista de especialidades \"([^\"]*)\"$")
	public void recibo_una_respuesta_lista_de_especialidades(String arg1) {
	    if(arg1.equals("OK")) {
	    	//assertNotNull(lista_especialidades);
	    }
	}

	@When("^Envio peticion recibir lista especialidades dni_admin \"([^\"]*)\"$")
	public void envio_peticion_recibir_lista_especialidades_dni_admin(String arg1) {
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\"dni-admin\":\""+arg1+"\"}");
		 request = new Request.Builder()
		  .url("http://app-sanidad.herokuapp.com/eliminarEspecialidad")
		  .post(body)
		  .addHeader("Content-Type", "application/json")
		  .addHeader("cache-control", "no-cache")
		  .addHeader("Postman-Token", "af9231cc-f85a-4fbc-a63a-3c3ea6a900a6")
		  .build();
	}

	@Then("^Recibo Respuesta lista especialidades \"([^\"]*)\"$")
	public void recibo_Respuesta_lista_especialidades(String arg1) {
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
					try {
					
					}catch(Exception e) {	
						fail("Respuesta debería ser fallida pero es correcta y no se ha podido eliminar");
				}
					fail("Respuesta debería ser fallida pero es correcta");
				}
			}
		} catch (Exception e) {
			fail("Error recibiendo la respuesta");
		}
	}

	@Given("^Tengo el nombre y la duracion de una especialidad \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void tengo_el_nombre_y_la_duracion_de_una_especialidad(String arg1, String arg2, String arg3) {
		 nombre_especialidad = arg1;
		 duracion_especialidad = arg2;
		 duracion_modificar_especialidad = arg3;
	}

	@When("^modifico la especialidad nombre\"([^\"]*)\",duracion\"([^\"]*)\",nueva duracion\"([^\"]*)\", response\"([^\"]*)\"$")
	public void modifico_la_especialidad_nombre_duracion_nueva_duracion_response(String arg1, String arg2, String arg3, String arg4) {
	    //especialidad = Manager.get().modificarEspecialidad(nombre_especialidad,duracion_especialdiad,duracion_modificar_especialidad);
	}

	@Then("^la especialidad ha sido modificada correctamente nombre \"([^\"]*)\", nueva duracion \"([^\"]*)\",\"([^\"]*)\"$")
	public void la_especialidad_ha_sido_modificada_correctamente_nombre_nueva_duracion(String arg1, String arg2, String arg3) {
		if(arg3.equals("OK")) {
			lista_especialidades = especialidadRepo.findCustomEspecialidad(arg1);
			Especialidad espeModificada = lista_especialidades.get(0);
			if(espeModificada.getDuracionCita()!= especialidad.getDuracionCita()) {
				fail("la especialidad no se ha modificado correctamente");
			}
		}
	     
	     
	}


}
