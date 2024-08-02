import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Operaciones {
    private List<Integer> listaEnteros;
    private static final Logger LOGGER = Logger.getLogger(Operaciones.class);

    public Operaciones() {
        this.listaEnteros = new ArrayList<>();
    }

    public void agregarEntero(Integer numero){
        listaEnteros.add(numero);
        if(listaEnteros.size() > 5){
            LOGGER.info("La longitud de la lista es mayor a 5");
        }
        if(listaEnteros.size() > 10){
            LOGGER.info("La longitud de la lista es mayor a 10");
        }
    }

    public double calcularPromedio() {
        if (listaEnteros == null || listaEnteros.isEmpty()) {
            LOGGER.error("La lista esta vacia");
            throw new IllegalArgumentException("La lista no puede estar vacía o ser nula");
        }
        double suma = 0d;
        for (int numero : listaEnteros) {
            suma += numero;
        }
        LOGGER.info("El promedio de la lista es " + suma / listaEnteros.size());
        return suma / listaEnteros.size();
    }

    public Integer encontrarMaximo() {
        if (listaEnteros == null || listaEnteros.isEmpty()) {
            LOGGER.error("La lista esta vacia");
            throw new IllegalArgumentException("La lista no puede estar vacía o ser nula");
        }
        Integer maximo = listaEnteros.get(0);
        for (int numero : listaEnteros) {
            if (numero > maximo) {
                maximo = numero;
            }
        }
        return maximo;
    }

    public Integer encontrarMinimo() {
        if (listaEnteros == null || listaEnteros.isEmpty()) {
            LOGGER.error("La lista esta vacia");
            throw new IllegalArgumentException("La lista no puede estar vacía o ser nula");
        }
        Integer minimo = listaEnteros.get(0);
        for (int numero : listaEnteros) {
            if (numero < minimo) {
                minimo = numero;
            }
        }
        return minimo;
    }
}
