import java.sql.*;
import java.util.*;


public class QuanLy {
    static Connection conn = SQLServerConnection.getJDBCConnection();
    static Statement statement;
    static Scanner sc = new Scanner(System.in);
    static SQLProcessGT PrGT = new SQLProcessGT();

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

    public static List<Nguoi> searchDsQL(String word){
        List<Nguoi> dsQL = new ArrayList<>();
        String sql = "Select * from QuanLy where TenQL like CONCAT(N'%',?,'%')";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,word);
            ResultSet resultSet = preparedStatement.executeQuery();
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

    public static void changeGT() throws SQLException {
        int stop = 1;
        while (stop == 1){
            System.out.println("|```````````````````````````````|");
            System.out.println("|                            (2.1)|");
            System.out.println("| 1.Mốc quay thưởng!            |");
            System.out.println("| 2.Giải thưởng!                |");
            System.out.println("| 3.Exit!                       |");
            System.out.println("|_______________________________|");
            System.out.print("Nhập lựa chọn: ");
            int x = sc.nextInt();
            switch (x){
                case 1:
                    System.out.println("Mốc thưởng hiện tại là: " + PrGT.getDK());
                    PrGT.changeDK();
                    System.out.println("Mốc thưởng hiện tại là: " + PrGT.getDK());
                    break;
                case 2:
                    PrGT.updateGiaiThuong();
                    break;
                case 3:
                    stop = 0;
            }
        }
    }

    public static void showIn4DsQl(List<Nguoi> dsQL){
       for (Nguoi N:dsQL){
           System.out.println(N.toString2());
       }
   }

   public static void showIn4One(List<Nguoi> dsQL){
       System.out.printf("%-15s %-25s %-20s %-20s %-25s %-15s %-15s %s \n","Id", "Tên", "Giới tính", "Địa chỉ", "Email", "Phone", "Username", "Password");
        for(int i=0;i<dsQL.size();i++){
            dsQL.get(i).showMe2();
        }
   }

    public static void showIn4Me(List<Nguoi> dsQL, int idQ){
        System.out.printf("%-15s %-25s %-20s %-20s %-25s %-15s %-15s %s \n","Id", "Tên", "Giới tính", "Địa chỉ", "Email", "Phone", "Username", "Password");
        for(int i=0;i<dsQL.size();i++){
            if(dsQL.get(i).getId() == idQ)
                dsQL.get(i).showMe();
        }
    }

    public static void sapXepTheoTen(List<Nguoi> dsQL){
        Collections.sort(dsQL, new Comparator<Nguoi>() {
            @Override
            public int compare(Nguoi o1, Nguoi o2) {
                return o1.getTen().compareTo(o2.getTen());
            }
        });
        System.out.printf("%-15s %-25s %-20s %-20s %-25s %-15s \n","Id", "Tên", "Giới tính", "Địa chỉ", "Email", "Phone");
        for (Nguoi nguoi:dsQL){
            nguoi.showMe2();
        }
    }

    public static void sapXepTheoId(List<Nguoi> dsQL){
        System.out.printf("%-15s %-25s %-20s %-20s %-25s %-15s \n","Id", "Tên", "Giới tính", "Địa chỉ", "Email", "Phone");
        Collections.sort( dsQL);
        for(Nguoi nguoi:dsQL)
            nguoi.showMe2();
    }

}
