public abstract class AnalistaDeCalidad {

    private AnalistaDeCalidad siguienteaAnalistaDeCalidad;

    public AnalistaDeCalidad getSiguienteaAnalistaDeCalidad() {
        return siguienteaAnalistaDeCalidad;
    }

    public void setSiguienteaAnalistaDeCalidad(AnalistaDeCalidad siguienteaAnalistaDeCalidad) {
        this.siguienteaAnalistaDeCalidad = siguienteaAnalistaDeCalidad;
    }

    public abstract String compruebaCalidad(Articulo articulo);
}
