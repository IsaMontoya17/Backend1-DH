import java.time.LocalDate;
import java.util.List;

public class BusquedaImpl implements IBusqueda{

    public BusquedaImpl() {}

    @Override
    public void busquedaCompleta(String ciudadDestino, LocalDate fechaSalida, List<Vuelo> vuelos, List<Hotel> hoteles) {

        BusquedaVuelo busquedaVuelo = new BusquedaVuelo();
        BusquedaHotel busquedaHotel = new BusquedaHotel();

        busquedaVuelo.encontrarVuelo(ciudadDestino, fechaSalida, vuelos);
        busquedaHotel.encontrarHotel(ciudadDestino, fechaSalida, hoteles);

        mostrarInformacion(busquedaVuelo, busquedaHotel);

    }

    static void mostrarInformacion(BusquedaVuelo busquedaVuelo, BusquedaHotel busquedaHotel){
        System.out.println("Vuelos encontrados:\n");
        for (Vuelo vuelo : busquedaVuelo.getVuelosEncontrados()) {
            System.out.println(vuelo);
        }

        System.out.println("Hoteles encontrados:\n");
        for (Hotel hotel : busquedaHotel.getHotelesEncontrados()) {
            System.out.println(hotel);
        }
    }
}
