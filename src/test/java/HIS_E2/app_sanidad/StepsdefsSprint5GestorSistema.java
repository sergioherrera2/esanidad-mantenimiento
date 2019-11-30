package HIS_E2.app_sanidad;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.springframework.beans.factory.annotation.Autowired;

import HIS_E2.app_sanidad.controller.Manager;
import HIS_E2.app_sanidad.model.Centro;
import HIS_E2.app_sanidad.model.Cifrador;
import HIS_E2.app_sanidad.model.Medico;
import HIS_E2.app_sanidad.repositories.MedicoRepository;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsdefsSprint5GestorSistema {

  @Autowired
  MedicoRepository medicoRepo;
  Centro centro = new Centro();
  Medico medico = new Medico();

  @Given("^tengo un centro su nombre \"([^\"]*)\",localidad \"([^\"]*)\"$")
  public void tengo_un_centro_su_nombre_localidad(String nombreCentro, String localidadCentro) {
    centro = Manager.get().consultarCentro(nombreCentro, localidadCentro);
    try {
      Medico test = new Medico("71360861A", "Sergio", "Herrera Piqueras", "123456", "Traumatólogo");
      Manager.get().crearMedico(test.getDni(), test.getIdEspecialidad());
    } catch (Exception e) {
      fail("Debería haberse creado el médico con los datos de prueba");
      e.printStackTrace();
    }
  }

  @Given("^Tengo de un medico su dni \"([^\"]*)\"$")
  public void tengo_de_un_medico_su_dni(String dniMedico) {
    try {
      medico = medicoRepo.findByDni(Cifrador.cifrar(dniMedico));
    } catch (Exception e) {
      fail("No se ha encontrado el médico");
      e.printStackTrace();
    }

  }

  @When("^asigno el centro \"([^\"]*)\"$")
  public void asigno_el_centro(String arg1) {
    medico.setCentroSalud(centro.getNombre());

    try {
      Manager.get().eliminarMedico(medico.getDni());
    } catch (Exception e) {
      fail("Fallo actualizando el centro del médico: debería borrarse el médico antiguo");
      e.printStackTrace();
    }

    try {
      Manager.get().crearMedico(medico.getDni(), medico.getIdEspecialidad(), medico.getCentroSalud());
    } catch (Exception e1) {
      fail("Debería haberse creado el médico");
      e1.printStackTrace();
    }

  }

  @Then("^el médico se ha guardado con dni \"([^\"]*)\", centro \"([^\"]*)\"$")
  public void el_médico_se_ha_guardado_con_dni_centro(String arg1, String arg2) {
    Medico medico2 = medicoRepo.findByDni(medico.getDni());
    // assertNotEquals(medico2.getCentroSalud(), null);
    assertTrue(medico2.getCentroSalud() != null);
    try {
      Manager.get().eliminarMedico(medico2.getDni());
    } catch (Exception e) {
      fail("Debería haberse borrado el médico de prueba");
      e.printStackTrace();
    }
  }
}
