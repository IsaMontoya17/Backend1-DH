package dao.impl;

import dao.BD;
import dao.IDAO;
import modelo.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionDaoH2 implements IDAO<Paciente> {
    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection = null;

        try {

            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO PACIENTES (" +
                            "NOMBRE, APELLIDO, DOMICILIO, DNI, FECHA_ALTA) VALUES " +
                            "(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS
            );

            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getDomicilio());
            preparedStatement.setString(4, paciente.getDni());
            preparedStatement.setDate(5, Date.valueOf(paciente.getFechaAlta()));

            preparedStatement.execute();

            //guardé el paciente y se generó el id

            ResultSet rs = preparedStatement.getGeneratedKeys();


            while (rs.next()) {
                paciente.setId(rs.getInt(1));
                System.out.println("Se guardó el paciente con nombre " +
                        paciente.getNombre());
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public List<Paciente> listarTodos() {
        Connection connection = null;

        List<Paciente> pacienteList = new ArrayList<>();
        Paciente paciente = null;

        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM PACIENTES"
            );

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                paciente = new Paciente(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getDate(6).toLocalDate());

                pacienteList.add(paciente);

                System.out.println(paciente.toString());
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return pacienteList;
    }

    @Override
    public Paciente consultarPorId(Integer id) {
        Connection connection = null;

        try {





        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void eliminarPorId(Integer id) {
        Connection connection = null;

        try {





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

    @Override
    public Paciente actualizar(Paciente paciente) {
        Connection connection = null;

        try {
            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE PACIENTES SET NOMBRE=?, APELLIDO=?, DOMICILIO=?," +
                            "DNI=?, FECHA_ALTA=? WHERE ID=?"
            );

            preparedStatement.setString(1,paciente.getNombre());
            preparedStatement.setString(2,paciente.getApellido());
            preparedStatement.setString(3, paciente.getDomicilio());
            preparedStatement.setString(4, paciente.getDni());
            preparedStatement.setDate(5, Date.valueOf(paciente.getFechaAlta()));
            preparedStatement.setInt(6, paciente.getId());

            preparedStatement.execute();

            System.out.println("Este es el nuevo nombre del paciente" + paciente.getNombre());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return paciente;
    }
}
