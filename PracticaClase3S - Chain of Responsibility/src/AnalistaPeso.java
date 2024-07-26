public class AnalistaPeso extends AnalistaDeCalidad{
    @Override
    public String compruebaCalidad(Articulo articulo) {
        if (articulo.getPeso()>1200 && articulo.getPeso()<1300) {
            System.out.println("Peso aprobado");
            return getSiguienteaAnalistaDeCalidad().compruebaCalidad(articulo);
        } else {
            System.out.println("peso rechazado");
            System.out.println("no cumple con el requisito de peso, el articulo es RECHAZADO");
            return "no cumple con el requisito de peso, el articulo es RECHAZADO";
        }
    }
}
