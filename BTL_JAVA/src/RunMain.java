import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunMain {
    static Scanner sc = new Scanner(System.in);
    public static Khach K = new Khach();
    static SQLProcessKH PrK = new SQLProcessKH();
    static CreatAcc acc = new CreatAcc();
    static Film film = new Film();
    static SQLProcessGhe PrG = new SQLProcessGhe();
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static Date date;
    static SQLProcessLS PrL;
    static Nguoi nguoi = new Nguoi();
    static QuanLy quanLy = new QuanLy();
    static SQLProcessQL PrQ = new SQLProcessQL();
    static SQLProcessFilm PrF = new SQLProcessFilm();

    public static void main(String[] args) throws SQLException {
        Connection conn = SQLServerConnection.getJDBCConnection();
        Statement statement = conn.createStatement();

        while (true){
            System.out.println("Bạn là ai?...");
            System.out.println("1.Khách hàng");
            System.out.println("2.Quản lý");
            System.out.println("3.Exit!");
            System.out.println("Mời nhập lựa chọn: ");
            int n = sc.nextInt();
            switch (n){
                case 1:
                    int stop = 1;
                    while (stop == 1){
                        System.out.println("1.Đã có tài khoản!");
                        System.out.println("2.Tạo tài khoản!");
                        System.out.println("3.Exit!");
                        System.out.println("Nhập lựa chọn: ");
                        int x = sc.nextInt();
                        switch (x){
                            case 1:
                                LoginK();
                                break;
                            case 2:
                                CreateAccK();
                                break;
                            case 3:
                                stop = 0;
                                break;
                        }
                    }
                    break;
                case 2:
                    LoginQ();
                    break;
                case 3:
                    return;
            }
        }
    }

    public static int CheckLoginK(String tk, String mk){
        List<KhachHang> list = K.allDsKH();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getUsernameK().compareTo(tk) == 0 && list.get(i).getPasswordK().compareTo(mk) == 0) {
                return list.get(i).getIdK();
            }
        }
        return -1;
    }

    public static void LoginK() throws SQLException {
        sc.nextLine();
        String tk, mk;
        int idK = 0;
        System.out.print("Nhap tai khoan: ");
        tk = sc.nextLine();
        System.out.print("Nhap mat khau: ");
        mk = sc.nextLine();
        idK = CheckLoginK(tk, mk);
        if (idK >= 0)
            AcctiveKH(idK);
        else {
            System.out.println("Tai khoan hoac mat khau cua ban khong dung!");
        }
    }


    public static void AcctiveKH(int idK) throws SQLException {
        int stop = 1;
        while (stop == 1){
            System.out.println("1.Show in4 bản thân!");
            System.out.println("2.Nạp tiền!");
            System.out.println("3.Thay đổi thông tin cá nhân!");
            System.out.println("4.Xem danh sách phim!");
            System.out.println("5.Xem lịch sử hoạt động!");
            System.out.println("6.Exit!");
            System.out.print("Nhập lựa chọn: ");
            int x = sc.nextInt();
            System.out.println();
            switch (x){
                case 1:
                    K.showIn4Me(K.allDsKH(), idK);
                    System.out.println();
                    break;
                case 2:
                    K.napTien(idK);
                    break;
                case 3:
                    changeK(idK);
                    break;
                case 4:
                    int thoat = 1;
                    while (thoat == 1){
                        dsPhim();
                        System.out.println();
                        System.out.println("1.Đặt ghế!");
                        System.out.println("2.Hủy ghế!");
                        System.out.println("3.Exit!");
                        System.out.print("Nhập lựa chọn: ");
                        int z = sc.nextInt();
                        switch (z){
                            case 1:
                                System.out.print("Nhập id phim muốn đặt ghế: ");
                                int idP = sc.nextInt();
                                PrG.gheTrong(PrG.mangSoGhe(idP), idP);
                                System.out.print("Bạn muốn đặt ghế số: ");
                                int soG = sc.nextInt();
                                PrG.updateG(PrG.themGhe(soG,idP),idP);
                                System.out.println("Đặt ghế thành công!");
                                K.truTien(idK);
                                System.out.println();

                                String dG = "Bạn đã đặt 1 ghế xem phim!";
                                date = new Date();
                                PrL.insertLS(dG, simpleDateFormat.format(date));
                                break;
                            case 2:
                                System.out.print("Nhập id phim muốn hủy ghế: ");
                                int iP = sc.nextInt();
                                System.out.print("Bạn muốn hủy ghế số: ");
                                int sG = sc.nextInt();
                                PrG.huyGhe(PrG.mangSoGhe(iP),sG, iP);
                                System.out.println("Bạn đã hủy đặt ghế thành công!");
                                K.themTien(idK);
                                System.out.println();

                                String hG = "Bạn đã hủy ghế xem phim!";
                                date = new Date();
                                PrL.insertLS(hG, simpleDateFormat.format(date));
                                break;
                            case 3:
                                thoat = 0;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Lịch sử hoạt động");
                    showLs();
                    System.out.println();
                    break;
                case 6:
                    stop = 0;
            }
        }
    }

    public static void changeK(int idK) throws SQLException {
        int stop = 1;
        while (stop == 1){
            System.out.println("1.Đổi Tên");
            System.out.println("2.Giới tính");
            System.out.println("3.Địa chỉ");
            System.out.println("4.Email");
            System.out.println("5.Phone");
            System.out.println("6.UserName");
            System.out.println("7.Password");
            System.out.println("8.Exit!");
            System.out.print("Nhập lựa chọn: ");
            int y = sc.nextInt();
            switch (y){
                case 1:
                    System.out.print("Nhập Tên: ");
                    sc.nextLine();
                    String tenk = sc.nextLine();
                    PrK.updateKName(idK, tenk);
                    System.out.println("Cập nhật thành công!");
                    System.out.println();

                    String ten = "Bạn đã thay đổi tên!";
                    date = new Date();
                    PrL.insertLS(ten, simpleDateFormat.format(date));
                    break;
                case 2:
                    System.out.print("Nhập Giới tính: ");
                    sc.nextLine();
                    String gioiTinhk = sc.nextLine();
                    PrK.updateKGioiTinh(idK, gioiTinhk);
                    System.out.println("Cập nhật thành công!");
                    System.out.println();

                    String gt = "Bạn đã thay đổi giới tính!";
                    date = new Date();
                    PrL.insertLS(gt, simpleDateFormat.format(date));
                    break;
                case 3:
                    System.out.print("Nhập Địa chỉ: ");
                    sc.nextLine();
                    String diaChik = sc.nextLine();
                    PrK.updateKDiaChi(idK, diaChik);
                    System.out.println("Cập nhật thành công!");
                    System.out.println();

                    String dc = "Bạn đã thay đổi địa chỉ!";
                    date = new Date();
                    PrL.insertLS(dc, simpleDateFormat.format(date));
                    break;
                case 4:
                    System.out.print("Nhập Email: ");
                    sc.nextLine();
                    String emailK = sc.nextLine();
                    PrK.updateKEmail(idK, emailK);
                    System.out.println("Cập nhật thành công!");
                    System.out.println();

                    String em = "Bạn đã thay đổi Email!";
                    date = new Date();
                    PrL.insertLS(em, simpleDateFormat.format(date));
                    break;
                case 5:
                    System.out.print("Nhập Phone: ");
                    sc.nextLine();
                    String phonek = sc.nextLine();
                    PrK.updateKPhone(idK, phonek);
                    System.out.println("Cập nhật thành công!");
                    System.out.println();

                    String ph = "Bạn đã thay đổi sđt!";
                    date = new Date();
                    PrL.insertLS(ph, simpleDateFormat.format(date));
                    break;
                case 6:
                    System.out.print("Nhập new Username: ");
                    sc.nextLine();
                    String userk = sc.nextLine();
                    PrK.updateKUserName(idK, userk);
                    System.out.println("Cập nhật thành công!");
                    System.out.println();

                    String us = "Bạn đã thay đổi Username!";
                    date = new Date();
                    PrL.insertLS(us, simpleDateFormat.format(date));
                    break;
                case 7:
                    System.out.print("Nhập new pass: ");
                    sc.nextLine();
                    String passk = sc.nextLine();
                    PrK.updateKPass(idK, passk);
                    System.out.println("Cập nhật thành công!");
                    System.out.println();

                    String pw = "Bạn đã thay đổi Password!";
                    date = new Date();
                    PrL.insertLS(pw, simpleDateFormat.format(date));
                    break;
                case 8:
                    stop = 0;
            }
        }
    }

    public static void CreateAccK(){
        String userNameK = acc.creUser();
        String passK = acc.crePass();
        String NameK = acc.creTen();
        String gioiTinhK = acc.creGioiTinh();
        String diaChiK = acc.creDiaChi();
        String emailK = acc.creEmail();
        String phoneK = acc.crePhone();
        int idK = K.creIDKH(K.allDsKH());
        PrK.insertKH(idK, NameK, gioiTinhK, diaChiK, emailK, phoneK, userNameK, passK, 0);
        System.out.println("Tạo account thành công!");
    }



    public static void dsPhim(){
        film.showP(film.allDsP());
    }

    public static void showLs(){
        List<lichSu> dsLS = new ArrayList<>();
        dsLS = PrL.showLS();
        for(lichSu lichsu:dsLS){
            System.out.println(lichsu);
        }
    }

    private static void LoginQ() throws SQLException {
        sc.nextLine();
        String tk, mk;
        int idQ = 0;
        while (true) {
            System.out.print("Nhap tai khoan: ");
            tk = sc.nextLine();
            System.out.print("Nhap mat khau: ");
            mk = sc.nextLine();
            idQ = CheckLoginQ(tk, mk);
            if (idQ >= 0)
                break;
            else {
                System.out.println("Tai khoan hoac mat khau cua ban khong dung!");
                System.out.print("Nhập 1 để thoát hoặc nhập số bất kì để tiếp tục: ");
                int stop = sc.nextInt();
                sc.nextLine();
                if(stop == 1){
                    break;
                }
            }
        }
        if(idQ >= 0){
            AcctiveQL(idQ);
        }
        System.out.println();
    }

    public static int CheckLoginQ(String tk, String mk){
        List<Nguoi> list = quanLy.allDsQL();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getUsername().compareTo(tk) == 0 && list.get(i).getPassword().compareTo(mk) == 0) {
                return list.get(i).getId();
            }
        }
        return -1;
    }


    public static void AcctiveQL(int idQ) throws SQLException {
        int stop = 1;
        while (stop == 1){
            System.out.println("1.Show in4 bản thân!");
            System.out.println("2.Thay đổi thông tin cá nhân!");
            System.out.println("3.Xem danh sách quản lý!");
            System.out.println("4.Tìm kiếm Ql theo tên!");
            System.out.println("5.Xem danh sách khách hàng!");
            System.out.println("6.Thêm/Xóa phim!");
            System.out.println("7.Exit!");
            System.out.print("Nhập lựa chọn: ");
            int x = sc.nextInt();
            System.out.println();
            switch (x){
                case 1:
                    quanLy.showIn4Me(quanLy.allDsQL(), idQ);
                    System.out.println();
                    break;
                case 2:
                    changeQ(idQ);
                    break;
                case 3:
                    int thoat = 1;
                    while (thoat == 1){
                        System.out.println();
                        System.out.println("1.Sắp xếp ds theo id!");
                        System.out.println("2.Sắp xếp ds theo tên!");
                        System.out.println("3.Exit!");
                        System.out.println("Nhập lựa chọn: ");
                        int y = sc.nextInt();
                        switch (y){
                            case 1:
                                quanLy.sapXepTheoId(quanLy.allDsQL());
                                break;
                            case 2:
                                quanLy.sapXepTheoTen(quanLy.allDsQL());
                                break;
                            case 3:
                                thoat = 0;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Nhập tên muốn tìm kiếm: ");
                    String ten = sc.nextLine();
                    quanLy.showIn4One(quanLy.allDsQL(), ten);
                    break;
                case 5:
                    showKH();
                    break;
                case 6:
                    int quay = 1;
                    while (quay == 1){
                        System.out.println("1.Thêm phim!");
                        System.out.println("2.Xóa phim!");
                        System.out.println("3.Exit!");
                        System.out.println("Nhập lựa chọn: ");
                        int y = sc.nextInt();
                        switch (y){
                            case 1:
                                addPhim();
                                break;
                            case 2:
                                xoaPhim();
                                break;
                            case 3:
                                quay = 0;
                        }
                    }
                    break;
                case 7:
                    stop = 0;
            }
        }
    }

    public static void changeQ(int idQ) throws SQLException {
        int stop = 1;
        while (stop == 1){
            System.out.println("1.Đổi Tên");
            System.out.println("2.Giới tính");
            System.out.println("3.Địa chỉ");
            System.out.println("4.Email");
            System.out.println("5.Phone");
            System.out.println("6.UserName");
            System.out.println("7.Password");
            System.out.println("8.Exit!");
            System.out.print("Nhập lựa chọn: ");
            int y = sc.nextInt();
            switch (y){
                case 1:
                    System.out.print("Nhập Tên: ");
                    String tenQ = sc.nextLine();
                    PrQ.updateQName(idQ, tenQ);
                    System.out.println("Cập nhật thành công!");
                    break;
                case 2:
                    System.out.print("Nhập Giới tính: ");
                    String gioiTinhQ = sc.nextLine();
                    PrQ.updateQGioiTinh(idQ, gioiTinhQ);
                    System.out.println("Cập nhật thành công!");
                    break;
                case 3:
                    System.out.print("Nhập Địa chỉ: ");
                    String diaChiQ = sc.nextLine();
                    PrQ.updateQDiaChi(idQ, diaChiQ);
                    System.out.println("Cập nhật thành công!");
                    break;
                case 4:
                    System.out.print("Nhập Email: ");
                    String emailQ = sc.nextLine();
                    PrQ.updateQEmail(idQ, emailQ);
                    System.out.println("Cập nhật thành công!");
                    break;
                case 5:
                    System.out.print("Nhập Phone: ");
                    String phoneQ = sc.nextLine();
                    PrQ.updateQPhone(idQ, phoneQ);
                    System.out.println("Cập nhật thành công!");
                    break;
                case 6:
                    System.out.print("Nhập new Username: ");
                    String userQ = sc.nextLine();
                    PrQ.updateQUserName(idQ, userQ);
                    System.out.println("Cập nhật thành công!");
                    break;
                case 7:
                    System.out.print("Nhập new pass: ");
                    String passQ = sc.nextLine();
                    PrQ.updateQName(idQ, passQ);
                    System.out.println("Cập nhật thành công!");
                    break;
                case 8:
                    stop = 0;
            }
        }
    }

    public static void showKH(){
        int stop = 1;
        while (stop == 1){
            System.out.println("1.Show theo ten!");
            System.out.println("2.Show theo id!");
            System.out.println("3.Exit!");
            System.out.println("Nhập lựa chọn: ");
            int x = sc.nextInt();
            switch (x){
                case 1:
                    K.sapXepTheoTen(K.allDsKH());
                    System.out.println();
                    break;
                case 2:
                    K.sapXepTheoId(K.allDsKH());
                    System.out.println();
                    break;
                case 3:
                    stop = 0;
            }
        }
    }

    public static void addPhim(){
        System.out.println("-------DANH SÁCH PHIM HIỆN TẠI------");
        dsPhim();
        System.out.println();
        sc.nextLine();
        System.out.print("Nhập tên phim: ");
        String tenP = sc.nextLine();
        System.out.print("Nhập thời lượng: ");
        String tl = sc.nextLine();
        System.out.print("Nhập thể loại: ");
        String t = sc.nextLine();
        System.out.print("Nhập thời gian chiếu: ");
        String tg = sc.nextLine();

        PrF.insertP(PrF.creIDP(film.allDsP()), tenP, tl, t, tg);
        System.out.println("Thêm phim thành công!");
        System.out.println();

        System.out.println("-------DANH SÁCH PHIM SAU THÊM------");
        dsPhim();
        System.out.println();
    }

    public static void xoaPhim(){
        System.out.println("-------DANH SÁCH PHIM HIỆN TẠI------");
        dsPhim();
        System.out.println();
        System.out.print("Nhập id phim muốn xóa: ");
        int idP = sc.nextInt();
        PrG.deleteG(idP);
        PrF.deleteP(idP);
        System.out.println("Xóa phim thành công!");
        System.out.println();

        System.out.println("-------DANH SÁCH PHIM SAU XÓA------");
        dsPhim();
        System.out.println();
    }
}



/*
*NOTE:
    - Thiếu chức năng kiểm tra xem ví tiền khách có đủ tiền để mua vé không? Không đủ thì sẽ phải nạp tiền rồi mới cho mua
        Giải pháp: - Select cột ViTien trong sql của idK đó
    - Chưa có chức năng lưu lại idK khi đã đặt vé (Thiếu chức năng này thì khi hủy vé Khách có thể hủy số ghế mà mình không đặt)
        Giải pháp: - Thêm cột idK (ở dạng String) lưu lại các id của khách mà đã đặt vé trong sql sau đó kiểm tra
            + Nếu chưa có id tức là chưa đặt
            + Có idK rồi thì sẽ được thực hiện hủy đặt ghế nhưng sẽ có vấn đề là người này vẫn có thể hủy ghế của ng khác)
                ~ Giải pháp: Tạo 1 bảng sql lưu trữ lại thông tin DatGhe(idK, số ghế khách đặt), sau khi kiểm tra khách đã đặt ghế thì
                                    mình sẽ select cột "số ghế" của bảng thông tin DatGhe với where là idK rồi ssau đó so sánh số ghế mà
                                    khách nhập để hủy có trùng với list này không, trùng thì oke còn không thì yc nhập lại hoặc thoát ra.
                             Nhỡ khách mà quên mất số ghế mà mình đặt thì sẽ bật chức năng xem lịch sử hoạt động ("bạn đã đặt ghế số ... ) (đã có chức năng này nhưng sẽ chưa áp dụng vào đây)
                             Thêm chức năng show ViTien khi đã đặt hoặc hủy ghế thành công cho khách xem (đã có chức năng này nhưng sẽ chưa áp dụng vào đây )
 */