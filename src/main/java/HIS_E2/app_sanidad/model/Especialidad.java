package HIS_E2.app_sanidad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "especialidad")
public class Especialidad {

	@Id
	int idEspecialidad;
	@Column(name = "nombreEspecialidad")
	String nombreEspecialidad;
	@Column(name = "duracionCita")
	int duracionCita;
	
	public Especialidad() {
		
	}

	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}

	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}

	public int getDuracionCita() {
		return duracionCita;
	}

	public void setDuracionCita(int duracionCita) {
		this.duracionCita = duracionCita;
	}
	
}
