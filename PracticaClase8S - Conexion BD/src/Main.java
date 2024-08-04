import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception{

        Figura figura1 = new Figura("circulo", "rojo");
        Figura figura2 = new Figura("circulo", "azul");
        Figura figura3 = new Figura("cuadrado", "rosa");
        Figura figura4 = new Figura("cuadrado", "morado");
        Figura figura5 = new Figura("cuadrado", "blanco");

        Class.forName("org.h2.Driver").newInstance();
        Connection connection = DriverManager.getConnection("jdbc:h2:./Backend1", "sa", "sa");
        Statement statement = connection.createStatement();

        String createTable = "DROP TABLE IF EXISTS FIGURA; CREATE TABLE FIGURA(ID INT PRIMARY KEY, TIPOFIGURA VARCHAR(30) NOT NULL, COLOR VARCHAR(30) NOT NULL)";
        statement.execute(createTable);

        String insertarFila1 = "INSERT INTO FIGURA VALUES(" + figura1.getId() + ", '" + figura1.getTipoFigura() + "', '" + figura1.getColor() + "')";
        statement.execute(insertarFila1);

        String insertarFila2 = "INSERT INTO FIGURA VALUES(" + figura2.getId() + ", '" + figura2.getTipoFigura() + "', '" + figura2.getColor() + "')";
        statement.execute(insertarFila2);

        String insertarFila3 = "INSERT INTO FIGURA VALUES(" + figura3.getId() + ", '" + figura3.getTipoFigura() + "', '" + figura3.getColor() + "')";
        statement.execute(insertarFila3);

        String insertarFila4 = "INSERT INTO FIGURA VALUES(" + figura4.getId() + ", '" + figura4.getTipoFigura() + "', '" + figura4.getColor() + "')";
        statement.execute(insertarFila4);

        String insertarFila5 = "INSERT INTO FIGURA VALUES(" + figura5.getId() + ", '" + figura5.getTipoFigura() + "', '" + figura5.getColor() + "')";
        statement.execute(insertarFila5);

        // Consulta para seleccionar círculos rojos
        String sqlCirculosRojos = "SELECT * FROM FIGURA WHERE TIPOFIGURA = 'circulo' AND COLOR = 'rojo'";
        ResultSet rsCirculosRojos = statement.executeQuery(sqlCirculosRojos);
        System.out.println("\n");
        while (rsCirculosRojos.next()){
            System.out.println("Círculo Rojo: " + rsCirculosRojos.getInt("ID") + ", " + rsCirculosRojos.getString("TIPOFIGURA") + ", " + rsCirculosRojos.getString("COLOR"));
        }

        String sql = "SELECT * FROM FIGURA";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3));
        }

        rs.close();
        statement.close();
        connection.close();
    }
}
