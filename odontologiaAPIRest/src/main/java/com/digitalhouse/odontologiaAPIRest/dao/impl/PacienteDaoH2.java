package com.digitalhouse.odontologiaAPIRest.dao.impl;

import com.digitalhouse.odontologiaAPIRest.dao.BD;
import org.apache.log4j.Logger;
import com.digitalhouse.odontologiaAPIRest.domain.Paciente;
import com.digitalhouse.odontologiaAPIRest.dao.IDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDAO<Paciente> {

    private static final Logger LOGGER = Logger.getLogger(PacienteDaoH2.class);
    private static final String INSERTAR = "INSERT INTO PACIENTES (NOMBRE, APELLIDO, DOMICILIO, DNI, FECHA_ALTA) VALUES (?,?,?,?,?)";
    private static final String lISTAR = "SELECT * FROM PACIENTES";
    private static final String CONSULTA_POR_ID = "SELECT * FROM PACIENTES WHERE ID=?";
    private static final String BORRAR_POR_ID = "DELETE FROM PACIENTES WHERE ID=?";
    private static final String ACTUALIZAR = "UPDATE PACIENTES SET NOMBRE=?, APELLIDO=?, DOMICILIO=?, DNI=?, FECHA_ALTA=? WHERE ID=?";

    @Override
    public Paciente guardar(Paciente paciente) {
        LOGGER.info("Comenzamos a persistir un paciente");
        Connection connection = null;

        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getDomicilio());
            preparedStatement.setString(4, paciente.getDni());
            preparedStatement.setDate(5, Date.valueOf(paciente.getFechaAlta()));

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            while (rs.next()) {
                paciente.setId(rs.getInt(1));
                LOGGER.info("paciente guardado: " + paciente.getNombre() + " " + paciente.getApellido());
            }

        }  catch (Exception e) {
            LOGGER.error("Error al guardar paciente", e);
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Error al cerrar la conexión", ex);
            }
        }
        return paciente;
    }

    @Override
    public List<Paciente> listar() {
        LOGGER.info("Comenzamos a listar los pacientes");
        Connection connection = null;

        List<Paciente> pacienteList = new ArrayList<>();
        Paciente paciente = null;

        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(lISTAR);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                paciente = new Paciente(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getDate(6).toLocalDate());

                pacienteList.add(paciente);

                LOGGER.info("Paciente encontrado: ID = " + paciente.getId() +
                        ", Apellido = " + paciente.getApellido() +
                        ", Nombre = " + paciente.getNombre() +
                        ", Domicilio = " + paciente.getDomicilio() +
                        ", DNI = " + paciente.getDni() +
                        ", Fecha de alta = " + paciente.getFechaAlta()
                );
            }

            if (pacienteList.isEmpty()) {
                LOGGER.info("No se encontró ningún paciente.");
            } else {
                LOGGER.info("Se listaron " + pacienteList.size() + " pacientes.");
            }

        } catch (Exception e) {
            LOGGER.error("Error al listar los pacientes", e);
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Error al cerrar la conexión", ex);
            }
        }

        return pacienteList;
    }

    @Override
    public Paciente consultarPorId(Integer id) {
        Connection connection = null;
        Paciente paciente = null;

        try {
            connection = BD.getConnection();

            PreparedStatement psBuscarPorId = connection.prepareStatement(CONSULTA_POR_ID);
            psBuscarPorId.setInt(1, id);
            ResultSet rs = psBuscarPorId.executeQuery();

            if (rs.next()) {
                paciente = new Paciente(rs.getInt("ID"),
                        rs.getString("APELLIDO"),
                        rs.getString("NOMBRE"),
                        rs.getString("DOMICILIO"),
                        rs.getString("DNI"),
                        rs.getDate("FECHA_ALTA").toLocalDate());

                LOGGER.info("Paciente encontrado: ID = " + paciente.getId() +
                        ", Apellido = " + paciente.getApellido() +
                        ", Nombre = " + paciente.getNombre() +
                        ", Domicilio = " + paciente.getDomicilio() +
                        ", DNI = " + paciente.getDni() +
                        ", Fecha de alta = " + paciente.getFechaAlta());
            } else {
                LOGGER.warn("No se encontró ningún paciente con el ID: " + id);
            }

        } catch (Exception e) {
            LOGGER.error("Error al consultar el paciente por ID: " + id, e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                LOGGER.error("Error al cerrar la conexión", ex);
            }
        }

        return paciente;
    }

    @Override
    public Boolean eliminarPorId(Integer id) {
        Connection connection = null;
        Boolean eliminado = false;

        try {
            connection = BD.getConnection();

            PreparedStatement psEliminarPorId = connection.prepareStatement(BORRAR_POR_ID);
            psEliminarPorId.setInt(1, id);

            int filasBorradas = psEliminarPorId.executeUpdate();

            if (filasBorradas > 0) {
                LOGGER.info("Paciente con ID " + id + " eliminado correctamente.");
                eliminado = true;
            } else {
                LOGGER.warn("No se encontró ningún paciente con el ID: " + id);
            }

        } catch (Exception e) {
            LOGGER.error("Error al eliminar el paciente por ID: " + id, e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                LOGGER.error("Error al cerrar la conexión", ex);
            }
        }
        return eliminado;
    }


    @Override
    public Paciente actualizar(Paciente paciente) {
        Connection connection = null;
        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(ACTUALIZAR);

            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getDomicilio());
            preparedStatement.setString(4, paciente.getDni());
            preparedStatement.setDate(5, Date.valueOf(paciente.getFechaAlta()));
            preparedStatement.setInt(6, paciente.getId());

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                LOGGER.info("Paciente actualizado correctamente: ");
                LOGGER.info("ID: " + paciente.getId());
                LOGGER.info("Nombre: " + paciente.getNombre());
                LOGGER.info("Apellido: " + paciente.getApellido());
                LOGGER.info("Domicilio: " + paciente.getDomicilio());
                LOGGER.info("DNI: " + paciente.getDni());
                LOGGER.info("Fecha de Alta: " + paciente.getFechaAlta());
            } else {
                LOGGER.warn("No se encontró ningún paciente con el ID: " + paciente.getId());
            }

        } catch (Exception e) {
            LOGGER.error("Error al actualizar el paciente con ID: " + paciente.getId(), e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                LOGGER.error("Error al cerrar la conexión", ex);
            }
        }
        return paciente;
    }

}//CIERRE DE LA CLASE
