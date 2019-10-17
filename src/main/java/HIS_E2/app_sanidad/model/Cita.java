package HIS_E2.app_sanidad.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cita")
public class Cita {
	
	@Id
	int idCita;
	@Column(name = "fecha")
	Date fecha;
	@Column(name = "dniMedico")
	String dniMedico;
	@Column(name = "dniPaciente")
	String dniPaciente;
	
	public Cita() {
		
	}
	
	public int getIdCita() {
		return idCita;
	}
	
	public void setIdCita(int idCita) {
		this.idCita = idCita;
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
	
}
