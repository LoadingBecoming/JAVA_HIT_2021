import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLProcessKH {
    static Connection conn = SQLServerConnection.getJDBCConnection();
    static Statement statement;

    static {
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int insertKH(int idK, String tenK, String gioiTinhK, String diaChiK, String emailK, String phoneK,
                                        String usernameK, String passwordK, int viTien) {
        String sqlInsert = "insert into KhachHang values ('" + idK + "', N'" + tenK + "', N'" + gioiTinhK + "', N'" +
                diaChiK + "', '" + emailK + "', '" + phoneK + "', '" + usernameK + "', '" + passwordK + "', '" + viTien + "')";
        try {
            return statement.executeUpdate(sqlInsert);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }



    public static void updateKH(int idK, String tenK, String gioiTinhK, String diaChiK, String emailK, String phoneK, String usernameK, String passwordK, int viTien) throws SQLException {
        /*String sqlUpdate = "update KhachHang set IdK = '"+ idK + "', " + " TenK = N '" + tenK + "', " + " GioiTinhK =  N '" + gioiTinhK + "', " + " DiaChiK = N'" + diaChiK + "', " + " EmailK = '" + emailK + "', " + " PhoneK = '" + phoneK + "', " + " UserNameK = '" + usernameK + "', " + " PassK = '" + passwordK + "', " + " ViTien = '" + viTien +"'";
        try {
            return statement.executeUpdate(sqlUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }*/

        PreparedStatement preparedStatement1 = conn.prepareStatement("update KhachHang set IdK = ?, TenK = ?, GioiTinhK = ?, " +
                "DiaChiK = ?, EmailK = ?, PhoneK = ?, UserNameK = ?, PassK = ?, ViTien = ? where IdK = ? ");
        preparedStatement1.setInt(1, idK);
        preparedStatement1.setString(2, tenK);
        preparedStatement1.setString(3, gioiTinhK);
        preparedStatement1.setString(4, diaChiK);
        preparedStatement1.setString(5, emailK);
        preparedStatement1.setString(6, phoneK);
        preparedStatement1.setString(7, usernameK);
        preparedStatement1.setString(8, passwordK);
        preparedStatement1.setInt(9, viTien);
        preparedStatement1.setInt(10, idK);
        int k1 = preparedStatement1.executeUpdate();
    }

    public static void updateKName(int idK, String tenK) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update KhachHang set TenK = ? where IdK = ?");
        preparedStatement.setString(1, tenK);
        preparedStatement.setInt(2, idK);
        int k1 = preparedStatement.executeUpdate();
    }

    public static void updateKGioiTinh(int idK, String gioiTinhK) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update KhachHang set GioiTinhK = ? where IdK = ?");
        preparedStatement.setString(1, gioiTinhK);
        preparedStatement.setInt(2, idK);
        int k1 = preparedStatement.executeUpdate();
    }

    public static void updateKDiaChi(int idK, String diaChiK) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update KhachHang set DiaChiK = ? where IdK = ?");
        preparedStatement.setString(1, diaChiK);
        preparedStatement.setInt(2, idK);
        int k1 = preparedStatement.executeUpdate();
    }

    public static void updateKEmail(int idK, String emailK) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update KhachHang set EmailK = = ? where IdK = ?");
        preparedStatement.setString(1, emailK);
        preparedStatement.setInt(2, idK);
        int k1 = preparedStatement.executeUpdate();
    }

    public static void updateKPhone(int idK, String phoneK) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update KhachHang set PhoneK = ? where IdK = ?");
        preparedStatement.setString(1, phoneK);
        preparedStatement.setInt(2, idK);
        int k1 = preparedStatement.executeUpdate();
    }

    public static void updateKUserName(int idK, String userNameK) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update KhachHang set UserNameK = ? where IdK = ?");
        preparedStatement.setString(1, userNameK);
        preparedStatement.setInt(2, idK);
        int k1 = preparedStatement.executeUpdate();
    }

    public static void updateKPass(int idK, String passK) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update KhachHang set PassK = ? where IdK = ?");
        preparedStatement.setString(1, passK);
        preparedStatement.setInt(2, idK);
        int k1 = preparedStatement.executeUpdate();
    }

    public static void updateViTien(int idK, int tien) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update KhachHang set ViTien = ? where IdK = ?");
        preparedStatement.setInt(1, tien);
        preparedStatement.setInt(2, idK);
        int k1 = preparedStatement.executeUpdate();
    }
}