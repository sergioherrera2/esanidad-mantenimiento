package HIS_E2.app_sanidad.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "especialidad")
public class Especialidad {
	
	@Id
	int idEspecialidad;
	String nombreEspecialidad;
	int duracionCita;
	

	public Especialidad(int idEspecialidad, String nombreEspecialidad, int duracionCita) {
		super();
		this.idEspecialidad = idEspecialidad;
		this.nombreEspecialidad = nombreEspecialidad;
		this.duracionCita = duracionCita;
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

	@Override
	public String toString() {
		return "Especialidad [idEspecialidad=" + idEspecialidad + ", nombreEspecialidad=" + nombreEspecialidad
				+ ", duracionCita=" + duracionCita + "]";
	}
	
}
