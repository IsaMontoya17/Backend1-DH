import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {

        List<Vuelo> vuelos = new ArrayList<>();
        vuelos.add(new Vuelo(LocalDate.of(2024, 8, 1), LocalDate.of(2024, 8, 15), "New York", "Los Angeles"));
        vuelos.add(new Vuelo(LocalDate.of(2024, 8, 5), LocalDate.of(2024, 8, 20), "London", "Paris"));
        vuelos.add(new Vuelo(LocalDate.of(2024, 8, 1), LocalDate.of(2024, 8, 25), "Tokyo", "Los Angeles"));
        vuelos.add(new Vuelo(LocalDate.of(2024, 8, 15), LocalDate.of(2024, 8, 30), "Berlin", "Munich"));

        List<Hotel> hoteles = new ArrayList<>();
        hoteles.add(new Hotel(LocalDate.of(2024, 8, 1), LocalDate.of(2024, 8, 5), "Los Angeles"));
        hoteles.add(new Hotel(LocalDate.of(2024, 8, 6), LocalDate.of(2024, 8, 10), "Los Angeles"));
        hoteles.add(new Hotel(LocalDate.of(2024, 8, 11), LocalDate.of(2024, 8, 15), "Paris"));
        hoteles.add(new Hotel(LocalDate.of(2024, 8, 1), LocalDate.of(2024, 8, 25), "Los Angeles"));


        String ciudadDestino = "Los Angeles";
        LocalDate fecha = LocalDate.of(2024, 8, 1);
        BusquedaImpl busqueda = new BusquedaImpl();

        busqueda.busquedaCompleta(ciudadDestino, fecha, vuelos, hoteles);

    }
}
