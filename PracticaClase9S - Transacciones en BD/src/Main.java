import java.sql.*;

public class Main {

    private static final String DROP_CREATE = "DROP TABLE IF EXISTS ODONTOLOGOS; CREATE " +
            "TABLE ODONTOLOGOS (" +
            "ID INT PRIMARY KEY," +
            "APELLIDO VARCHAR(30) NOT NULL," +
            "NOMBRE VARCHAR(30) NOT NULL," +
            "MATRICULA VARCHAR(50) NOT NULL)";

    private static final String SLQ_INSERT = "INSERT INTO ODONTOLOGOS VALUES (?,?,?,?)";

    private static final String SELECT_ALL = "SELECT * FROM ODONTOLOGOS";

    private static final String SQL_UPDATE = "UPDATE ODONTOLOGOS SET MATRICULA=? WHERE ID=?";

    public static void main(String[] args) {
        Odontologo odontologo1 = new Odontologo("Garcia", "Juan", "123456", 1);
        Connection connection = null;

        try {

            connection = getConnection();

            Statement statement = connection.createStatement();
            statement.execute(DROP_CREATE);

            PreparedStatement preparedStatement = connection.prepareStatement(SLQ_INSERT);
            preparedStatement.setInt(1,odontologo1.getId());
            preparedStatement.setString(2, odontologo1.getApellido());
            preparedStatement.setString(3, odontologo1.getNombre());
            preparedStatement.setString(4, odontologo1.getMatricula());

            preparedStatement.execute();

            ResultSet rs = statement.executeQuery(SELECT_ALL);

            while (rs.next()) {
                System.out.println("El odontologo con id: " +
                        rs.getInt(1) + ", apellido " +
                        rs.getString(2) + ", nombre " +
                        rs.getString(3) + " y matricula " +
                        rs.getString(4));
            }

            //VAMOS A HACER LA TRANSACCION
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement1 = connection.prepareStatement(SQL_UPDATE);
            preparedStatement1.setString(1,"78901");
            preparedStatement1.setInt(2,1);

            preparedStatement1.execute();

            int excepcionForzada = 4/0;

            connection.setAutoCommit(true);

            ResultSet rs1 = statement.executeQuery(SELECT_ALL);

            System.out.println("Esta es la matricula luego de la transacción: ");

            while (rs1.next()) {
                System.out.println("El odontologo con id: " +
                        rs1.getInt(1) + ", apellido " +
                        rs1.getString(2) + ", nombre " +
                        rs1.getString(3) + " y matricula " +
                        rs1.getString(4));
            }

        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }

        //VOLVER A CONECTARNOS A LA BD PARA CONSULTAR SI LA MATRICULA EFECTIVAMETE NO CAMBIO
        try {
            connection = getConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SELECT_ALL);

            System.out.println("Este es el saldo luego de la transacción");

            System.out.println("Esta es la matricula luego de la transacción: ");

            while (resultSet.next()) {
                System.out.println("El odontologo con id: " +
                        resultSet.getInt(1) + ", apellido " +
                        resultSet.getString(2) + ", nombre " +
                        resultSet.getString(3) + " y matricula " +
                        resultSet.getString(4));
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.getMessage();
            }
        }

    }


    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./backend1", "sa", "sa");
    }
}
