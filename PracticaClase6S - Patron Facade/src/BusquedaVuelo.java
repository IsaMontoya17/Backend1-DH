import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BusquedaVuelo {
    private List<Vuelo> vuelosEncontrados;

    public BusquedaVuelo() {
        this.vuelosEncontrados = new ArrayList<>();
    }

    public List<Vuelo> getVuelosEncontrados() {
        return vuelosEncontrados;
    }

    public void encontrarVuelo(String ciudadDestino, LocalDate fechaSalida, List<Vuelo> vuelos){
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getCiudadDestino().equals(ciudadDestino) && vuelo.getFechaSalida().equals(fechaSalida)) {
                vuelosEncontrados.add(vuelo);
            }
        }
    }
}
