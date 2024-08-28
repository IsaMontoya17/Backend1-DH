package com.dh.Clase15_SpringMVC.dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

    private static final Logger LOGGER = Logger.getLogger(BD.class);

    private static final String DROP_CREATE_DOMICILIOS = "DROP TABLE IF EXISTS DOMICILIOS; CREATE TABLE " +
            "DOMICILIOS (" +
            "ID INT AUTO_INCREMENT PRIMARY KEY," +
            "CALLE VARCHAR(100) NOT NULL," +
            "NUMERO INT NOT NULL," +
            "LOCALIDAD VARCHAR(100) NOT NULL," +
            "PROVINCIA VARCHAR(100) NOT NULL)";

    private static final String DROP_CREATE_PACIENTES = "DROP TABLE IF EXISTS PACIENTES; CREATE TABLE " +
            "PACIENTES (" +
            "ID INT AUTO_INCREMENT PRIMARY KEY," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "APELLIDO VARCHAR(100) NOT NULL," +
            "DNI VARCHAR(100) NOT NULL," +
            "FECHA_ALTA DATE NOT NULL," +
            "DOMICILIO_ID INT NOT NULL)";


    private static final String SQL_INSERT_DOMICILIO = "INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) " +
            "VALUES ('Calle Azul', 12, 'Carrodilla', 'Mendoza')";

    private static final String SQL_INSERT_PACIENTE = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DNI, FECHA_ALTA, DOMICILIO_ID) " +
            "VALUES ('Daniela', 'Toro', '30.111.111', '2024-08-20', 1)";

    public static void createTable() {
        Connection connection = null;

        try {
            connection = getConnection();

            Statement statement = connection.createStatement();

            statement.execute(DROP_CREATE_PACIENTES);

            statement.execute(DROP_CREATE_DOMICILIOS);

            statement.execute(SQL_INSERT_DOMICILIO);
            statement.execute(SQL_INSERT_PACIENTE);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./202407", "sa", "sa");
    }
}
