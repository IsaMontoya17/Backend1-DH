import java.sql.*;

public class Animal {

    public static void main(String[] args) {
        //acá vamos a escribir el código para guardar y recuperar datos de la BD

        //genero la conexión en null
        Connection c = null;

        try {
            //dentro del bloque try (porque puede fallar la conexión) hacemos la conexión
            //Conexión a la BD
            c = getConnection();

            //Le vamos a dar una orden a la BD
            Statement statement = c.createStatement();

            //drop - create de la tabla
            statement.execute("DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES " +
                    "(ID INT PRIMARY KEY, " + //columna 1
                    "NOMBRE VARCHAR(100) NOT NULL," + //columna 2
                    "TIPO VARCHAR(100) NOT NULL)"); //columna 3

            //insertar valores en la tabla que creamos
            statement.execute("INSERT INTO ANIMALES VALUES (1, 'Garras', 'León'), " +
                    "(2, 'Melman', 'Jirafa'), (3, 'Gloria', 'Hipopotamos')");

            ResultSet rs = statement.executeQuery("SELECT * FROM ANIMALES");

            while (rs.next()) {
                System.out.println("Nombre: " + rs.getString(2) + " y el tipo es: " +
                         rs.getString(3));
            }

            System.out.println("Finalizó la consulta");

            //vamos a hacer ahora, una consulta por id
            ResultSet rsId = statement.executeQuery("SELECT * FROM ANIMALES WHERE ID = 2");

            while (rsId.next()) {
                System.out.println("Iniciando la consulta por id ....");
                System.out.println("Id: " + rsId.getInt(1) + " Nombre " + rsId.getString(2) + " y tipo: "
                + rsId.getString(3));
            }

            System.out.println("Finalizó la consulta por id");



        } catch (Exception e) {
            e.getMessage();

        } finally {
            //necesitamos cerrar la conexión
            try {
                c.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }

    }

    //vamos a generar un método para CONECTARNOS a la BD
    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        String url = "jdbc:h2:./202407";
        return DriverManager.getConnection(url, "sa", "sa");
    }

}
