public class AnalistaEnvase extends AnalistaDeCalidad{
    @Override
    public String compruebaCalidad(Articulo articulo) {
        if (articulo.getEnvasado().equals("sano") || articulo.getEnvasado().equals("casi sano")) {
            System.out.println("envase aceptado");
            System.out.println("El articulo es ACEPTADO");
            return "El articulo es ACEPTADO";
        } else {
            System.out.println("envase rechazado");
            System.out.println("no cumple con el requisito de envase, el articulo es RECHAZADO");
            return "no cumple con el requisito de envase, el articulo es RECHAZADO";
        }
    }
}
