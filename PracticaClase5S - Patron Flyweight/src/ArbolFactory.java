import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {
    private Map<String, Arbol> map;

    public ArbolFactory() {
        map = new HashMap<>();
    }

    public Arbol getArbol(String tipo, double alto, double horizontal, String color) {

        String clave = tipo + "-" + alto + "-" + horizontal + "-" + color;
        System.out.println(clave);

        if (!map.containsKey(clave)){
            map.put(clave, new Arbol(tipo, alto, horizontal, color));
        }

        return map.get(clave);
    }
}
