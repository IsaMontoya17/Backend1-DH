public class EmpleadoContratado extends Empleado {
    private Double valorPorHora;
    private Integer cantidadDeHora;

    public EmpleadoContratado(String nombre, String apellido, String numeroDeCuenta, Double valorPorHora, Integer cantidadDeHora) {
        super(nombre, apellido, numeroDeCuenta);
        this.valorPorHora = valorPorHora;
        this.cantidadDeHora = cantidadDeHora;
    }

    public Double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(Double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public Integer getCantidadDeHora() {
        return cantidadDeHora;
    }

    public void setCantidadDeHora(Integer cantidadDeHora) {
        this.cantidadDeHora = cantidadDeHora;
    }
}
