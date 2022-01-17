import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLProcessQL {
    static Connection conn = SQLServerConnection.getJDBCConnection();
    static Statement statement;

    static {
        try{
            statement = conn.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static int insertQL(int id, String ten, String gioiTinh, String diaChi, String email, String phone, String username, String password){
        String sqlInsert = "insert into QuanLy values ('"+id+"', '"+ten+"', '"+gioiTinh+"', '"+diaChi+"', '"+email+"', '"+phone+"', '"+username+"', '"+password+"')";
        try {
            return statement.executeUpdate(sqlInsert);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int updateQL(int id, String ten, String gioiTinh, String diaChi, String email, String phone, String username, String password){
        String sqlUpdate = "update QuanLy set TenQL = N '"+ten+"', "+" GioiTinh =  N '"+gioiTinh+"', "+" DiaChi = N'"+diaChi+"', "+" Email = '"+email+"', "+" Phone = '"+phone+"', "+" UserName = '"+username+"', "+" Pass = '"+password+"'";
        try{
            return statement.executeUpdate(sqlUpdate);
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public static int deleteQL(int id){
        String sqlDelete = "delete QuanLy where IdQL = '"+id+"'";
        try {
            return statement.executeUpdate(sqlDelete);
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public static void updateQName(int idQ, String tenQ) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update QuanLy set TenQL = ? where IdQL = ?");
        preparedStatement.setString(1, tenQ);
        preparedStatement.setInt(2, idQ);
        int k1 = preparedStatement.executeUpdate();
    }

    public static void updateQGioiTinh(int idQ, String gioiTinh) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update QuanLy set GioiTinh = ? where IdQL = ?");
        preparedStatement.setString(1, gioiTinh);
        preparedStatement.setInt(2, idQ);
        int k1 = preparedStatement.executeUpdate();
    }

    public static void updateQDiaChi(int idQ, String diaChi) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update QuanLy set DiaChi = ? where IdQL = ?");
        preparedStatement.setString(1, diaChi);
        preparedStatement.setInt(2, idQ);
        int k1 = preparedStatement.executeUpdate();
    }

    public static void updateQEmail(int idQ, String email) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update QuanLy set Email = ? where IdQL = ?");
        preparedStatement.setString(1, email);
        preparedStatement.setInt(2, idQ);
        int k1 = preparedStatement.executeUpdate();
    }

    public static void updateQPhone(int idQ, String phone) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update QuanLy set Phone = ? where IdQL = ?");
        preparedStatement.setString(1, phone);
        preparedStatement.setInt(2, idQ);
        int k1 = preparedStatement.executeUpdate();
    }

    public static void updateQUserName(int idQ, String userName) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update QuanLy set Username = ? where IdQL= ?");
        preparedStatement.setString(1, userName);
        preparedStatement.setInt(2, idQ);
        int k1 = preparedStatement.executeUpdate();
    }

    public static void updateQPass(int idQ, String pass) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update QuanLy set Pass = ? where IdQL = ?");
        preparedStatement.setString(1, pass);
        preparedStatement.setInt(2, idQ);
        int k1 = preparedStatement.executeUpdate();
    }

}
