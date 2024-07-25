public class LiquidadorEfectivo extends Liquidador{

    //esta es la implementación para el calculo del empleado efectivo
    @Override
    protected Double calculoSueldo(Empleado empleado) {
        Double respuesta = 0d;

        //validar que el empleado sea efectivo
       if (empleado instanceof EmpleadoEfectivo) {
           EmpleadoEfectivo efectivo = (EmpleadoEfectivo)empleado;
           respuesta = efectivo.getSueldoBasico() + efectivo.getPremios() - efectivo.getDescuentos();
       }
        return respuesta;
    }

    @Override
    protected String pagoSueldo(Empleado empleado) {
        return "un documento impreso";
    }
}
