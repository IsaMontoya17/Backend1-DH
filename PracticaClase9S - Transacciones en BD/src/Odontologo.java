public class Odontologo {
    private String apellido;
    private String nombre;
    private String matricula;
    private int id;

    public Odontologo(String apellido, String nombre, String matricula, int id) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getId() {
        return id;
    }
}
