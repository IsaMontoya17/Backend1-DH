package FacadeDP.actividad;

import java.time.LocalDate;
import java.util.ArrayList;

public class BusquedaVuelo {
  private ArrayList<Vuelo> listaVuelos;

  public BusquedaVuelo() {
    this.listaVuelos = new ArrayList<>();
  }

  public void buscarVuelo(LocalDate fechaSalida, String destino) {
    for (Vuelo vuelo : listaVuelos) {
      boolean cond1 = vuelo.getFechaSalida().equals(fechaSalida);
      boolean cond2 = vuelo.getDestino().equals(destino);
      if (cond1 &&  cond2) System.out.println(vuelo);
    }
  }

  public void setListaVuelos(ArrayList<Vuelo> listaVuelos) {
    this.listaVuelos = listaVuelos;
  }
}
