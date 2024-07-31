public class Supermercado {
    public static void main(String[] args) {
        Descuento descuento = new Descuento();

        Tarjeta tarjetaDeSupermercado = new Tarjeta("Star Bank", "123");
        Producto productoDeSupermercado = new Producto("Gaseosa", "lata");
        int cantidadDeSupermercado = 15;

        int descuentoTotal = descuento.descuentoTotal(tarjetaDeSupermercado, productoDeSupermercado, cantidadDeSupermercado);
        System.out.println("El descuento es de " + descuentoTotal); // 20 + 10 + 15 = 45

    }
}
