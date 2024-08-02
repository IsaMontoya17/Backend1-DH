import org.apache.log4j.Logger;

public class Matematica {

    private static final Logger LOGGER = Logger.getLogger(Matematica.class);

    public static void main(String[] args) {

        CalculoMatematico calculoMatematico = new CalculoMatematico();

        try {
            LOGGER.info("Se inicio la ejecución del programa");
            double resultado = calculoMatematico.calculoDivision(10d, 0d);
        } catch (ArithmeticException e) {
            System.out.println("Se produjo un error al dividir por cero " + e.getMessage());
            LOGGER.error("Se produjo un error al dividir por cero " + e.getMessage());
        }

    }
}
