package HIS_E2.app_sanidad.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario")
public class Usuario {
	
	@Id
	String dni;
	String nombre;
	String apellidos;
	String contrs;
	int centroSalud;

	public Usuario(String dni, String nombre, String apellidos, String contrs) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contrs = contrs;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", contrs=" + contrs
				+ ", centroSalud=" + centroSalud + "]";
	}
	
}
