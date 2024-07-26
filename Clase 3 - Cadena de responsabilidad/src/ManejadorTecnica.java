public class ManejadorTecnica extends Manejador {

    @Override
    public String compruebaMail(Mail mail) {
        if (mail.getAsunto().equals("Técnico") ||
                mail.getDestino().equals("tecnica@colmena.com")) {
            return "El correo lo procesa la Técnica";
        } else {
            System.out.println("El correo pasó por tecnica");
            return getSiguienteManejador().compruebaMail(mail);
        }
    }
}
