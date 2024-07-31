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

    public void encontrarVuelo(Vuelo vueloBuscar, List<Vuelo> vuelos){
        for (Vuelo vuelo : vuelos) {
            if (vuelo.equals(vueloBuscar)) {
                vuelosEncontrados.add(vuelo);
            }
        }
    }
}
