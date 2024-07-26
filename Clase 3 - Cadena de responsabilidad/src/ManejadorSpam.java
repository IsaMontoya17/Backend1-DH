public class ManejadorSpam extends Manejador{
    @Override
    public String compruebaMail(Mail mail) {
        System.out.println("Nunca pasó por Spam. Erica :)");
        return "El corre lo procesa Spam";
    }
}
