import java.time.LocalDate;
import java.util.List;

public interface IBusqueda {
    public void busquedaCompleta(String ciudadDestino, LocalDate fechaSalida, List<Vuelo> vuelos, List<Hotel> hoteles);
}
