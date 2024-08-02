import org.apache.log4j.Logger;

public class CalculoMatematico {

    private final static Logger LOGGER = Logger.getLogger(CalculoMatematico.class);
    public double calculoDivision(double numerador, double denominador) {
        LOGGER.info("Se ingresó al método que calcula la división");
        if (denominador == 0) {
            LOGGER.warn("Log -> No se pudo dividir por cero");
            //si se divide un numero por cero -> nos va a dar error
            throw new ArithmeticException("No se puede dividir un número por cero");

        }
        LOGGER.info("Termino la ejecución del método");
        return numerador/denominador;
    }
}
