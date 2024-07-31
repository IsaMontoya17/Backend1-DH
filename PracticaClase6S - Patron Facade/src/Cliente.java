import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {

        List<Vuelo> vuelos = new ArrayList<>();
        vuelos.add(new Vuelo(LocalDate.of(2024, 8, 1), LocalDate.of(2024, 8, 15), "New York", "Los Angeles"));
        vuelos.add(new Vuelo(LocalDate.of(2024, 8, 5), LocalDate.of(2024, 8, 20), "London", "Paris"));
        vuelos.add(new Vuelo(LocalDate.of(2024, 8, 10), LocalDate.of(2024, 8, 25), "Tokyo", "Osaka"));
        vuelos.add(new Vuelo(LocalDate.of(2024, 8, 15), LocalDate.of(2024, 8, 30), "Berlin", "Munich"));
        vuelos.add(new Vuelo(LocalDate.of(2024, 8, 20), LocalDate.of(2024, 9, 5), "Sydney", "Melbourne"));
        vuelos.add(new Vuelo(LocalDate.of(2024, 8, 25), LocalDate.of(2024, 9, 10), "Toronto", "Vancouver"));
        vuelos.add(new Vuelo(LocalDate.of(2024, 9, 1), LocalDate.of(2024, 9, 15), "Madrid", "Barcelona"));
        vuelos.add(new Vuelo(LocalDate.of(2024, 9, 5), LocalDate.of(2024, 9, 20), "Rome", "Milan"));
        vuelos.add(new Vuelo(LocalDate.of(2024, 9, 10), LocalDate.of(2024, 9, 25), "Beijing", "Shanghai"));
        vuelos.add(new Vuelo(LocalDate.of(2024, 9, 15), LocalDate.of(2024, 9, 30), "Moscow", "Saint Petersburg"));

        List<Hotel> hoteles = new ArrayList<>();
        hoteles.add(new Hotel(LocalDate.of(2024, 8, 1), LocalDate.of(2024, 8, 5), "New York"));
        hoteles.add(new Hotel(LocalDate.of(2024, 8, 6), LocalDate.of(2024, 8, 10), "Los Angeles"));
        hoteles.add(new Hotel(LocalDate.of(2024, 8, 11), LocalDate.of(2024, 8, 15), "Paris"));
        hoteles.add(new Hotel(LocalDate.of(2024, 8, 16), LocalDate.of(2024, 8, 20), "London"));
        hoteles.add(new Hotel(LocalDate.of(2024, 8, 21), LocalDate.of(2024, 8, 25), "Tokyo"));
        hoteles.add(new Hotel(LocalDate.of(2024, 8, 26), LocalDate.of(2024, 8, 30), "Osaka"));
        hoteles.add(new Hotel(LocalDate.of(2024, 9, 1), LocalDate.of(2024, 9, 5), "Berlin"));
        hoteles.add(new Hotel(LocalDate.of(2024, 9, 6), LocalDate.of(2024, 9, 10), "Munich"));
        hoteles.add(new Hotel(LocalDate.of(2024, 9, 11), LocalDate.of(2024, 9, 15), "Sydney"));
        hoteles.add(new Hotel(LocalDate.of(2024, 9, 16), LocalDate.of(2024, 9, 20), "Melbourne"));

        //ciudad Destino y fecha salida
        Vuelo vueloBuscar = new Vuelo(LocalDate.of(2024, 8, 1), LocalDate.of(2024, 8, 15), "New York", "Los Angeles");
        Hotel hotelBuscar = new Hotel(LocalDate.of(2024, 8, 6), LocalDate.of(2024, 8, 10), "Los Angeles");
        BusquedaImpl busqueda = new BusquedaImpl();
        busqueda.busquedaCompleta(vueloBuscar, hotelBuscar, vuelos, hoteles);

    }
}
