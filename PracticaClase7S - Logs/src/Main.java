import org.apache.log4j.Logger;

public class Main {
    public static void main(String[] args) throws Exception {
        Operaciones operaciones = new Operaciones();

        operaciones.agregarEntero(10);
        operaciones.agregarEntero(1);
        operaciones.agregarEntero(12);
        operaciones.agregarEntero(-1);
        operaciones.agregarEntero(-3);
        operaciones.agregarEntero(100);
        operaciones.agregarEntero(-10);
        operaciones.agregarEntero(45);
        operaciones.agregarEntero(21);
        operaciones.agregarEntero(1);
        operaciones.agregarEntero(33);

        Integer maximo = operaciones.encontrarMaximo();
        Integer minimo = operaciones.encontrarMinimo();
        double promedio = operaciones.calcularPromedio();

        System.out.println("El maximo numero de la lista es: " + maximo);
        System.out.println("El minimo numero de la lista es: " + minimo);
        System.out.println("El promedio de la lista es: " + promedio);

    }
}
