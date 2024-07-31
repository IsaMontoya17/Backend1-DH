import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {
    private Map<String, Computadora> map;

    public ComputadoraFactory() {
        map = new HashMap<>();
    }

    //vamos a crear el get para chequear si la computadora existe, y sino, la vamos a crear
    public Computadora getComputadora(Integer ram, Integer discoDuro, String modelo) {
        //vamos a identificar a cada computadora
        String clave = "key " + ram + discoDuro + modelo;

        System.out.println(clave);

        //generar la lógica para chequear si existe -> la traemos(get), sino -> la creamos
        if (!map.containsKey(clave)){
            //lo creo y lo vamos a agregar al mapa
            map.put(clave, new Computadora(ram, discoDuro, modelo));
        }

        //si existe la computadora en el map, la retornamos (get)
        return map.get(clave);
    }
}
