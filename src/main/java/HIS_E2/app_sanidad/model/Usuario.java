package HIS_E2.app_sanidad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@Inheritance( strategy = InheritanceType.JOINED)
public class Usuario {
	
	@Id
	String dni;
	@Column(name = "nombre")
	String nombre;
	@Column(name = "apellidos")
	String apellidos;
	@Column(name = "contrasenia")
	String contrs;
	@Column(name = "centro_salud")
	int centroSalud;

	public Usuario() {
		
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrs() {
		return contrs;
	}

	public void setContrs(String contrs) {
		this.contrs = contrs;
	}

	public int getCentroSalud() {
		return centroSalud;
	}

	public void setCentroSalud(int centroSalud) {
		this.centroSalud = centroSalud;
	}
	
}
