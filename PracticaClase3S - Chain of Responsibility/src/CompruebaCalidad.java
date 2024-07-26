public class CompruebaCalidad {

    private AnalistaDeCalidad analistaDeCalidad;

    public String validarCalidadDelProducto(Articulo articulo) {
        return analistaDeCalidad.compruebaCalidad(articulo);
    }
    public CompruebaCalidad() {

        analistaDeCalidad = new AnalistaLote();

        AnalistaDeCalidad peso = new AnalistaPeso();
        AnalistaDeCalidad envase = new AnalistaEnvase();

        analistaDeCalidad.setSiguienteaAnalistaDeCalidad(peso);
        peso.setSiguienteaAnalistaDeCalidad(envase);

    }
}
