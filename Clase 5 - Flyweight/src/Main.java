public class Main {
    public static void main(String[] args) {
        //creo una instancia para poder usar la fábrica de computadoras -> para aplicar el patrón
        ComputadoraFactory computadoraFactory = new ComputadoraFactory();

        //genero 4 computadoras
        Computadora computadora1 = computadoraFactory.getComputadora(2, 128, "Daniel"); //cada instancia va a imprimir el contador
        Computadora computadora2 = computadoraFactory.getComputadora(16, 500, "Erica");
        Computadora computadora3 = computadoraFactory.getComputadora(2, 128, "Daniel");
        Computadora computadora4 = computadoraFactory.getComputadora(16, 500, "Erica");
        Computadora computadora5 = computadoraFactory.getComputadora(16, 500, "Erica");
        Computadora computadora6 = computadoraFactory.getComputadora(16, 500, "Erica");
        Computadora computadora7 = computadoraFactory.getComputadora(16, 500, "Erica");
        Computadora computadora8 = computadoraFactory.getComputadora(16, 500, "Erica");
        Computadora computadora9 = computadoraFactory.getComputadora(16, 500, "Erica");

        //Imprimo por consola las computadoras
        System.out.println(computadora1);
        System.out.println(computadora2);
        System.out.println(computadora3);
        System.out.println(computadora4);
        System.out.println(computadora5);
        System.out.println(computadora6);
        System.out.println(computadora7);
        System.out.println(computadora8);
        System.out.println(computadora9);



    }
}
