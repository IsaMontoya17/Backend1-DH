import dao.BD;
import modelo.Paciente;
import modelo.Odontologo;
import servicio.PacienteService;
import servicio.OdontologoService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // ejecucion del script sql
        BD.correrSQLScript("src/main/java/bd/create_tables.sql");

        // ------------ services ------------
        PacienteService pacienteService = new PacienteService();
        OdontologoService odontologoService = new OdontologoService();

        // ----------- instancias ------------

        //paciente
        Paciente paciente1 = new Paciente("Erica", "Mar", "Colombia", "123", LocalDate.of(2024,03,03));
        Paciente paciente2 = new Paciente("Bruno", "Apellido", "Colombia", "123", LocalDate.of(2024,03,03));
        Paciente paciente3 = new Paciente("Israel", "Apellido", "Colombia", "123", LocalDate.of(2024,03,03));

        //odontologo
        Odontologo odontologo1 = new Odontologo("García", "Luis", "MAT1234");
        Odontologo odontologo2 = new Odontologo("Martínez", "Ana", "MAT5678");

        pacienteService.guardar(paciente1);

        System.out.println("Este es el paciente original");
        System.out.println(paciente1.toString());

        paciente1.setNombre("Daniela");
        pacienteService.actualizar(paciente1);

        System.out.println("Este es el paciente modificado");
        System.out.println(paciente1.toString());

        pacienteService.guardar(paciente2);
        pacienteService.guardar(paciente3);

        pacienteService.listarTodos();

        odontologoService.guardar(odontologo1);
        odontologoService.guardar(odontologo2);

        odontologoService.listar();

    }
}
