import java.sql.*;
import java.util.*;

public class SQLProcessDV {
    static Scanner sc = new Scanner(System.in);
    static Connection conn = SQLServerConnection.getJDBCConnection();
    static Statement statement;

    static {
        try{
            statement = conn.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static int insertDV(int idP, int idK, String loaiVe, String soGhe){
        String sqlInsert = "insert into DatVe values ('"+idP+"', '"+idK+"', '"+loaiVe+"', '"+soGhe+"')";
        try {
            return statement.executeUpdate(sqlInsert);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int deleteDV(int idP){
        String sqlDelete = "delete DatVe where IdP = '"+idP+"'";
        try {
            return statement.executeUpdate(sqlDelete);
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public static void updateDV(String soGhe, int idP, int idK, String loaiVe) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update DatVe set SoGheDV = ? where IdP = ? and IdK = ? and LoaiVe = ?");
        preparedStatement.setString(1, soGhe);
        preparedStatement.setInt(2, idP);
        preparedStatement.setInt(3, idK);
        preparedStatement.setString(4, loaiVe);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }


    public static List<Integer> mangSoGheDV(int idP, int idK, String loaiVe){
        String sql = "Select SoGheDV from DatVe where IdP = '"+idP+"' and IdK = '"+idK+"' and LoaiVe = N'"+loaiVe+"'";
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

    public static List<Integer> mangSoGheDV(int idP, int idK){
        String sql = "Select SoGheDV from DatVe where IdP = '"+idP+"' and IdK = '"+idK+"'";
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

    public static List<Integer> mangSoGheDV(int idP){
        String sql = "Select SoGheDV from DatVe where IdP = '"+idP+"'";
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

    public static Set<Integer> mangIdPDV(int idK){
        String sql = "Select IdP from DatVe where IdK = '"+idK+"'";
        Set<Integer> mang = new HashSet<>();
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int rs = resultSet.getInt(1);
                mang.add(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mang;
    }

    public static void showGDV(Set<Integer> mang, int idK){
        System.out.println("Bạn đã đặt: ");
        if(mang.size() == 0){
            System.out.println("Bạn chưa đặt ghế!");
            System.out.println();
        } else {
            for(int i:mang){
                System.out.println("Các số ghế giá NGƯỜI LỚN bạn đã đặt tại phim "+ i + " là: " + mangSoGheDV(i, idK, "NL"));
                System.out.println("Các số ghế giá TRẺ EM bạn đã đặt tại phim "+ i + " là: " +mangSoGheDV(i, idK, "TE"));
                System.out.println();
            }
        }
    }

    public static void gheTrongDV(List<Integer> mang, int idP, int idK, String loaiVe){
        if(mang.size() == 0) {
            insertDV(idP, idK, loaiVe,"");
        }
    }

    public static void gheTrongDV(List<Integer> mang){
        if(mang.size() == 0){
            System.out.println("Toàn bộ ghế đều trống. Bạn có thể chọn số ghế bất kì từ 1-20!");
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

    public static boolean checkDatDV(List<Integer>mang, int soG){
        for(int i=0;i< mang.size();i++){
            if(mang.get(i) == soG)
                return false;
        }
        return true;
    }

    public static boolean checkHuyDV(List<Integer>mang, int soG){
        for(int i=0;i< mang.size();i++){
            if(mang.get(i) == soG)
                return true;
        }
        return false;
    }

    public static String themGheDV(int so, int idP, int idK, String loaiVe) {
        String sql = "select SoGheDV from DatVe where IdP = '"+idP+"' and IdK = '"+idK+"' and LoaiVe = N'"+loaiVe+"'";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            String rs = resultSet.getString("SoGheDV").trim();
            if(!rs.trim().equals("") || rs.split("\\|").length > 0){
                return rs + "|" + so;
            }
            return String.valueOf(so);
        } catch (SQLException e){
            e.printStackTrace();
            return "-1";
        }
    }

    public static void huyGheDV(List<Integer>mang, int so, int idP, int idK, String loaiVe) throws SQLException {
        String s = "";
        for(int i=0;i<mang.size();i++){
            if(mang.get(i) != so){
                s+="|";
                s += mang.get(i);
            }
        }
        updateDV(s, idP, idK, loaiVe);
    }

}
