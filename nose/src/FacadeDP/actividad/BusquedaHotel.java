package FacadeDP.actividad;

import java.util.ArrayList;

public class BusquedaHotel {
  private ArrayList<Hotel> listaHoteles;

  public BusquedaHotel() {
    this.listaHoteles = new ArrayList();
  }

  public void buscarHotel(String ciudadDestino) {
    for (Hotel hotel : listaHoteles) {
      if (hotel.getCiudad().equals(ciudadDestino)) System.out.println(hotel);
    }
  }

  public void setListaHoteles(ArrayList<Hotel> listaHoteles) {
    this.listaHoteles = listaHoteles;
  }
}
