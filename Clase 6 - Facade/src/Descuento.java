public class Descuento implements IDescuento{
    @Override
    public int descuentoTotal(Tarjeta tarjeta, Producto producto, int cantidad) {
        int descuento = 0;

        descuento += APITarjeta.descuento(tarjeta); //si se cumple se va acumulando el descuento
        descuento += APIProducto.descuento(producto);
        descuento += APICantidad.descuento(cantidad);

        return descuento;
    }
}
