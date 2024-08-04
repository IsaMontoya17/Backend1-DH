public class Figura {
    private static int contador = 1;
    private String tipoFigura;
    private String color;
    private int id;

    public Figura(String tipoFigura, String color) {
        this.tipoFigura = tipoFigura;
        this.color = color;
        this.id = contador++;
    }

    public String getTipoFigura() {
        return tipoFigura;
    }

    public String getColor() {
        return color;
    }

    public int getId() {
        return id;
    }
}
