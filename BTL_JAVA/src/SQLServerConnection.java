import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
    public static Connection getJDBCConnection(){
        //Connection
        //DriverManager
        //Statement
        //PreparedStatement
        //ResultSet

        final String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyRapPhim;user=sa;password=123";

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
}
