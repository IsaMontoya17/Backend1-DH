package com.digitalhouse.odontologia.dao.impl;

import com.digitalhouse.odontologia.dao.BD;
import com.digitalhouse.odontologia.domain.Odontologo;
import org.apache.log4j.Logger;
import com.digitalhouse.odontologia.dao.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDAO<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        LOGGER.info("Comenzamos a persistir un odontólogo");

        Connection connection = null;
        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO ODONTOLOGOS (APELLIDO, NOMBRE, MATRICULA) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, odontologo.getApellido());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getMatricula());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            while (rs.next()) {
                odontologo.setId(rs.getInt(1));
                LOGGER.info("Odontólogo guardado: " + odontologo.getNombre() + " " + odontologo.getApellido());
            }

        } catch (Exception e) {
            LOGGER.error("Error al guardar odontólogo", e);
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Error al cerrar la conexión", ex);
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listar() {
        LOGGER.info("Comenzamos a listar los odontólogos");

        Connection connection = null;
        List<Odontologo> listaOdontologos = new ArrayList<>();

        try {
            connection = BD.getConnection();

            String sqlOdontologos = "SELECT * FROM ODONTOLOGOS";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlOdontologos);

            while (rs.next()) {
                Odontologo odontologo = new Odontologo();
                odontologo.setId(rs.getInt("ID"));
                odontologo.setApellido(rs.getString("APELLIDO"));
                odontologo.setNombre(rs.getString("NOMBRE"));
                odontologo.setMatricula(rs.getString("MATRICULA"));

                listaOdontologos.add(odontologo);

                LOGGER.info("Odontólogo encontrado: ID = " + odontologo.getId() +
                        ", Apellido = " + odontologo.getApellido() +
                        ", Nombre = " + odontologo.getNombre() +
                        ", Matrícula = " + odontologo.getMatricula());
            }

            if (listaOdontologos.isEmpty()) {
                LOGGER.info("No se encontró ningún odontólogo.");
            } else {
                LOGGER.info("Se listaron " + listaOdontologos.size() + " odontólogos.");
            }

        } catch (Exception e) {
            LOGGER.error("Error al listar los odontólogos", e);
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Error al cerrar la conexión", ex);
            }
        }

        return listaOdontologos;
    }

    @Override
    public Odontologo consultarPorId(Integer id) {

        Connection connection = null;
        Odontologo odontologo = null;

        try {
            connection = BD.getConnection();

            PreparedStatement psBuscarPorId = connection.prepareStatement(
                    "SELECT * FROM ODONTOLOGOS WHERE ID=?"
            );
            psBuscarPorId.setInt(1, id);
            ResultSet rs = psBuscarPorId.executeQuery();

            if (rs.next()) {
                odontologo = new Odontologo();
                odontologo.setId(rs.getInt(1));
                odontologo.setApellido(rs.getString(2));
                odontologo.setNombre(rs.getString(3));
                odontologo.setMatricula(rs.getString(4));

                LOGGER.info("Odontólogo encontrado: ID = " + odontologo.getId() +
                        ", Apellido = " + odontologo.getApellido() +
                        ", Nombre = " + odontologo.getNombre() +
                        ", Matrícula = " + odontologo.getMatricula());
            } else {
                LOGGER.warn("No se encontró ningún odontólogo con el ID: " + id);
            }

        } catch (Exception e) {
            LOGGER.error("Error al consultar el odontólogo por ID: " + id, e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                LOGGER.error("Error al cerrar la conexión", ex);
            }
        }

        return odontologo;
    }


    @Override
    public void eliminarPorId(Integer id) {

    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        return null;
    }
}