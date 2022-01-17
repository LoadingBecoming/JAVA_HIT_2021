import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Khach {
    static Scanner sc = new Scanner(System.in);
    static Connection conn = SQLServerConnection.getJDBCConnection();
    static Statement statement;
    static SQLProcessKH PrK = new SQLProcessKH();

    static {
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int creIDKH(List<KhachHang> dsKH){
        int id = 0;
        for(int i=0;i<dsKH.size();i++){
            if(dsKH.get(i).getIdK() != i){
                return i;
            }
            id = i;
        }
        return id+1;
    }

    public static List<KhachHang> allDsKH(){
        List<KhachHang> dsKH = new ArrayList<>();
        String sql = "Select * from KhachHang order by IdK";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                KhachHang khachHang = new KhachHang(
                        resultSet.getInt(1),
                        resultSet.getString(2).trim(),
                        resultSet.getString(3).trim(),
                        resultSet.getString(4).trim(),
                        resultSet.getString(5).trim(),
                        resultSet.getString(6).trim(),
                        resultSet.getString(7).trim(),
                        resultSet.getString(8).trim(),
                        resultSet.getInt(9)
                );
                dsKH.add(khachHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsKH;
    }

    public static void showIn4DsKH(List<KhachHang> dsKH){
        for (KhachHang khachHang:dsKH){
            System.out.println(khachHang);
        }
    }

    public static void showIn4OneK(List<KhachHang> dsKH, String name){
        for(int i=0;i<dsKH.size();i++){
            if(dsKH.get(i).getTenK().equals(name))
                System.out.println(dsKH.get(i));
        }
    }

    public static void showIn4Me(List<KhachHang> dsKH, int idk){
        for(int i=0;i<dsKH.size();i++){
            if(dsKH.get(i).getIdK() == idk){
                System.out.println(dsKH.get(i));
            }
        }
    }

    public static void sapXepTheoTen(List<KhachHang> dsKH){
        Collections.sort(dsKH, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                return o1.getTenK().compareTo(o2.getTenK());
            }
        });
        for (KhachHang khachHang:dsKH){
            System.out.println(khachHang.toString());
        }
    }

    public static void sapXepTheoId(List<KhachHang> dsKH){
        Collections.sort( dsKH);
        for(KhachHang khachHang:dsKH)
            System.out.println(khachHang.toString2());
    }

    public static void napTien(int idK) throws SQLException {
        System.out.println("Hãy nhập 1 con số chia hết cho 100: ");
        while (true){
            int x = sc.nextInt();
            if(x % 100 != 0){
                System.out.println("Nhập lại!");
            } else {
                String sql = "select ViTIen from KhachHang where IdK = '"+idK+"' ";
                try{
                    ResultSet resultSet = statement.executeQuery(sql);
                    resultSet.next();
                    x += resultSet.getInt("ViTien");
                    PrK.updateViTien(idK, x);
                    System.out.println("Nạp tiền thành công!");
                    System.out.println("Ví tiền hiện tại của bạn là " + x);
                    System.out.println();
                }catch (SQLException e){
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    public static void truTien(int idK) {
        int x;
        String sql = "select ViTIen from KhachHang where IdK = '"+idK+"' ";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            x = resultSet.getInt("ViTien") - 100;
            PrK.updateViTien(idK, x);
            System.out.println("Ví tiền hiện tại của bạn là " + x);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void themTien(int idK) {
        int x;
        String sql = "select ViTIen from KhachHang where IdK = '"+idK+"' ";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            x = resultSet.getInt("ViTien") + 100;
            PrK.updateViTien(idK, x);
            System.out.println("Ví tiền hiện tại của bạn là " + x);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}


