import java.time.LocalDate;
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

    public void encontrarHotel(String ciudadDestino, LocalDate fechaEntrada, List<Hotel> hoteles){
        for (Hotel hotel: hoteles) {
            if (hotel.getCiudad().equals(ciudadDestino) && hotel.getFechaEntrada().equals(fechaEntrada)) {
                hotelesEncontrados.add(hotel);
            }
        }
    }
}
