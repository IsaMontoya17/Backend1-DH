package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

    private static final String DROP_CREATE = "DROP TABLE IF EXISTS MEDICAMENTOS; CREATE " +
            "TABLE MEDICAMENTOS (" +
            "ID INT PRIMARY KEY AUTO_INCREMENT," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "LABORATORIO VARCHAR(100) NOT NULL," +
            "CANTIDAD INT NOT NULL," +
            "PRECIO NUMERIC(10,2) NOT NULL," +
            "CODIGO INT NOT NULL)";

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./backend1", "sa", "sa");
    }

    public static void createTable() {
        Connection connection = null;

        try {
            connection = getConnection();

            Statement statement = connection.createStatement();
            statement.execute(DROP_CREATE);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
