public abstract class Manejador {

    //agregamos un atributo que es la misma clase
    //vamos a programar el orden :
    // Gerencia -> Comercial -> Técnica -> Jose -> Spam
    private Manejador siguienteManejador;

    //este método es el que vamos a hacer que implementen
    //todos los manejadores que tengamos
    public abstract String compruebaMail(Mail mail);

    //agregamos getter y setter
    public Manejador getSiguienteManejador() {
        return siguienteManejador;
    }

    public void setSiguienteManejador(Manejador siguienteManejador) {
        this.siguienteManejador = siguienteManejador;
    }
}
