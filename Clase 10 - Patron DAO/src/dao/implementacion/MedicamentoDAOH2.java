package dao.implementacion;

import dao.BD;
import dao.IDao;
import modelo.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoDAOH2 implements IDao<Medicamento> {

    private static final Logger LOGGER = Logger.getLogger(MedicamentoDAOH2.class);

    @Override
    public Medicamento guardar(Medicamento medicamento) {
        LOGGER.info("Comenzamos a persistir un medicamento");

        Connection connection = null;

        try {

            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MEDICAMENTOS (" +
                    "NOMBRE, LABORATORIO, CANTIDAD, PRECIO, CODIGO) VALUES (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, medicamento.getNombre());
            preparedStatement.setString(2, medicamento.getLaboratorio());
            preparedStatement.setInt(3, medicamento.getCantidad());
            preparedStatement.setDouble(4, medicamento.getPrecio());
            preparedStatement.setInt(5, medicamento.getCodigo());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            while (rs.next()) {
                medicamento.setId(rs.getInt(1));
                LOGGER.info("Este es el medicamento que se guardó " +
                        medicamento.getNombre());
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

        return medicamento;
    }

    @Override
    public Medicamento buscarPorId(Integer id) {
        LOGGER.info("Comenzamos a buscar un medicamento");

        Connection connection = null;
        Medicamento medicamento=new Medicamento();

        try {

            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MEDICAMENTOS WHERE ID = ?");
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                medicamento.setId(rs.getInt("ID"));
                medicamento.setNombre(rs.getString("NOMBRE"));
                medicamento.setLaboratorio(rs.getString("LABORATORIO"));
                medicamento.setCantidad(rs.getInt("CANTIDAD"));
                medicamento.setPrecio(rs.getDouble("PRECIO"));
                medicamento.setCodigo(rs.getInt("CODIGO"));

                LOGGER.info("Este es el medicamento que se encontró: " + medicamento.getNombre());
            } else {
                LOGGER.info("No se encontró ningún medicamento con el ID: " + id);
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

        return medicamento;
    }

    @Override
    public List<Medicamento> listar() {
        LOGGER.info("Comenzamos a listar los medicamentos");

        Connection connection = null;
        List<Medicamento> listaMedicamentos = new ArrayList<>();

        try {
            connection = BD.getConnection();

            String sqlMedicamentos = "SELECT * FROM MEDICAMENTOS";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlMedicamentos);

            while (rs.next()) {
                Medicamento medicamento = new Medicamento();
                medicamento.setId(rs.getInt("ID"));
                medicamento.setNombre(rs.getString("NOMBRE"));
                medicamento.setLaboratorio(rs.getString("LABORATORIO"));
                medicamento.setCantidad(rs.getInt("CANTIDAD"));
                medicamento.setPrecio(rs.getDouble("PRECIO"));
                medicamento.setCodigo(rs.getInt("CODIGO"));

                listaMedicamentos.add(medicamento);

                LOGGER.info("Medicamento encontrado: ID = " + medicamento.getId() +
                        ", Nombre = " + medicamento.getNombre() +
                        ", Laboratorio = " + medicamento.getLaboratorio() +
                        ", Cantidad = " + medicamento.getCantidad() +
                        ", Precio = " + medicamento.getPrecio() +
                        ", Código = " + medicamento.getCodigo());
            }

            if (listaMedicamentos.isEmpty()) {
                LOGGER.info("No se encontró ningún medicamento.");
            } else {
                LOGGER.info("Se listaron " + listaMedicamentos.size() + " medicamentos.");
            }

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

        return listaMedicamentos;
    }


}
