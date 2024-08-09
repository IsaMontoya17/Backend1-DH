import dao.BD;
import modelo.Paciente;
import servicio.PacienteServicio;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BD.createTable(); //la tabla se va a crear una sola vez

        Paciente paciente = new Paciente("Erica",
                "Mar",
                "Colombia",
                "123",
                LocalDate.of(2024,03,03));

        PacienteServicio servicio = new PacienteServicio();

        servicio.guardar(paciente);

        System.out.println("Este es el paciente original");
        System.out.println(paciente.toString());

        paciente.setNombre("Daniela");
        servicio.actualizar(paciente);

        System.out.println("Este es el paciente modificado");
        System.out.println(paciente.toString());

        Paciente paciente2 = new Paciente("Bruno",
                "Apellido",
                "Colombia",
                "123",
                LocalDate.of(2024,03,03));

        Paciente paciente3 = new Paciente("Israel",
                "Apellido",
                "Colombia",
                "123",
                LocalDate.of(2024,03,03));

        servicio.guardar(paciente2);
        servicio.guardar(paciente3);

        servicio.listarTodos();


    }
}
