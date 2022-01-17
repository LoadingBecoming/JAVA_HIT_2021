import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class QuanLy {
    static Connection conn = SQLServerConnection.getJDBCConnection();
    static Statement statement;

    static {
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int creID(List<Nguoi> dsQL){
        int id = 0;
        while(true){
            ++id;
            for(int i=0;i<dsQL.size();i++){
                if(dsQL.get(i).getId() == id)
                    continue;
            }
            return id;
        }
    }

   public static List<Nguoi> allDsQL(){
       List<Nguoi> dsQL = new ArrayList<>();
        String sql = "Select * from QuanLy";
       try {
           ResultSet resultSet = statement.executeQuery(sql);
           while (resultSet.next()){
               Nguoi nguoi = new Nguoi(
                       resultSet.getInt(1),
                       resultSet.getString(2).trim(),
                       resultSet.getString(3).trim(),
                       resultSet.getString(4).trim(),
                       resultSet.getString(5).trim(),
                       resultSet.getString(6).trim(),
                       resultSet.getString(7).trim(),
                       resultSet.getString(8).trim()
               );
               dsQL.add(nguoi);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
        return dsQL;
   }

   public static void showIn4DsQl(List<Nguoi> dsQL){
       for (Nguoi N:dsQL){
           System.out.println(N.toString2());
       }
   }

   public static void showIn4One(List<Nguoi> dsQL, String name){
        for(int i=0;i<dsQL.size();i++){
            if(dsQL.get(i).getTen().equals(name))
                System.out.println(dsQL.get(i));
        }
   }

    public static void showIn4Me(List<Nguoi> dsQL, int idQ){
        for(int i=0;i<dsQL.size();i++){
            if(dsQL.get(i).getId() == idQ)
                System.out.println(dsQL.get(i));
        }
    }

    public static void sapXepTheoTen(List<Nguoi> dsQL){
        Collections.sort(dsQL, new Comparator<Nguoi>() {
            @Override
            public int compare(Nguoi o1, Nguoi o2) {
                return o1.getTen().compareTo(o2.getTen());
            }
        });
        for (Nguoi nguoi:dsQL){
            System.out.println(nguoi);
        }
    }

    public static void sapXepTheoId(List<Nguoi> dsQL){
        Collections.sort( dsQL);
        for(Nguoi nguoi:dsQL)
            System.out.println(nguoi);
    }

}
