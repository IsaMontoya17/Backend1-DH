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

    @Override
    public String toString() {
        return "Hotel:\n" +
                "fechaEntrada = " + fechaEntrada +
                "\nfechaSalida = " + fechaSalida +
                "\nciudad = " + ciudad +
                "\n----------------------------";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Hotel hotel = (Hotel) obj;
        return fechaEntrada.equals(hotel.fechaEntrada) &&
                fechaSalida.equals(hotel.fechaSalida) &&
                ciudad.equals(hotel.ciudad);
    }
}
