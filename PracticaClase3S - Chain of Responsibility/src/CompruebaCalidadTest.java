import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompruebaCalidadTest {

    @Test
    public void articuloAprobado(){
        Articulo articulo = new Articulo("rubor", 1200, 1250, "sano");
        CompruebaCalidad compruebaCalidad = new CompruebaCalidad();

        String respuestaEsperada = "El articulo es ACEPTADO";

        String proceso = compruebaCalidad.validarCalidadDelProducto(articulo);

        assertEquals(respuestaEsperada, proceso);
    }

    @Test
    public void articuloNoAprobado(){
        Articulo articulo = new Articulo("lipgloss", 1300, 1250, " casi");
        CompruebaCalidad compruebaCalidad = new CompruebaCalidad();

        String respuestaEsperada = "no cumple con el requisito de envase, el articulo es RECHAZADO";

        String proceso = compruebaCalidad.validarCalidadDelProducto(articulo);

        assertEquals(respuestaEsperada, proceso);
    }

}