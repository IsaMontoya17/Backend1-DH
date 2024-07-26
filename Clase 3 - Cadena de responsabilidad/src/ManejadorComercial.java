public class ManejadorComercial extends Manejador {
    @Override
    public String compruebaMail(Mail mail) {
        if (mail.getAsunto().equals("Comercial") ||
                mail.getDestino().equals("comercial@colmena.com")) {
            return "El correo lo procesa Comercial";
        } else {
            System.out.println("El correo pasó por comercial");
            return getSiguienteManejador().compruebaMail(mail);
        }
    }
}
