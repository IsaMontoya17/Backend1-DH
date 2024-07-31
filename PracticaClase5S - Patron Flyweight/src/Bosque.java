import java.util.ArrayList;
import java.util.List;

public class Bosque {

    private List<Arbol> arboles;
    private ArbolFactory arbolFactory;

    public Bosque() {
        this.arboles = new ArrayList<>();
        this.arbolFactory = new ArbolFactory();
    }

    public void plantarArboles(int cantidad) {
        for (int i = 0; i < cantidad / 2; i++) {
            Arbol arbolRojo = arbolFactory.getArbol("Frutal", 500, 300, "rojo");
            arboles.add(arbolRojo);
            Arbol arbolVerde = arbolFactory.getArbol("Ornamental", 200, 400, "verde");
            arboles.add(arbolVerde);
        }
    }

    public void mostrarInformacion() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024) + " MB");

        for (Arbol arbol : arboles) {
            System.out.println("Arbol de tipo " + arbol.getTipo() + " con altura de " +
                    arbol.getAlto() + ", ancho de " + arbol.getHorizontal() + " y de color " + arbol.getColor());
        }
    }
}
