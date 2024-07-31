import java.util.List;

public class BusquedaImpl implements IBusqueda{

    public BusquedaImpl() {}

    @Override
    public void busquedaCompleta(Vuelo vueloBuscar, Hotel hotelBuscar, List<Vuelo> vuelos, List<Hotel> hoteles) {

        BusquedaVuelo busquedaVuelo = new BusquedaVuelo();
        BusquedaHotel busquedaHotel = new BusquedaHotel();

        busquedaVuelo.encontrarVuelo(vueloBuscar, vuelos);
        busquedaHotel.encontrarHotel(hotelBuscar, hoteles);

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
