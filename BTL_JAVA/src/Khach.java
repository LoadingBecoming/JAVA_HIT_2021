import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Khach {
    static Scanner sc = new Scanner(System.in);
    static Connection conn = SQLServerConnection.getJDBCConnection();
    static Statement statement;
    static SQLProcessKH PrK = new SQLProcessKH();
    static SQLProcessLS PrL = new SQLProcessLS();
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static Date date;
    static SQLProcessGT PrGT = new SQLProcessGT();

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

    public static List<KhachHang> showOneKH(String name){
        List<KhachHang> dsKH = new ArrayList<>();
        String sql = "Select * from KhachHang where TenK like CONCAT(N'%',?,'%')";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
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

    public static void showIn4OneK(List<KhachHang> dsKH){
        System.out.printf("%-10s %-20s %-15s %-15s %-20s %-15s %s \n","Id", "Tên", "Giới tính", "Địa chỉ",
                "Email", "Phone", "Ví tiền");
        for(int i=0;i<dsKH.size();i++){
            dsKH.get(i).showMeK2();
        }
    }

    public static void showIn4Me(List<KhachHang> dsKH, int idk){
        for(int i=0;i<dsKH.size();i++){
            if(dsKH.get(i).getIdK() == idk){
                dsKH.get(i).showMeK();
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
        System.out.printf("%-10s %-20s %-15s %-15s %-20s %-15s %s \n","Id", "Tên", "Giới tính", "Địa chỉ",
                "Email", "Phone", "Ví tiền");
        for (KhachHang khachHang:dsKH){
            khachHang.showMeK2();
        }
    }

    public static void sapXepTheoId(List<KhachHang> dsKH){
        System.out.printf("%-10s %-20s %-15s %-15s %-20s %-15s %s \n","Id", "Tên", "Giới tính", "Địa chỉ",
                "Email", "Phone", "Ví tiền");
        Collections.sort( dsKH);
        for(KhachHang khachHang:dsKH)
            khachHang.showMeK2();
    }

    public static void napTien(int idK) throws SQLException {
        System.out.println("*Nạp tích lũy " + PrGT.getDK() + " để mở chức năng ẩn!");
        System.out.println("Hãy nhập 1 con số để nạp: ");
        int x = sc.nextInt();
        String sql = "select ViTIen from KhachHang where IdK = '"+idK+"' ";
        try{
            PrGT.updateNapGT(idK, x);
            String np = "Bạn đã nạp ";
            np+=x;
            date = new Date();
            PrL.insertLS(idK, np, simpleDateFormat.format(date));
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            x += resultSet.getInt("ViTien");
            PrK.updateViTien(idK, x);

            System.out.println("Nạp tiền thành công!");
            System.out.println("Ví tiền hiện tại của bạn là " + x);
            if(PrGT.lanQuay(idK, PrGT.getDK()) > 0){
                System.out.println("*Bạn đã đủ điều kiện mở chức năng ẩn!");
            }
            System.out.println();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void truTien(int idK, int x) {
        String sql = "select ViTIen from KhachHang where IdK = '"+idK+"' ";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            x = resultSet.getInt("ViTien") - x;
            PrK.updateViTien(idK, x);
            System.out.println("Ví tiền hiện tại của bạn là " + x);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void themTien(int idK, int x) {
        String sql = "select ViTIen from KhachHang where IdK = '"+idK+"' ";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            x = resultSet.getInt("ViTien") + x;
            PrK.updateViTien(idK, x);
            System.out.println("Ví tiền hiện tại của bạn là " + x);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static int checkViTien(int idK){
        int x;
        String sql = "select ViTIen from KhachHang where IdK = '"+idK+"' ";
        try{
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            x = resultSet.getInt("ViTien");
            return x;
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

}


