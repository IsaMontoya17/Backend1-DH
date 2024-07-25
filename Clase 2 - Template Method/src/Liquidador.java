//esta es la clase abstracta donde desarrollamos el template method
public abstract class Liquidador {
    //método -> algoritmo
    public String liquidarSueldo(Empleado empleado) {
        String respuesta = "La liquidación no pudo ser calculada";

        //calcular

        Double calculo = calculoSueldo(empleado);
        if (calculo > 0) {
            //imprimir
            String pago = pagoSueldo(empleado);

            respuesta = "La liquidación generada es " + pago + ". Saldo a liquidar: " + calculo;
        }

        //depositar
        String deposito = depositoSueldo(empleado);
        return respuesta;

    }

    protected abstract Double calculoSueldo(Empleado empleado);

    protected abstract String pagoSueldo(Empleado empleado);

    private String depositoSueldo(Empleado empleado){
        return "Se depositó el sueldo de: " + empleado.getNumeroDeCuenta();
    }

}
