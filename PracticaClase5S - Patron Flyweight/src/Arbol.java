public class Arbol {
    private String tipo;
    private double alto;
    private double horizontal;
    private String color;
    private static int contador;

    public Arbol(String tipo, double alto, double horizontal, String color) {
        this.tipo = tipo;
        this.alto = alto;
        this.horizontal = horizontal;
        this.color = color;
        contador++;
        System.out.println("El valor del constructor es: " + contador);
    }

    public static int get(int contador) {
        return  contador;
    }

    public String getTipo() {
        return tipo;
    }

    public double getAlto() {
        return alto;
    }

    public double getHorizontal() {
        return horizontal;
    }

    public String getColor() {
        return color;
    }
}
