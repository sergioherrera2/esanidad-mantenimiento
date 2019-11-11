package HIS_E2.app_sanidad.model;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "especialidad")
public class Especialidad {
	
	String nombreEspecialidad;
	int duracionCita;
	
	public Especialidad(String nombreEspecialidad, int duracionCita) {
		super();
		this.nombreEspecialidad = nombreEspecialidad;
		this.duracionCita = duracionCita;
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
		return "Especialidad [nombreEspecialidad=" + nombreEspecialidad
				+ ", duracionCita=" + duracionCita + "]";
	}
	
}
