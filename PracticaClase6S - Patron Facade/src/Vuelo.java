import java.time.LocalDate;

public class Vuelo {
    private LocalDate fechaSalida;
    private LocalDate fechaRegreso;
    private String ciudadOrigen;
    private String ciudadDestino;

    public Vuelo(LocalDate fechaSalida, LocalDate fechaRegreso, String ciudadOrigen, String ciudadDestino) {
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    @Override
    public String toString() {
        return "Vuelo:\n" +
                "fechaSalida = " + fechaSalida +
                "\nfechaRegreso = " + fechaRegreso +
                "\nciudadOrigen = " + ciudadOrigen +
                "\nciudadDestino = " + ciudadDestino +
                "\n----------------------------";
    }

}
