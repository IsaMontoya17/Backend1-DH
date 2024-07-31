import java.util.ArrayList;
import java.util.List;

public class BusquedaHotel {
    private List<Hotel> hotelesEncontrados;

    public BusquedaHotel() {
        this.hotelesEncontrados = new ArrayList<>();
    }

    public List<Hotel> getHotelesEncontrados() {
        return hotelesEncontrados;
    }

    public void encontrarHotel(Hotel hotelBuscar, List<Hotel> hoteles){
        for (Hotel hotel: hoteles) {
            if (hotel.equals(hotelBuscar)) {
                hotelesEncontrados.add(hotel);
            }
        }
    }
}
