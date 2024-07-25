import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<Persona> personas;

    public Grupo() {
        //le estoy dando a la lista un lugar en memoria
        this.personas = new ArrayList<>();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void agregarPersona(Persona persona) {
        boolean personaEsMayor = persona.esMayor();
        boolean personaLetrasCheck = persona.letrasCheck();
        boolean personaNombreCheck = persona.nombreCheck();
        boolean personaEdadCheck = persona.edadCheck();

        if(personaEsMayor && personaLetrasCheck && personaNombreCheck && personaEdadCheck) {
            //agregamos a la persona
            personas.add(persona);
            System.out.println("Se agregó la persona " + persona.getNombre());
        } else {
            System.out.println("No se pudo agregar a la persona " + persona.getNombre());
            if(!personaEsMayor) {
                System.out.println("La persona no es mayor de edad");
            }
            if(!personaLetrasCheck) {
                System.out.println("El nombre no tiene más de 4 letras");
            }
            if(!personaNombreCheck) {
                System.out.println("El nombre no contiene solo letras");
            }
            if(!personaEdadCheck) {
                System.out.println("La persona no tiene 0 y 120 años");
            }
        }
    }
}
