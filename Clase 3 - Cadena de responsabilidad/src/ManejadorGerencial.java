public class ManejadorGerencial extends Manejador {
    @Override
    public String compruebaMail(Mail mail) {
        if (mail.getAsunto().equals("Gerencia") ||
        mail.getDestino().equals("gerencia@colmena.com")) {
            return "El correo lo procesa la Gerencia";
        } else {
            System.out.println("El correo pasó por gerencial");
            return getSiguienteManejador().compruebaMail(mail);
        }
    }
}
