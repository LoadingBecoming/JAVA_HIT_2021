import java.sql.*;
import java.util.*;

public class SQLProcessGhe {
    static Connection conn = SQLServerConnection.getJDBCConnection();
    static Statement statement;

    static {
        try{
            statement = conn.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static int insertG(String soGhe, int idP){
        int idG = 0;
       String sqlInsert = "insert into Ghe values ('"+soGhe+"', '"+idP+"')";
        try {
            return statement.executeUpdate(sqlInsert);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int deleteG(int idP){
        String sqlDelete = "delete Ghe where IdFilm = '"+idP+"'";
        try {
            return statement.executeUpdate(sqlDelete);
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public static void updateG(String soGhe, int idP) throws SQLException {
        System.out.println(soGhe);
        /*String sqlUpdate = "update Ghe set SoGhe = '"+soGhe+"' where IdFilm = '"+idP+"'";
        try{
            return statement.executeUpdate(sqlUpdate);
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }*/
        PreparedStatement preparedStatement = conn.prepareStatement("update Ghe set SoGhe = ? where IdFilm = ?");
        preparedStatement.setString(1, soGhe);
        preparedStatement.setInt(2, idP);
        int k1 = preparedStatement.executeUpdate();
    }

    public static List<Integer> mangSoGhe(int idP){
        String sql = "Select SoGhe from Ghe where IdFilm = '"+idP+"'";
        List<Integer> mang = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String rs = resultSet.getString(1).trim();
                if(rs.compareTo("") == 0) break;
                String[] s = rs.split("\\|");
                for(int i = 0; i < s.length; i++){
                    if(!s[i].equals("")) { // vì k bỏ đươc
                        mang.add(Integer.parseInt(s[i].trim()));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mang;
    }

    public static void gheTrong(List<Integer> mang, int idP){
        if(mang.size() == 0){
            System.out.println("Toàn bộ ghế đều trống. Bạn có thể chọn số ghế bất kì từ 1-20!");
            insertG("", idP);
        } else {
            System.out.println("Các số ghế còn trống là: ");
            int dem = 0;
            List<Integer> list = new ArrayList<>();
            while (true){
                ++dem;
                boolean check = false;
                for(int i=0;i<mang.size();i++){
                    if(mang.get(i) == dem){
                        check = true;
                        break;
                    }
                }
                if(check){
                    continue;
                } else {
                    list.add(dem);
                }

                if(dem == 20) break;
            }
            for(int x:list){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static String themGhe(int so, int idP) {
        String sql = "select SoGhe from Ghe where IdFilm = '"+idP+"'";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            String rs = resultSet.getString("SoGhe").trim();
            if(!rs.trim().equals("") || rs.split("\\|").length > 0){
                return rs + "|" + so;
            }
            return String.valueOf(so);
        } catch (SQLException e){
            e.printStackTrace();
            return "-1";
        }

    }

    public static void huyGhe(List<Integer>mang, int so, int idP) throws SQLException {
        String s = "";
        for(int i=0;i<mang.size();i++){
            if(mang.get(i) != so){
                s+="|";
                s += mang.get(i);
            }
        }
        updateG(s, idP);
    }


}
