public class APIProducto {
    public static int descuento(Producto producto) {
        if (producto.getTipo().equals("lata")) {
            return 10;
        }
        return 0;
    }
}
