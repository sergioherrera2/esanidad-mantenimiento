package HIS_E2.app_sanidad;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest
@RunWith(SpringRunner.class)
public class StepsdefsSprint2 {
    @Autowired
    private MockMvc mockMvc;
    WebDriver driver;
	private Usuario user;	
	@Autowired
//	private UserRepository usersRepo;
	private OkHttpClient client;
	private Request request; 
    
    

	
	@Given("^Abro un buscador y entro en la página de registro$")
	public void abro_un_buscador_y_entro_en_la_página_de_registro() {
	    try {
	    	
		    System.setProperty("webdriver.gecko.driver", "src/test/resources/HIS_E2/app_sanidad/geckodriver.exe");					

		    DesiredCapabilities dc = new DesiredCapabilities();
		    dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		    driver = new FirefoxDriver();		
		    driver.manage().window().maximize();
		    
	    driver.get("http://app-sanidad.herokuapp.com/registrar");
	    }catch(Exception e) {
	    	driver.quit();
	    	fail("Can't connect to application");
	    }
	    try {
	    driver.findElement(By.name("btnRegister")).click();
	    }catch(Exception e) {
	    	fail("Can't find Register button");
	    }
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    String new_url = driver.getCurrentUrl();
	    assertTrue(new_url.equals("https://app-sanidad.herokuapp.com/registro")); 
		
	}
	@When("^Relleno todos los campos Nombre (.*),Apellidos (.*) DNI (.*) NumeroSS (.*)  Password (.*), Repetir_password (.*)$")
	public void relleno_todos_los_campos_Nombre_Apellidos_DNI_NumeroSS_Password_Repetir_password(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) {
		try {
		       driver.findElement(By.name("text-nombre")).sendKeys(arg1);							
		       driver.findElement(By.name("text-apellidos")).sendKeys(arg2);
		       driver.findElement(By.name("text-DNI")).sendKeys(arg3);							
		       driver.findElement(By.name("text-numeroSS")).sendKeys(arg4);
		       driver.findElement(By.name("text-password")).sendKeys(arg5);							
		       driver.findElement(By.name("text-repetir_password")).sendKeys(arg6);
		       
		       
		}catch(Exception e) {
			driver.quit();
			fail("No se encuentran los campos");
		}
		try {
			 driver.findElement(By.name("btnRegistrar")).click();
		}catch(Exception e) {
			fail("Can't find Register button");
		
	}
	}
	
	
	
	@Given("^Abro un buscador y entro a la página principal$")
	public void abro_un_buscador_y_entro_a_la_página_principal() {
	    try {
	    	
		    System.setProperty("webdriver.gecko.driver", "src/test/resources/HIS_E2/app_sanidad/geckodriver.exe");					

		    DesiredCapabilities dc = new DesiredCapabilities();
		    dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		    driver = new FirefoxDriver();		
		    driver.manage().window().maximize();
		    
	    driver.get("http://app-sanidad.herokuapp.com/registrar");
	    }catch(Exception e) {
	    	driver.quit();
	    	fail("Can't connect to application");
	    }
	}

	@Given("^Entro en la ventana de registro$")
	public void entro_en_la_ventana_de_registro() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


	@When("^Relleno todos los campos$")
	public void relleno_todos_los_campos() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Recibo un mensaje de registro correcto$")
	public void recibo_un_mensaje_de_registro_correcto() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@When("^Relleno algunos datos (.*)$")
	public void relleno_algunos_datos(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}



	@Then("^Recibo un mensaje de registro incorrecto$")
	public void recibo_un_mensaje_de_registro_incorrecto() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	
	@Given("^los datos de una persona$")
	public void los_datos_de_una_persona() {
		/*
		try {
			
	user.setNombre("Antonio");
		user.setApellidos("Pulido Hernandez")
		user.setDNI("94898879A");
		user.setContrasena("1111");
		user.setNumeroSS(1234);
		}catch(Exception e) {
			fail("Imposible crear usuario");
			
		}
		*/
	    throw new PendingException();
	}

	@When("^inserto los datos en la base de datos$")
	public void inserto_los_datos_en_la_base_de_datos() {
//		usersRepo.save(player);
		throw new PendingException();
	}

	@Then("^se inserta correctamente en la base de datos$")
	public void se_inserta_correctamente_en_la_base_de_datos() {
//		Usuario player=usersRepo.findByUserDNIAndPwd(user.getDNI(), user.getPassword());
		
	    throw new PendingException();
	}
	@When("^Relleno algunos datos$")
	public void relleno_algunos_datos() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^ClienteHttp$")
	public void script_en_postman() {
		OkHttpClient client = new OkHttpClient();


	}

	@When("^Envío petición Post con todos los campos$")
	public void envío_petición_Post_con_todos_los_campos() {
		 request = new Request.Builder()
				  .url("https://app-sanidad.herokuapp.com/registro?nombre=antonio&apellidos=Pulido%20Hern%C3%A1ndez&DNI=05928838N&numeroSS=123456789012&password=1111&repetir_password=1111")
				  .post(null)
				  .addHeader("User-Agent", "PostmanRuntime/7.18.0")
				  .addHeader("Accept", "*/*")
				  .addHeader("Cache-Control", "no-cache")
				  .addHeader("Postman-Token", "7cc93649-eb79-4eeb-b952-fe5ccd773563,0b89be15-3efb-4678-a305-b85363face50")
				  .addHeader("Host", "app-sanidad.herokuapp.com")
				  .addHeader("Accept-Encoding", "gzip, deflate")
				  .addHeader("Content-Length", "0")
				  .addHeader("Connection", "keep-alive")
				  .addHeader("cache-control", "no-cache")
				  .build();
	}

	@Then("^Recibo una respuesta satisfactoria$")
	public void recibo_una_respuesta_Okey() {
		try {
			Response response = client.newCall(request).execute();
			if(!response.isSuccessful()) {
				fail("Respuesta fallida");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    throw new PendingException();
	}

}
