package HIS_E2.app_sanidad.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@Document(collection = "cita")
public class Cita {
	
	@JsonDeserialize(using = DateHandler.class)
	Date fecha;
	String dniMedico;
	String dniPaciente;

	
	public Cita(Date fecha, String dniMedico, String dniPaciente) {
		super();
		this.fecha = fecha;
		this.dniMedico = dniMedico;
		this.dniPaciente = dniPaciente;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getDniMedico() {
		return dniMedico;
	}
	
	public void setDniMedico(String dniMedico) {
		this.dniMedico = dniMedico;
	}
	
	public String getDniPaciente() {
		return dniPaciente;
	}
	
	public void setDniPaciente(String dniPaciente) {
		this.dniPaciente = dniPaciente;
	}

	@Override
	public String toString() {
		return "Cita [Fecha=" + fecha.toString() + ", dniMedico=" + dniMedico + ", dniPaciente="
				+ dniPaciente + "]";
	}
	
}