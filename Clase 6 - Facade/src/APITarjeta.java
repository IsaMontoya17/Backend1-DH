public class APITarjeta {
    public static int descuento(Tarjeta tarjeta) {
        if (tarjeta.getBanco().equals("Star Bank")) {
            return 20;
        }
        return 0;
    }
}
