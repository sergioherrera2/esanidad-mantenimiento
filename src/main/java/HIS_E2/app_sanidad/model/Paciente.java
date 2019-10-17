package HIS_E2.app_sanidad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente extends Usuario {
	
	@Column(name = "numSS")
	int numeroSS;

	public Paciente() {
		
	}

	public int getNumeroSS() {
		return numeroSS;
	}

	public void setNumeroSS(int numeroSS) {
		this.numeroSS = numeroSS;
	}
	
}
