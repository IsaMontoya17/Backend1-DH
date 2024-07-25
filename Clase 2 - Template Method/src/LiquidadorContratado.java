public class LiquidadorContratado extends Liquidador{
    @Override
    protected Double calculoSueldo(Empleado empleado) {
        Double respuesta = 0.0;

        //chequear que el empleado que recibimos sea una instancia de empleado contratado
        if (empleado instanceof EmpleadoContratado) {
            //generamos un empleado contratado casteandolo
            EmpleadoContratado contratado = (EmpleadoContratado) empleado;
            respuesta = contratado.getCantidadDeHora() * contratado.getValorPorHora();
        }
        return respuesta;
    }

    @Override
    protected String pagoSueldo(Empleado empleado) {
        return "un documento digital";
    }
}
