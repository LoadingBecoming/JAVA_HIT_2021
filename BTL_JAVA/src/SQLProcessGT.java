import java.sql.*;
import java.util.Scanner;

public class SQLProcessGT {
    static Scanner sc = new Scanner(System.in);
    static Connection conn = SQLServerConnection.getJDBCConnection();
    static Statement statement;
    static Khach K = new Khach();

    static {
        try{
            statement = conn.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void insertCheckGT(int idK, int Tien) throws SQLException {
        String sqlInsert = "insert into CheckGT (IdK, Tien) values (?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert);
        preparedStatement.setInt(1,idK);
        preparedStatement.setInt(2,Tien);
        preparedStatement.executeUpdate();
    }

    public static void updateCheckGT(int idK, int Tien) throws SQLException {
        String sql = "update CheckGT set Tien = ? where IdK = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,Tien);
        preparedStatement.setInt(2, idK);
        preparedStatement.executeUpdate();
    }

    public static void updateNapGT(int idK, int nap) throws SQLException {
        String sql = "select Tien from CheckGT where IdK = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,idK);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int rs = resultSet.getInt(1);
        rs += nap;
        updateCheckGT(idK, rs);
    }

    public static int lanQuay(int idK, int dk) throws SQLException {
        String sql = "select Tien from CheckGT where IdK = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,idK);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int rs = resultSet.getInt(1);
        int x = rs/dk;
        return x;
    }

    public static void setLanQuay(int idK, int dk) throws SQLException {
        String sql = "select Tien from CheckGT where IdK = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,idK);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int rs = resultSet.getInt(1);
        int tien = rs%dk;
        updateCheckGT(idK, tien);
    }

    public static void changeDK() throws SQLException {
        System.out.print("Nhập mốc tiền quay thưởng: ");
        int x = sc.nextInt();
        String sql = "update DK set Dk = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, x);
        preparedStatement.executeUpdate();
        System.out.println("Cập nhật thành công!");
    }

    public static int getDK() throws SQLException {
        String sql = "select Dk from DK";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int rs = resultSet.getInt(1);
        return rs;
    }

    public static void updateGiaiThuong() throws SQLException {
        int stop = 1;
        while (stop == 1){
            System.out.println("1.GT1 !");
            System.out.println("2.GT2 !");
            System.out.println("3.GT3 !");
            System.out.println("4.GT4 !");
            System.out.println("5.GT5 !");
            System.out.println("6.Exit!");
            System.out.print("Nhập lựa chọn: ");
            int x = sc.nextInt();
            switch (x){
                case 1:
                    System.out.println("GT1 hiện tại: " + GT1());
                    System.out.print("Nhập giá trị GT1: ");
                    int a = sc.nextInt();
                    String sql = "update GiaiThuong set GT1 = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setInt(1,a);
                    preparedStatement.executeUpdate();
                    System.out.println("Cập nhật thành công!");
                    System.out.println("GT1 hiện tại: " + GT1());
                    System.out.println();
                    break;
                case 2:
                    System.out.println("GT2 hiện tại: " + GT2());
                    System.out.print("Nhập giá trị GT2: ");
                    int b = sc.nextInt();
                    String sql2 = "update GiaiThuong set GT2 = ?";
                    PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
                    preparedStatement2.setInt(1,b);
                    preparedStatement2.executeUpdate();
                    System.out.println("Cập nhật thành công!");
                    System.out.println("GT2 hiện tại: " + GT2());
                    System.out.println();
                    break;
                case 3:
                    System.out.println("GT3 hiện tại: " + GT3());
                    System.out.print("Nhập giá trị GT3: ");
                    int c = sc.nextInt();
                    String sql3 = "update GiaiThuong set GT3 = ?";
                    PreparedStatement preparedStatement3 = conn.prepareStatement(sql3);
                    preparedStatement3.setInt(1,c);
                    preparedStatement3.executeUpdate();
                    System.out.println("Cập nhật thành công!");
                    System.out.println("GT3 hiện tại: " + GT3());
                    System.out.println();
                    break;
                case 4:
                    System.out.println("GT4 hiện tại: " + GT4());
                    System.out.print("Nhập giá trị GT4: ");
                    int d = sc.nextInt();
                    String sql4 = "update GiaiThuong set GT4 = ?";
                    PreparedStatement preparedStatement4 = conn.prepareStatement(sql4);
                    preparedStatement4.setInt(1,d);
                    preparedStatement4.executeUpdate();
                    System.out.println("Cập nhật thành công!");
                    System.out.println("GT4 hiện tại: " + GT4());
                    System.out.println();
                    break;
                case 5:
                    System.out.println("GT5 hiện tại: " + GT5());
                    System.out.print("Nhập giá trị GT5: ");
                    int e = sc.nextInt();
                    String sql5 = "update GiaiThuong set GT5 = ?";
                    PreparedStatement preparedStatement5 = conn.prepareStatement(sql5);
                    preparedStatement5.setInt(1,e);
                    preparedStatement5.executeUpdate();
                    System.out.println("Cập nhật thành công!");
                    System.out.println("GT5 hiện tại: " + GT5());
                    System.out.println();
                    break;
                case 6:
                    stop = 0;
            }
        }
    }

    public static int Rand(){
        double x = Math.random();
        x = x * 5 + 1;
        int randomX = (int) x;
        return randomX;
    }

    public static int GT1() throws SQLException {
        String sql = "select GT1 from GiaiThuong";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    public static int GT2() throws SQLException {
        String sql = "select GT2 from GiaiThuong";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    public static int GT3() throws SQLException {
        String sql = "select GT3 from GiaiThuong";
        PreparedStatement preparedStatement3 = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement3.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    public static int GT4() throws SQLException {
        String sql = "select GT4 from GiaiThuong";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    public static int GT5() throws SQLException {
        String sql = "select GT5 from GiaiThuong";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    public static void quayThuong(int idK, int dk) throws SQLException, InterruptedException {
        System.out.println("Các mức giải thưởng bạn có thể nhận: ");
        System.out.println("1.GT1 trị giá " + GT1());
        System.out.println("2.GT2 trị giá " + GT2());
        System.out.println("3.GT3 trị giá " + GT3());
        System.out.println("4.GT4 trị giá " + GT4());
        System.out.println("5.GT5 trị giá " + GT5());
        System.out.println();
        int l = lanQuay(idK, dk);
        System.out.println("Bạn đang có " + l + "lần quay!");
        System.out.print("Nhấn 1 để xác nhận quay: ");
        int x = sc.nextInt();
        if(x == 1){
            while(l>0){
                Thread.sleep(3000);
                System.out.println("Và...");
                Thread.sleep(2000);
                System.out.println("Chúc mừng bạn nhận được giải thưởng ...");
                Thread.sleep(3000);
                System.out.println("Loading...");
                Thread.sleep(4000);

                int r = Rand();
                System.out.println(" ___ ");
                System.out.println("| " + r + " |");
                System.out.println(" ``` ");
                if(r == 1){
                    System.out.println("Vâng! Chúc mừng bạn nhận được giải thưởng trị giá " + GT1());
                    K.themTien(idK, GT1());
                }else if(r == 2){
                    System.out.println("Vâng! Chúc mừng bạn nhận được giải thưởng trị giá " + GT2());
                    K.themTien(idK, GT2());
                } else if (r == 3){
                    System.out.println("Vâng! Chúc mừng bạn nhận được giải thưởng trị giá " + GT3());
                    K.themTien(idK, GT3());
                } else if(r == 4){
                    System.out.println("Vâng! Chúc mừng bạn nhận được giải thưởng trị giá " + GT4());
                    K.themTien(idK, GT4());
                } else {
                    System.out.println("Vâng! Chúc mừng bạn nhận được giải thưởng trị giá " + GT5());
                    K.themTien(idK, GT5());
                }
                System.out.println();
                l--;
            }
            setLanQuay(idK, dk);
            System.out.println("Quay xong rồi, tạm biệt!");
            System.out.println();
        }
    }

}
