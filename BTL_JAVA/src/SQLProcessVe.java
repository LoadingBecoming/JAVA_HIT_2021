import java.sql.*;
import java.util.Scanner;

public class SQLProcessVe {
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

    public static void updateVNL(int NL) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update Ve set NguoiLon = ? ");
        preparedStatement.setInt(1, NL);
        int k1 = preparedStatement.executeUpdate();
    }

    public static void updateVTE(int TE) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("update Ve set TreEm = ? ");
        preparedStatement.setInt(1, TE);
        int k1 = preparedStatement.executeUpdate();
    }

    public static void changeGia() throws SQLException {
        int stop = 1;
        while (stop == 1){
            System.out.println("|`````````````````````````|");
            System.out.println("|                      (2.1)|");
            System.out.println("| 1.Vé người lớn!         |");
            System.out.println("| 2.Vé trẻ em!            |");
            System.out.println("| 3.Exit!                 |");
            System.out.println("|_________________________|");
            System.out.print("Nhập lựa chọn: ");
            int x = sc.nextInt();
            switch (x){
                case 1:
                    System.out.print("Nhập giá vé người lớn: ");
                    int NL = sc.nextInt();
                    updateVNL(NL);
                    System.out.println("Tạo thành công!");
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Nhập giá vé trẻ em: ");
                    int TE = sc.nextInt();
                    updateVTE(TE);
                    System.out.println("Tạo thành công!");
                    System.out.println();
                case 3:
                    stop = 0;
            }
        }
    }

    public static int getVNL() throws SQLException {
        String sql = "select NguoiLon from Ve";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        return resultSet.getInt(1);
    }

    public static int getVTE() throws SQLException {
        String sql = "select TreEm from Ve";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        return resultSet.getInt(1);
    }
}
