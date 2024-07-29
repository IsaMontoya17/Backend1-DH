import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioDescargaProxyTest {

    @Test
    public void usuarioPremium(){
        Usuario usuario = new Usuario("123", TipoUsuario.PREMIUM);
        ServicioDescargaProxy servicioDescargaProxy = new ServicioDescargaProxy();
        String cancion = "contigo";
        String respuestaEsperada = "El usuario con id " + usuario.getId() + " descargo exitosamente la cancion " + cancion;

        String respuesta = servicioDescargaProxy.descargar(cancion, usuario);

        assertEquals(respuestaEsperada, respuesta);
    }

    @Test
    public void usuarioFree(){
        Usuario usuario = new Usuario("456", TipoUsuario.FREE);
        ServicioDescargaProxy servicioDescargaProxy = new ServicioDescargaProxy();
        String cancion = "contigo";
        String respuestaEsperada = "El usuario con id " + usuario.getId() + " no puede descargar canciones ";

        String respuesta = servicioDescargaProxy.descargar(cancion, usuario);

        assertEquals(respuestaEsperada, respuesta);
    }

}