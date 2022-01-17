import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SQLProcessFilm {
    static Connection conn = SQLServerConnection.getJDBCConnection();
    static Statement statement;

    static {
        try{
            statement = conn.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static int creIDP(List<Phim> dsP){
        int id = 0;
        for(int i=0;i<dsP.size();i++){
            if(dsP.get(i).getIdP() != i){
                return i;
            }
            id = i;
        }
        return id+1;
    }

    public static int insertP(int idP, String tenP, String thoiLuong, String theLoai, String moTa){
        String sqlInsert = "insert into Phim values ('"+idP+"', '"+tenP+"', '"+thoiLuong+"', '"+theLoai+"', '"+moTa+"')";
        try {
            return statement.executeUpdate(sqlInsert);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int deleteP(int idP){
        String sqlDelete = "delete Phim where IdFilm = '"+idP+"'";
        try {
            return statement.executeUpdate(sqlDelete);
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

}
