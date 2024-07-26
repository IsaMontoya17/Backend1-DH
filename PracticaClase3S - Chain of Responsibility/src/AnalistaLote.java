public class AnalistaLote extends AnalistaDeCalidad{

    @Override
    public String compruebaCalidad(Articulo articulo) {
        if (articulo.getLote()>1000 && articulo.getLote()<2000) {
            System.out.println("lote aprobado");
            return getSiguienteaAnalistaDeCalidad().compruebaCalidad(articulo);
        } else {
            System.out.println("lote rechazado");
            System.out.println("no cumple con el requisito de lote, el articulo es RECHAZADO");
            return "no cumple con el requisito de lote, el articulo es RECHAZADO";
        }
    }
}
