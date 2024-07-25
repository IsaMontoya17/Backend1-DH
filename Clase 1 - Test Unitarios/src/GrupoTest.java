import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {
    /* Dadas 5 personas (Juan, Pedro, Ana, Luz y Julián) y una colección vacía de
    objetos tipo Persona, cuando se intentan agregar estas a la colección, el
    tamaño de la colección debería ser 2 */

    @Test
    public void casoUno() {
        //arrange -> dado lo que necesito para hacer la prueba
        Persona juan = new Persona("Juan", 20);
        Persona pedro = new Persona("Pedro", 20);
        Persona ana = new Persona("Ana", 20);
        Persona luz = new Persona("Luz", 20);
        Persona julian = new Persona("Julián", 20);

        Grupo grupo1 = new Grupo();

        //act -> ocurre el proceso, la acción
        grupo1.agregarPersona(juan);
        grupo1.agregarPersona(pedro);
        grupo1.agregarPersona(ana);
        grupo1.agregarPersona(luz);
        grupo1.agregarPersona(julian);

        //assert -> comparo con lo que espero
        assertTrue(grupo1.getPersonas().size() == 2);

    }

    /*Dadas 5 personas (18 años, 17 años, 22 años, 14 años y 32 años), el tamaño de la colección debería ser 3.*/
    @Test
    public void casoDos() {
        //arrange -> dado lo que necesito para hacer la prueba
        Persona juana = new Persona("Juana", 18);
        Persona pedro = new Persona("Pedro", 17);
        Persona isabela = new Persona("Isabela", 22);
        Persona lucia = new Persona("Lucia", 14);
        Persona julian = new Persona("Julián", 32);

        Grupo grupo1 = new Grupo();

        //act -> ocurre el proceso, la acción
        grupo1.agregarPersona(juana);
        grupo1.agregarPersona(pedro);
        grupo1.agregarPersona(isabela);
        grupo1.agregarPersona(lucia);
        grupo1.agregarPersona(julian);

        //assert -> comparo con lo que espero
        assertTrue(grupo1.getPersonas().size() == 3);

    }

    /*Dado 5 personas (N1c0las, Tomas, 3steban, Carlos\sV, Francisco\sII), el tamaño de la colección debería ser 1. */
    @Test
    public void casoTres() {
        Persona nicolas = new Persona("N1c0las", 20);
        Persona tomas = new Persona("Tomas", 20);
        Persona esteban = new Persona("3steban", 20);
        Persona carlos = new Persona("Carlos\\sV", 20);
        Persona francisco = new Persona("Francisco\\sII", 20);

        Grupo grupo1 = new Grupo();

        grupo1.agregarPersona(nicolas);
        grupo1.agregarPersona(tomas);
        grupo1.agregarPersona(esteban);
        grupo1.agregarPersona(carlos);
        grupo1.agregarPersona(francisco);

        assertTrue(grupo1.getPersonas().size() == 1);

    }

}