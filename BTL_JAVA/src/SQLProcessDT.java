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

    public static void showDT() throws SQLException {
        String sql = "select VeNL from DoanhThu";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        int a = resultSet.getInt(1);                                // Do mỗi khi thực hiện xong câu lệnh sql nó sẽ đóng lại
        String sql2 = "select VeTE from DoanhThu";                             // và không sử dụng được cho phía sau nên phải gán lại để dùng
        ResultSet resultSet2 = statement.executeQuery(sql2);
        resultSet2.next();
        int b = resultSet2.getInt(1);
        String sql3 = "select TienNL from DoanhThu";
        ResultSet resultSet3 = statement.executeQuery(sql3);
        resultSet3.next();
        int c = resultSet3.getInt(1);
        String sql4 = "select TienTE from DoanhThu";
        ResultSet resultSet4 = statement.executeQuery(sql4);
        resultSet4.next();
        int d = resultSet4.getInt(1);
        System.out.println("Số vé người lớn và trẻ em bán được lần lượt là: " + a + " " + b);
        System.out.println("Tổng số vé bán được là: " + (a + b));
        System.out.println("Số tiền thu được bán vé người lớn và trẻ em lần lượt là: " + c + " " + d);
        System.out.println("Tổng số tiền vé thu được là: " +(c + d));
    }
}
