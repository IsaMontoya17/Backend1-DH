package com.digitalhouse.odontologiaAPIRest.dao;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

    private static final String SQL_INSERT_ODONTOLOGO = "INSERT INTO ODONTOLOGOS (APELLIDO, NOMBRE, MATRICULA) " +
            "VALUES ('Daniela', 'Toro', '123')";
    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./backend1", "sa", "sa");
    }

    public static void correrSQLScript(String filePath) {
        Connection connection = null;

        try {
            connection = getConnection();
            String sqlScript = new String(Files.readAllBytes(Paths.get(filePath)));
            Statement statement = connection.createStatement();
            statement.execute(sqlScript);
            System.out.println("Script SQL ejecutado con éxito.");

            //-----------------------------------------
            statement.execute(SQL_INSERT_ODONTOLOGO);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}