package HIS_E2.app_sanidad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest
@RunWith(SpringRunner.class)
public class Stepdefs {
    @Autowired
    private MockMvc mockMvc;
    WebDriver driver;	
	@Given("^Abrir Firefox y escribir url de la aplicación$")
	public void abrir_Firefox_y_escribir_url_de_la_aplicación() {

	    try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/HIS_E2/app_sanidad/geckodriver.exe");
		    System.setProperty("webdriver.gecko.driver", "src/test/resources/HIS_E2/app_sanidad/geckodriver.exe");					

		    
		    driver = new FirefoxDriver();		
		    driver.manage().window().maximize();
		    
	    driver.get("http://app-sanidad.herokuapp.com");
	    }catch(Exception e) {
	    	fail("Can't connecto to application");
	    }
	}

	@When("^escribir usuario y contraseña$")
	public void escribir_usuario_y_contraseña() {
		try {
		       driver.findElement(By.name("username")).sendKeys("username12");							
		       driver.findElement(By.name("password")).sendKeys("password12");	
		}catch(Exception e) {
			fail("No se encuentran los campos");
		}

	    
	}
	@Then("^clickeas boton login y se abre pagina de listas$")
	public void se_abre_pagina_de_listas() {
	       driver.findElement(By.name("btnLogin")).click();
	       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	       String new_url = driver.getCurrentUrl();
	       assertEquals(new_url, "http://app-sanidad.herokuapp.com/citas", "URL before login and after login must be different");
	}
	
	
	
	@When("^escribes solo usuario$")
	public void escribes_solo_usuario() {
		try {
		       driver.findElement(By.name("username")).sendKeys("username12");							

		}catch(Exception e) {
			fail("No se encuentran los campos");
		}

	}

	@When("^escribes solo contraseña$")
	public void escribes_solo_contraseña() {
		try {
			driver.findElement(By.name("password")).sendKeys("password12");
		}catch(Exception e) {
			fail("No se encuentran los campos");
		}

	}
	@When("^no escribes usuario y contraseña$")
	public void no_escribes_usuario_y_contraseña() {
	    // Write code here that turns the phrase above into concrete actions

	}

	@Then("^clickeas boton login y no se abre página con las citas$")
	public void clickeas_boton_login_y_no_se_abre_página_con_las_citas() {
		try{
			driver.findElement(By.name("btnLogin")).click();
		}catch(Exception e) {
			fail("No existe el boton de login");
		}
	       
	       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	       String new_url = driver.getCurrentUrl();
	       assertNotEquals(new_url, "app-sanidad.herokuapp.com/citas", "URL cant be app-sanidad.herokuapp.com/citas");
	}

	@Then("^petición aceptada$")
	public void petición_aceptada()  {
	       try {
			this.mockMvc.perform(get("/citas") .param("username", "a").param("password", "a")).andExpect(status().isOk());
		} catch (Exception e) {
			fail("No funciona la petición GET");
		}
	}

}
