import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLProcessLS {
    static Connection conn = SQLServerConnection.getJDBCConnection();
    static Statement statement;

    static {
        try{
            statement = conn.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static int insertLS(int idK, String Ls, String thoiGian){
        String sqlInsert = "insert into lichSu values ('"+idK+"', '"+Ls+"', '"+thoiGian+"')";
        try {
            return statement.executeUpdate(sqlInsert);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static List<lichSu> showLS(int idK){
        List<lichSu> dsLS = new ArrayList<>();
        String sql = "Select * from LichSu where IdK = '"+idK+"'";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                lichSu lichSu = new lichSu(
                        resultSet.getInt(1),
                        resultSet.getString(2).trim(),
                        resultSet.getString(3).trim()
                );
                dsLS.add(lichSu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsLS;
    }
}
