package HIS_E2.app_sanidad.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "horario")
public class Horario {

  ObjectId _id;
  String dniMedico;
  int duracionCita;
  Date horaInicio;
  Date horaFin;

  public Horario(String dniMedico,
      int duracionCita, Date horaInicio, Date horaFin) {
    super();
    this.dniMedico = dniMedico;
    this.duracionCita = duracionCita;
    this.horaInicio = horaInicio;
    this.horaFin = horaFin;
  }

  public String getdniMedico() {
    return dniMedico;
  }

  public void setdniMedico(String dniMedico) {
    this.dniMedico = dniMedico;
  }

  public int getDuracionCita() {
    return duracionCita;
  }

  public void setDuracionCita(int duracionCita) {
    this.duracionCita = duracionCita;
  }

  public Date getHoraInicio() {
    return horaInicio;
  }

  public void setHoraInicio(Date horaInicio) {
    this.horaInicio = horaInicio;
  }

  public Date getHoraFin() {
    return horaFin;
  }

  public void setHoraFin(Date horaFin) {
    this.horaFin = horaFin;
  }

  @Override
  public String toString() {
    return "Especialidad [dniMedico=" + dniMedico
        + ", duracionCita=" + duracionCita + "]";
  }
}

