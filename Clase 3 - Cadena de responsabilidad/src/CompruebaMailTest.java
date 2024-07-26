import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompruebaMailTest {

    @Test
    public void mailATecnica() {
        //arrange -> dado
        Mail mail = new Mail("test@colmena.com",
                "tecnica@colmena.com",
                "Rotura de colmena");
        CompruebaMail compruebaMail = new CompruebaMail();

        String respuestaEsperada = "El correo lo procesa la Técnica";

        //act -> cuando el proceso ocurre
        String proceso = compruebaMail.checkMail(mail);

        //assert -> comprobar
        assertEquals(respuestaEsperada, proceso);
    }

    @Test
    public void mailASpam() {
        //arrange -> dado
        Mail mail = new Mail("test@colmena.com",
                "erica@colmena.com",
                "Rotura de colmena");
        CompruebaMail compruebaMail = new CompruebaMail();

        String respuestaEsperada = "El corre lo procesa Spam";

        //act -> cuando el proceso ocurre
        String proceso = compruebaMail.checkMail(mail);

        //assert -> comprobar
        assertEquals(respuestaEsperada, proceso);
    }

    @Test
    public void mailAComprobar() {
        //arrange -> dado
        Mail mail = new Mail("test@colmena.com",
                "gerencia@colmena.com",
                "Comercial");
        CompruebaMail compruebaMail = new CompruebaMail();

        String respuestaEsperada = "El corre lo procesa Spam";

        //act -> cuando el proceso ocurre
        String proceso = compruebaMail.checkMail(mail);

        //assert -> comprobar
        assertEquals(respuestaEsperada, proceso);
    }
}