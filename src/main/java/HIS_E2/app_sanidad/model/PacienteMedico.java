package HIS_E2.app_sanidad.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PacienteMedico")
public class PacienteMedico {

	String dniPaciente;
	String dniMedico;
	String especialidad;
	
	public String getDniPaciente() {
		return dniPaciente;
	}
	public void setDniPaciente(String dniPaciente) {
		this.dniPaciente = dniPaciente;
	}
	public String getDniMedico() {
		return dniMedico;
	}
	public void setDniMedico(String dniMedico) {
		this.dniMedico = dniMedico;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
}
