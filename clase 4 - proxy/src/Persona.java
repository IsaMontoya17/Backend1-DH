import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaAsignada;
    private String nombreDeVacuna;

    public Persona(String nombre, String apellido, String dni, LocalDate fechaAsignada, String nombreDeVacuna) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaAsignada = fechaAsignada;
        this.nombreDeVacuna = nombreDeVacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaAsignada() {
        return fechaAsignada;
    }

    public void setFechaAsignada(LocalDate fechaAsignada) {
        this.fechaAsignada = fechaAsignada;
    }

    public String getNombreDeVacuna() {
        return nombreDeVacuna;
    }

    public void setNombreDeVacuna(String nombreDeVacuna) {
        this.nombreDeVacuna = nombreDeVacuna;
    }
}
