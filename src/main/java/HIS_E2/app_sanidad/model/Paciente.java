package HIS_E2.app_sanidad.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "paciente")
public class Paciente extends Usuario {
	
	int numeroSS;


	public Paciente(String dni, String nombre, String apellidos, String contrs, int numeroSS) throws Exception {
		super(dni, nombre, apellidos, contrs);
		this.numeroSS = numeroSS;
	}

	public int getNumeroSS() {
		return numeroSS;
	}

	public void setNumeroSS(int numeroSS) {
		this.numeroSS = numeroSS;
	}
	
	@Override
	public String toString() {
		return "Paciente [numeroSS=" + numeroSS + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", contrs=" + contrs + ", centroSalud=" + centroSalud + "]";
	}
}
