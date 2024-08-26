package com.digitalhouse.odontologiaAPIRest.dao.impl;

import com.digitalhouse.odontologiaAPIRest.dao.BD;
import com.digitalhouse.odontologiaAPIRest.dao.IDAO;
import com.digitalhouse.odontologiaAPIRest.domain.Domicilio;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDaoH2 implements IDAO<Domicilio> {

    private static final Logger LOGGER = Logger.getLogger(DomicilioDaoH2.class);

    private static final String INSERTAR = "INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?,?,?,?)";
    private static final String LISTAR  ="SELECT * FROM DOMICILIOS";
    private static final String CONSULTA_POR_ID = "SELECT * FROM DOMICILIOS WHERE ID=?";
    private static final String BORRAR_POR_ID = "DELETE FROM DOMICILIOS WHERE ID=?";
    private static final String ACTUALIZAR = "UPDATE DOMICILIOS SET CALLE=?, NUMERO=?, LOCALIDAD=?, PROVINCIA=? WHERE ID=?";

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection = null;

        try {

            connection =    BD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setInt(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            while (rs.next()) {
                domicilio.setId(rs.getInt(1));
            }

        }  catch (Exception e) {
            LOGGER.error("Error al guardar domicilio", e);
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Error al cerrar la conexión", ex);
            }
        }
        return domicilio;
    }

    @Override
    public List<Domicilio> listar() {
        LOGGER.info("Comenzamos a listar los domicilios");
        Connection connection = null;

        List<Domicilio> domicilioList = new ArrayList<>();
        Domicilio domicilio = null;

        try {
            connection = BD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(LISTAR);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                domicilio = new Domicilio(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4),
                        rs.getString(5));

                domicilioList.add(domicilio);

                LOGGER.info("Domicilio encontrado: ID = " + domicilio.getId() +
                        ", Calle = " + domicilio.getCalle() +
                        ", Número = " + domicilio.getNumero() +
                        ", Localidad = " + domicilio.getLocalidad() +
                        ", Provincia = " + domicilio.getProvincia()
                );
            }

            if (domicilioList.isEmpty()) {
                LOGGER.info("No se encontró ningún domicilio.");
            } else {
                LOGGER.info("Se listaron " + domicilioList.size() + " domicilios.");
            }

        } catch (Exception e) {
            LOGGER.error("Error al listar los domicilios", e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                LOGGER.error("Error al cerrar la conexión", ex);
            }
        }

        return domicilioList;
    }

    @Override
    public Domicilio consultarPorId(Integer id) {
        Connection connection = null;
        Domicilio domicilio = null;

        try {
            connection = BD.getConnection();

            PreparedStatement psBuscarPorId = connection.prepareStatement(CONSULTA_POR_ID);
            psBuscarPorId.setInt(1, id);
            ResultSet rs = psBuscarPorId.executeQuery();

            if (rs.next()) {
                domicilio = new Domicilio(
                        rs.getInt("ID"),
                        rs.getString("CALLE"),
                        rs.getInt("NUMERO"),
                        rs.getString("LOCALIDAD"),
                        rs.getString("PROVINCIA")
                );

                LOGGER.info("Domicilio encontrado: ID = " + domicilio.getId() +
                        ", Calle = " + domicilio.getCalle() +
                        ", Número = " + domicilio.getNumero() +
                        ", Localidad = " + domicilio.getLocalidad() +
                        ", Provincia = " + domicilio.getProvincia());
            } else {
                LOGGER.warn("No se encontró ningún domicilio con el ID: " + id);
            }

        } catch (Exception e) {
            LOGGER.error("Error al consultar el domicilio por ID: " + id, e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                LOGGER.error("Error al cerrar la conexión", ex);
            }
        }

        return domicilio;
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
                LOGGER.info("Domicilio con ID " + id + " eliminado correctamente.");
                eliminado = true;
            } else {
                LOGGER.warn("No se encontró ningún domicilio con el ID: " + id);
            }

        } catch (Exception e) {
            LOGGER.error("Error al eliminar el domicilio por ID: " + id, e);
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
    public Domicilio actualizar(Domicilio domicilio) {
        Connection connection = null;
        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(ACTUALIZAR);

            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setInt(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());
            preparedStatement.setInt(5, domicilio.getId());

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                LOGGER.info("Domicilio actualizado correctamente: ");
                LOGGER.info("ID: " + domicilio.getId());
                LOGGER.info("Calle: " + domicilio.getCalle());
                LOGGER.info("Número: " + domicilio.getNumero());
                LOGGER.info("Localidad: " + domicilio.getLocalidad());
                LOGGER.info("Provincia: " + domicilio.getProvincia());
            } else {
                LOGGER.warn("No se encontró ningún domicilio con el ID: " + domicilio.getId());
            }

        } catch (Exception e) {
            LOGGER.error("Error al actualizar el domicilio con ID: " + domicilio.getId(), e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                LOGGER.error("Error al cerrar la conexión", ex);
            }
        }
        return domicilio;
    }

}
