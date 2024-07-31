package FacadeDP.actividad;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Hotel hotel1 = new Hotel(LocalDate.of(2024, 6, 25), LocalDate.of(2024, 7, 25), "Lima");
    Hotel hotel2 = new Hotel(LocalDate.of(2024, 2, 25), LocalDate.of(2024, 4, 25), "Quito");
    Hotel hotel3 = new Hotel(LocalDate.of(2024, 5, 25), LocalDate.of(2024, 8, 25), "Bogota");
    Hotel hotel4 = new Hotel(LocalDate.of(2024, 10, 25), LocalDate.of(2024, 12, 25), "Buenos Aires");
    Hotel hotel5 = new Hotel(LocalDate.of(2024, 11, 25), LocalDate.of(2024, 12, 25), "Santiago");

    Vuelo vuelo1 = new Vuelo(LocalDate.of(2024, 6, 25), LocalDate.of(2024, 7, 25), "Quito", "Bogota");
    Vuelo vuelo2 = new Vuelo(LocalDate.of(2024, 2, 25), LocalDate.of(2024, 4, 25), "Lima", "Buenos Aires");
    Vuelo vuelo3 = new Vuelo(LocalDate.of(2024, 5, 25), LocalDate.of(2024, 8, 25), "Santiago", "Quito");
    Vuelo vuelo4 = new Vuelo(LocalDate.of(2024, 10, 25), LocalDate.of(2024, 12, 25), "Buenos Aires", "Santiago");
    Vuelo vuelo5 = new Vuelo(LocalDate.of(2024, 9, 25), LocalDate.of(2024, 11, 25), "Caracas", "Bogota");

    ArrayList<Vuelo> vuelos = new ArrayList<>();
    ArrayList<Hotel> hoteles = new ArrayList<>();

    vuelos.add(vuelo1);
    vuelos.add(vuelo2);
    vuelos.add(vuelo3);
    vuelos.add(vuelo4);
    vuelos.add(vuelo5);

    hoteles.add(hotel1);
    hoteles.add(hotel2);
    hoteles.add(hotel3);
    hoteles.add(hotel4);
    hoteles.add(hotel5);

    BusquedaImpl busqueda = new BusquedaImpl(vuelos, hoteles);

    busqueda.buscar(LocalDate.of(2024, 5, 25), "Buenos Aires");
  }
}
