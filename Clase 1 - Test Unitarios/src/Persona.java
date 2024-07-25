public class Persona {
    private String nombre;
    private Integer edad;

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    //crear métodos

    /*
    - La persona debería ser mayor de 18 años
    - El nombre debería tener más de 4 letras
    - El nombre debería contener solo letras de la a-z
    - La edad debería ser un número entre 0-9 => 3 caracteres - 120 años
    */

    public boolean esMayor() {
        return edad >= 18;
    }

    public boolean letrasCheck() {
        return nombre.length() >= 5;
    }


    //boolean -> false
    //Boolean -> null
    public boolean nombreCheck() {
        boolean respuesta = false;

        //creamos un array de chars
        char[] nombreEnChars;

        //le asignamos al array de chars que creamos las letras del nombre
        nombreEnChars = nombre.toCharArray();

        for (char letras: nombreEnChars) {
            if (!Character.isLetter(letras)) {
                return respuesta;
            }
        }

        respuesta = true;
        return respuesta;
    }

    public boolean edadCheck() {
        //si la persona tiene entre 0 y 120 de edad -> se agrega al grupo
        if (edad > 0 && edad < 120) {  //0 > edad < 120
            //se agrega al grupo
            return true;
        }
        return false;
    }



}
