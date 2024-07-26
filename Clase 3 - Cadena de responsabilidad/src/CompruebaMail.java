public class CompruebaMail {

    //tiene como atributo también al manejador
    private Manejador manejador;

    //método para comprobar los mail (-> abstracto)
    public String checkMail(Mail mail) {
        return manejador.compruebaMail(mail);
    }

    //como armamos la cadena
    public CompruebaMail() {
        //punto inicial de la cadena
        //definimos que el primer manejador sea Gerencial
        manejador = new ManejadorGerencial();

        //siguientes pasos de la cadena
        Manejador comercial = new ManejadorComercial();
        Manejador tecnica = new ManejadorTecnica();
        Manejador spam = new ManejadorSpam();

        //unir o definir la cadena de manejadores
        manejador.setSiguienteManejador(comercial);
        comercial.setSiguienteManejador(tecnica);
        tecnica.setSiguienteManejador(spam);

        //-> vamos seteando la cadena de manejadores de acuerdo
        //a lo que dispongamos

    }

}
