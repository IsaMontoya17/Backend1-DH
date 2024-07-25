public class EmpleadoEfectivo extends Empleado {
    private Double sueldoBasico;
    private Double descuentos;
    private Double premios;


    public EmpleadoEfectivo(String nombre, String apellido, String numeroDeCuenta, Double sueldoBasico, Double descuentos, Double premios) {
        super(nombre, apellido, numeroDeCuenta);
        this.sueldoBasico = sueldoBasico;
        this.descuentos = descuentos;
        this.premios = premios;
    }

    public Double getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(Double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public Double getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(Double descuentos) {
        this.descuentos = descuentos;
    }

    public Double getPremios() {
        return premios;
    }

    public void setPremios(Double premios) {
        this.premios = premios;
    }
}
