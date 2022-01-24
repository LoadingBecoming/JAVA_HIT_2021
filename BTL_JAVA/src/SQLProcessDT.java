import java.sql.*;
import java.util.Scanner;

public class SQLProcessDT {
    static Scanner sc = new Scanner(System.in);
    static Connection conn = SQLServerConnection.getJDBCConnection();
    static Statement statement;
    static SQLProcessVe PrV = new SQLProcessVe();

    static {
        try{
            statement = conn.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateNL(int VNL, int TienNL) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update DoanhThu set VeNL = ? , TienNL = ?");
        preparedStatement.setInt(1, VNL);
        preparedStatement.setInt(2, TienNL);
        preparedStatement.executeUpdate();
    }

    public static void updateTE(int VTE, int TienTE) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update DoanhThu set VeTE = ? , TienTE = ?");
        preparedStatement.setInt(1, VTE);
        preparedStatement.setInt(2, TienTE);
        preparedStatement.executeUpdate();
    }

    public static void upNL() throws SQLException {
        String sql = "select VeNL, TienNL from DoanhThu";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        updateNL(resultSet.getInt(1) + 1, resultSet.getInt(2) + PrV.getVNL());
    }

    public static void upTE() throws SQLException {
        String sql = "select VeTE, TienTE from DoanhThu";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        updateTE(resultSet.getInt(1) + 1, resultSet.getInt(2) + PrV.getVTE());
    }
}
