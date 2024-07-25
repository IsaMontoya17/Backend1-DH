import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {
    @Test
    public void testMostrarNombre() {
        Persona persona = new Persona("Juan", "Pérez", "juan.perez@example.com", 25);
        String expected = "Pérez, Juan";

        // Capturar la salida de mostrarNombre
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        persona.mostrarNombre();

        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    public void testMayor18anios() {
        // Fecha fija: 21/09/2021
        Persona persona1 = new Persona("Juan", "Pérez", "juan.perez@example.com", 25); // mayor de 18
        Persona persona2 = new Persona("María", "Gómez", "maria.gomez@example.com", 17); // menor de 18
        Persona persona3 = new Persona("Ana", "Martínez", "ana.martinez@example.com", 18); // exactamente 18

        assertTrue(persona1.mayor18anios(), "Juan debería ser mayor de 18 años.");
        assertFalse(persona2.mayor18anios(), "María no debería ser mayor de 18 años.");
        assertTrue(persona3.mayor18anios(), "Ana debería ser mayor de 18 años.");
    }
}