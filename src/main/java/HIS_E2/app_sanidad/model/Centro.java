package HIS_E2.app_sanidad.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "centro")
public class Centro {

  String nombre;
  String localidad;

  public Centro(String nombre, String localidad) {
    super();
    this.nombre = nombre;
    this.localidad = localidad;
  }

  public Centro() {

  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getLocalidad() {
    return localidad;
  }

  public void setLocalidad(String localidad) {
    this.localidad = localidad;
  }

  @Override
  public String toString() {
    return "Centro [nombre=" + nombre + ", localidad=" + localidad + "]";
  }

}
