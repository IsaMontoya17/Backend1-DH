import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiquidadorTest {

    @Test
    public void CasoUno() {
        //arrange
        Empleado empleado = new EmpleadoEfectivo("Martín", "Martini", "123", 400d, 40d, 60d);
        Liquidador liquidador = new LiquidadorEfectivo();
        String respuestaEsperada = "La liquidación generada es un documento" + " impreso. Saldo a liquidar: 420.0";

        //act
        String calcular = liquidador.liquidarSueldo(empleado);

        //assert
        assertEquals(respuestaEsperada, calcular);
    }

    @Test
    public void CasoDos() {
        //arrange
        Empleado empleado = new EmpleadoContratado("Pompilia", "Pompini", "321", 7d, 120);
        Liquidador liquidador = new LiquidadorContratado();
        String respuestaEsperada = "La liquidación generada es un documento" + " digital. Saldo a liquidar: 840.0";

        //act
        String calcular = liquidador.liquidarSueldo(empleado);

        //assert
        assertEquals(respuestaEsperada, calcular);
    }

    @Test
    public void CasoTres() {
        //arrange
        Empleado empleado1 = new EmpleadoContratado("Pompilia", "Pompini", "321", -7d, 120);
        Liquidador liquidador1 = new LiquidadorContratado();
        String respuestaEsperada1 = "La liquidación no pudo ser calculada";

        //act
        String calcular1 = liquidador1.liquidarSueldo(empleado1);

        //assert
        assertEquals(respuestaEsperada1, calcular1);

        //arrange
        Empleado empleado2 = new EmpleadoEfectivo("Martín", "Martini", "123", -400d, 40d, 60d);
        Liquidador liquidador2 = new LiquidadorEfectivo();
        String respuestaEsperada2 = "La liquidación no pudo ser calculada";

        //act
        String calcular2 = liquidador2.liquidarSueldo(empleado2);

        //assert
        assertEquals(respuestaEsperada2, calcular2);
    }

}