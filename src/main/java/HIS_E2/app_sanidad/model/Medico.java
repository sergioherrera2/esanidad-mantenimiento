package HIS_E2.app_sanidad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico extends Usuario{

	@Column(name = "especialidad")
	int idEspecialidad;
	
	public Medico() {
		
	}

	public int getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	
}
