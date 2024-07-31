package FacadeDP.actividad;

import java.time.LocalDate;
import java.util.ArrayList;

public class BusquedaImpl implements IBusqueda {
  private BusquedaVuelo busquedaVuelo;
  private BusquedaHotel busquedaHotel;

  public BusquedaImpl(ArrayList<Vuelo> vuelos, ArrayList<Hotel> hoteles ) {
    this.busquedaVuelo = new BusquedaVuelo();
    this.busquedaHotel = new BusquedaHotel();

    busquedaVuelo.setListaVuelos(vuelos);
    busquedaHotel.setListaHoteles(hoteles);
  }

  @Override
  public void buscar(LocalDate fechaSalida, String destino) {
    busquedaVuelo.buscarVuelo(fechaSalida, destino);
    busquedaHotel.buscarHotel(destino);
  }
}
