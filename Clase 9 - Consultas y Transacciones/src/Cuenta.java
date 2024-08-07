import java.sql.*;

public class Cuenta {

    private static final String DROP_CREATE = "DROP TABLE IF EXISTS CUENTAS; CREATE " +
            "TABLE CUENTAS (" +
            "ID INT PRIMARY KEY," +
            "NUMERO_CUENTA INT NOT NULL," +
            "TITULAR VARCHAR(100) NOT NULL," +
            "SALDO NUMERIC(10,2) NOT NULL)";

    private static final String SLQ_INSERT = "INSERT INTO CUENTAS VALUES (?,?,?,?)";

    private static final String SELECT_ALL = "SELECT * FROM CUENTAS";

    private static final String SQL_UPDATE = "UPDATE CUENTAS SET SALDO=? WHERE ID=?";



    public static void main(String[] args) {
        //Conectarnos a la BD
        Connection connection = null;

        try {

            //NOS CONECTAMOS A LA BD
            connection = getConnection();

            //CREAR LA TABLA
            Statement statement = connection.createStatement();
            statement.execute(DROP_CREATE);

            //INSERTAR VALORES -> DE FORMA DINÁMICA -> PREPARED STATEMENT
            PreparedStatement preparedStatement = connection.prepareStatement(SLQ_INSERT);
            preparedStatement.setInt(1,1);
            preparedStatement.setInt(2, 546489864);
            preparedStatement.setString(3, "Vanina");
            preparedStatement.setDouble(4, 254766.46);

            preparedStatement.execute();

            //GUARDAMOS LOS DATOS DE LA BD EN JAVA
            ResultSet rs = statement.executeQuery(SELECT_ALL);

            //LO CONSULTAMOS
            while (rs.next()) {
                System.out.println("La cuenta con id: " +
                        rs.getInt(1) + " y número de cuenta " +
                        rs.getInt(2) + " y titular " +
                        rs.getString(3) + " tiene como saldo " +
                        rs.getDouble(4));
            }

            //----------------------------------------------------------------------------------------------------
            //VAMOS A HACER UNA TRANSACCIÓN
            connection.setAutoCommit(false);

            //VOLVEMOS A HACER UNA OPERACIÓN DINAMICA CON PS
            PreparedStatement preparedStatement1 = connection.prepareStatement(SQL_UPDATE);
            preparedStatement1.setDouble(1,10d);
            preparedStatement1.setInt(2,1);

            preparedStatement1.execute();

            //----------------------------------------------------------------------------------------------------
            //FORZAR A QUE OCURRA UNA EXCEPCIÓN
            int excepcionForzada = 4/0;
            //----------------------------------------------------------------------------------------------------

            //UNA BUENA PRÁCTICA
            connection.setAutoCommit(true);

            //GUARDARMOS EN JAVA LOS DATOS DE LA BD
            ResultSet rs1 = statement.executeQuery(SELECT_ALL);

            System.out.println("Este es el saldo luego de la transacción");

            while (rs1.next()) {
                System.out.println("La cuenta con id: " +
                        rs1.getInt(1) + " y número de cuenta " +
                        rs1.getInt(2) + " y titular " +
                        rs1.getString(3) + " tiene como saldo " +
                        rs1.getDouble(4));
            }



        } catch (Exception e) {
            try {
                //SE ARROJA LA EXCEPCIÓN Y SE EJECUTA EL ROLLBACK
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

        //----------------------------------------------------------------------------------------------------
        //VOLVER A CONECTARNOS A LA BD PARA CONSULTAR SI EL SALDO EFECTIVAMETE NO CAMBIO
        try {
            connection = getConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SELECT_ALL);

            System.out.println("Este es el saldo luego de la transacción");

            while (resultSet.next()) {
                System.out.println("La cuenta con id: " +
                        resultSet.getInt(1) + " y número de cuenta " +
                        resultSet.getInt(2) + " y titular " +
                        resultSet.getString(3) + " tiene como saldo " +
                        resultSet.getDouble(4));
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


    //método para conectarnos a la BD
    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./202407", "sa", "sa");
    }

}
