package FacadeDP.actividad;

import java.time.LocalDate;

public class Hotel {
  private LocalDate fechaEntrada;
  private LocalDate fechaSalida;
  private String ciudad;

  public Hotel(LocalDate fechaEntrada, LocalDate fechaSalida, String ciudad) {
    this.fechaEntrada = fechaEntrada;
    this.fechaSalida = fechaSalida;
    this.ciudad = ciudad;
  }

  public LocalDate getFechaEntrada() {
    return fechaEntrada;
  }

  public void setFechaEntrada(LocalDate fechaEntrada) {
    this.fechaEntrada = fechaEntrada;
  }

  public LocalDate getFechaSalida() {
    return fechaSalida;
  }

  public void setFechaSalida(LocalDate fechaSalida) {
    this.fechaSalida = fechaSalida;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  @Override
  public String toString() {
    return "Hotel{" +
        "fechaEntrada=" + fechaEntrada +
        ", fechaSalida=" + fechaSalida +
        ", ciudad='" + ciudad + '\'' +
        '}';
  }
}
