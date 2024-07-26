import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VacunatorioProxyTest {
    @Test
    public void casoCorrecto() {
        //arrange
        Persona persona = new Persona("Ayxa",
                "Chaverra",
                "123",
                LocalDate.of(2024,3, 1),
                "Pfizer");

        VacunatorioProxy control = new VacunatorioProxy();

        String respuestaEsperada = "Vacunación confirmada de: 123 " +
                "con fecha asignada: 2024-03-01 " +
                "y vacuna: Pfizer";

        //act
        String respuestaActual = control.vacunar(persona);

        //assert
        assertEquals(respuestaEsperada, respuestaActual);
    }
}