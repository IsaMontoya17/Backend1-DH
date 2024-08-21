package com.digitalhouse.odontologiaAPIRest.dao.impl;

import com.digitalhouse.odontologiaAPIRest.dao.BD;
import com.digitalhouse.odontologiaAPIRest.domain.Odontologo;
import org.apache.log4j.Logger;
import com.digitalhouse.odontologiaAPIRest.dao.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDAO<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);
    private static final String INSERTAR = "INSERT INTO ODONTOLOGOS (APELLIDO, NOMBRE, MATRICULA) VALUES (?,?,?)";
    private static final String lISTAR = "SELECT * FROM ODONTOLOGOS";
    private static final String CONSULTA_POR_ID = "SELECT * FROM ODONTOLOGOS WHERE ID=?";
    private static final String BORRAR_POR_ID = "DELETE FROM ODONTOLOGOS WHERE ID=?";
    private static final String ACTUALIZAR = "UPDATE ODONTOLOGOS SET NOMBRE=?, APELLIDO=?, MATRICULA=? WHERE ID=?";
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        LOGGER.info("Comenzamos a persistir un odontólogo");

        Connection connection = null;
        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(INSERTAR, Statement.RETURN_GENERATED_KEYS);

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

        List<Odontologo> odontologoList = new ArrayList<>();
        Odontologo odontologo = null;

        try {
            connection = BD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(lISTAR);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                odontologo = new Odontologo(
                        rs.getString("APELLIDO"),
                        rs.getString("NOMBRE"),
                        rs.getString("MATRICULA"),
                        rs.getInt("ID")
                );

                odontologoList.add(odontologo);

                LOGGER.info("Odontólogo encontrado: ID = " + odontologo.getId() +
                        ", Apellido = " + odontologo.getApellido() +
                        ", Nombre = " + odontologo.getNombre() +
                        ", Matrícula = " + odontologo.getMatricula());
            }

            if (odontologoList.isEmpty()) {
                LOGGER.info("No se encontró ningún odontólogo.");
            } else {
                LOGGER.info("Se listaron " + odontologoList.size() + " odontólogos.");
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

        return odontologoList;
    }

    @Override
    public Odontologo consultarPorId(Integer id) {

        Connection connection = null;
        Odontologo odontologo = null;

        try {
            connection = BD.getConnection();

            PreparedStatement psBuscarPorId = connection.prepareStatement(CONSULTA_POR_ID);
            psBuscarPorId.setInt(1, id);
            ResultSet rs = psBuscarPorId.executeQuery();

            if (rs.next()) {
                odontologo = new Odontologo(rs.getString("APELLIDO"),
                        rs.getString("NOMBRE"),
                        rs.getString("MATRICULA"),
                        rs.getInt("ID"));

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
    public Boolean eliminarPorId(Integer id) {
        Connection connection = null;
        Boolean eliminado = false;

        try {
            connection = BD.getConnection();

            PreparedStatement psEliminarPorId = connection.prepareStatement(BORRAR_POR_ID);
            psEliminarPorId.setInt(1, id);

            int filasBorradas = psEliminarPorId.executeUpdate();

            if (filasBorradas > 0) {
                LOGGER.info("Odontólogo con ID " + id + " eliminado correctamente.");
                eliminado = true;
            } else {
                LOGGER.warn("No se encontró ningún odontólogo con el ID: " + id);
            }

        } catch (Exception e) {
            LOGGER.error("Error al eliminar el odontólogo por ID: " + id, e);
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
    public Odontologo actualizar(Odontologo odontologo) {
        Connection connection = null;
        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(ACTUALIZAR);

            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setString(3, odontologo.getMatricula());
            preparedStatement.setInt(4, odontologo.getId());

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                LOGGER.info("Odontólogo actualizado correctamente: ");
                LOGGER.info("ID: " + odontologo.getId());
                LOGGER.info("Nombre: " + odontologo.getNombre());
                LOGGER.info("Apellido: " + odontologo.getApellido());
                LOGGER.info("Matrícula: " + odontologo.getMatricula());
            } else {
                LOGGER.warn("No se encontró ningún odontólogo con el ID: " + odontologo.getId());
            }

        } catch (Exception e) {
            LOGGER.error("Error al actualizar el odontólogo con ID: " + odontologo.getId(), e);
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



    /*@Override
    public Odontologo actualizar(Odontologo odontologo, String campo, String nuevoValor) {
        Connection connection = null;

        try {
            connection = BD.getConnection();

            String sqlActualizar = "UPDATE ODONTOLOGOS SET " + campo + " = ? WHERE ID = ?";
            PreparedStatement psActualizar = connection.prepareStatement(sqlActualizar);

            psActualizar.setString(1, nuevoValor);
            psActualizar.setInt(2, odontologo.getId());

            int rowsAffected = psActualizar.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("Odontólogo con ID " + odontologo.getId() + " actualizado correctamente. Campo modificado: " + campo + ", Nuevo valor: " + nuevoValor);

                // Actualizar el objeto odontologo con el nuevo valor
                switch (campo) {
                    case "nombre":
                        odontologo.setNombre(nuevoValor);
                        break;
                    case "apellido":
                        odontologo.setApellido(nuevoValor);
                        break;
                    case "matricula":
                        odontologo.setMatricula(nuevoValor);
                        break;
                    default:
                        LOGGER.warn("Campo no reconocido: " + campo);
                }
            } else {
                LOGGER.warn("No se encontró ningún odontólogo con el ID: " + odontologo.getId());
            }

        } catch (Exception e) {
            LOGGER.error("Error al actualizar el odontólogo con ID: " + odontologo.getId(), e);
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
    }*/

}//CIERRE DE LA CLASE