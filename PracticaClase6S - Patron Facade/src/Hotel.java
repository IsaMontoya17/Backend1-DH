import java.time.LocalDate;

public class Hotel {
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private String ciudad;

    public Hotel(LocalDate fechaEntrada, LocalDate fechaSalida, String ciudad) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.ciudad = ciudad;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String toString() {
        return "Hotel:\n" +
                "fechaEntrada = " + fechaEntrada +
                "\nfechaSalida = " + fechaSalida +
                "\nciudad = " + ciudad +
                "\n----------------------------";
    }

}
