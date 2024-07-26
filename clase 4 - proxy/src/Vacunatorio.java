public class Vacunatorio implements IVacunatorio{
    @Override
    public String vacunar(Persona persona) {
        //En el momento de la vacunación, se debe registrar la
        //confirmación con el DNI, fecha y vacuna.
        return "Vacunación confirmada de: " + persona.getDni()
                + " con fecha asignada: " + persona.getFechaAsignada()
                + " y vacuna: " + persona.getNombreDeVacuna();
    }
}
