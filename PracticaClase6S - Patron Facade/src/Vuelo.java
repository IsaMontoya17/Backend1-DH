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


    @Override
    public String toString() {
        return "Vuelo:\n" +
                "fechaSalida = " + fechaSalida +
                "\nfechaRegreso = " + fechaRegreso +
                "\nciudadOrigen = " + ciudadOrigen +
                "\nciudadDestino = " + ciudadDestino +
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
        Vuelo vuelo = (Vuelo) obj;
        return fechaSalida.equals(vuelo.fechaSalida) &&
                fechaRegreso.equals(vuelo.fechaRegreso) &&
                ciudadOrigen.equals(vuelo.ciudadOrigen) &&
                ciudadDestino.equals(vuelo.ciudadDestino);
    }

}
