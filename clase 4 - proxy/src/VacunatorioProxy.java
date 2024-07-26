import java.time.LocalDate;

public class VacunatorioProxy implements IVacunatorio{

    private Vacunatorio vacunatorio;

    public VacunatorioProxy() {
        this.vacunatorio = new Vacunatorio();
    }

    @Override
    public String vacunar(Persona persona) {
        //establezco la fecha de hoy
        LocalDate hoy = LocalDate.now();

        //comparo con la fecha de vacunación asignada
        if (hoy.isAfter(persona.getFechaAsignada())) {
            //si es posterior se tiene vacunar
            //TODO: crear el atributo y la instancia
            return vacunatorio.vacunar(persona);

        }
        return "No se puede vacunar. Vuelva luego de la fecha asignada";
    }
}
