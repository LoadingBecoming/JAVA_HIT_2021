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
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    static Date date;
    static SQLProcessLS PrL;
    static QuanLy quanLy = new QuanLy();
    static SQLProcessQL PrQ = new SQLProcessQL();
    static SQLProcessFilm PrF = new SQLProcessFilm();
    static SQLProcessVe PrV = new SQLProcessVe();
    static SQLProcessDV PrDV = new SQLProcessDV();
    static SQLProcessDT PrDT = new SQLProcessDT();
    static SQLProcessGT PrGT = new SQLProcessGT();

    public static void main(String[] args) throws SQLException, InterruptedException {
        Connection conn = SQLServerConnection.getJDBCConnection();
        Statement statement = conn.createStatement();

        while (true){
            System.out.println("|```````````````````````|");
            System.out.println("| Bạn là ai?...         |");
            System.out.println("| 1.Khách hàng          |");
            System.out.println("| 2.Quản lý             |");
            System.out.println("| 3.Exit!               |");
            System.out.println("|_______________________|");
            System.out.print("Mời nhập lựa chọn: ");
            int n = sc.nextInt();
            switch (n){
                case 1:
                    int stop = 1;
                    while (stop == 1){
                        System.out.println("|`````````````````````````|");
                        System.out.println("|                        (1)|");
                        System.out.println("| 1.Đã có tài khoản!      |");
                        System.out.println("| 2.Tạo tài khoản!        |");
                        System.out.println("| 3.Exit!                 |");
                        System.out.println("|_________________________|");
                        System.out.print("Nhập lựa chọn: ");
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

    public static void LoginK() throws SQLException, InterruptedException {
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


    public static void AcctiveKH(int idK) throws SQLException, InterruptedException {
        int stop = 1;
        while (stop == 1){
            System.out.println("|`````````````````````````````````````````|");
            System.out.println("|                                      (1.1)|");
            System.out.println("| 1.Show in4 bản thân!                    |");
            System.out.println("| 2.Thay đổi thông tin cá nhân!           |");
            System.out.println("| 3.Đặt phim!                             |");
            System.out.println("| 4.Xem các chỗ ngồi đã đặt!              |");
            System.out.println("| 5.Nạp tiền!                             |");
            System.out.println("| 6.Xem lịch sử hoạt động!                |");
            System.out.println("| 7.Exit!                                 |");
            if(PrGT.lanQuay(idK, PrGT.getDK()) > 0){
                System.out.println("| 8.Quay thưởng bí ẩn!                   |");
            }
            System.out.println("|_________________________________________|");
            System.out.print("Nhập lựa chọn: ");
            int x = sc.nextInt();
            System.out.println();
            switch (x){
                case 1:
                    K.showIn4Me(K.allDsKH(), idK);
                    System.out.println();
                    break;
                case 2:
                    changeK(idK);
                    break;
                case 3:
                    int thoat = 1;
                    while (thoat == 1){
                        dsPhim();
                        System.out.println();
                        System.out.println("|``````````````````````|");
                        System.out.println("|                   (1.2)|");
                        System.out.println("| 1.Đặt ghế!           |");
                        System.out.println("| 2.Hủy ghế!           |");
                        System.out.println("| 3.Exit!              |");
                        System.out.println("|______________________|");
                        System.out.print("Nhập lựa chọn: ");
                        int z = sc.nextInt();
                        switch (z){
                            case 1:
                                DatGhe(idK);
                                break;
                            case 2:
                                HuyGhe(idK);
                                break;
                            case 3:
                                thoat = 0;
                        }
                    }
                    break;
                case 4:
                    PrDV.showGDV(PrDV.mangIdPDV(idK), idK);
                    break;
                case 5:
                    K.napTien(idK);
                    break;
                case 6:
                    showLs(idK);
                    System.out.println();
                    break;
                case 7:
                    stop = 0;
                case 8:
                    if(PrGT.lanQuay(idK, PrGT.getDK()) > 0){
                        PrGT.quayThuong(idK, PrGT.getDK());
                    }
                    break;
            }
        }
    }


    public static void DatGhe(int idK) throws SQLException {
        int stop = 1;
        int VNL = PrV.getVNL();
        int VTE = PrV.getVTE();
        while (stop == 1){
            System.out.println("|`````````````````````````````````|");
            System.out.println("|                              (1.3)|");
            System.out.println("| 1.Giá vé người lớn: " + VNL + "         |");
            System.out.println("| 2.Giá vé trẻ em: " + VTE + "             |");
            System.out.println("| 3.Exit!                         |");
            System.out.println("|_________________________________|");
            System.out.print("Nhập lựa chọn: ");
            int x = sc.nextInt();
            switch (x){
                case 1:
                    if(K.checkViTien(idK) >= VNL){
                        System.out.print("Nhập id phim muốn đặt ghế: ");
                        int idP = sc.nextInt();
                        while (true){
                            PrDV.gheTrongDV(PrDV.mangSoGheDV(idP));
                            PrDV.gheTrongDV(PrDV.mangSoGheDV(idP, idK, "NL"), idP, idK, "NL");
                            System.out.print("Bạn muốn đặt ghế số: ");
                            int soG = sc.nextInt();
                            if(PrDV.checkDatDV(PrDV.mangSoGheDV(idP), soG)){
                                PrDV.updateDV(PrDV.themGheDV(soG, idP, idK, "NL"), idP, idK, "NL");
                                System.out.println("Đặt ghế thành công!");
                                K.truTien(idK, PrV.getVNL());
                                PrDT.upNL();
                                System.out.println();

                                String dG = "Bạn đã đặt 1 ghế xem phim!";
                                date = new Date();
                                PrL.insertLS(idK,dG, simpleDateFormat.format(date));
                                break;
                            } else {
                                System.out.println("Ghế này không thể đặt! NHẬP LẠI!");
                            }
                        }
                    } else {
                        System.out.println("Ví tiền của bạn không đủ, HÃY NẠP TIỀN!");
                        System.out.println();
                    }
                    break;
                case 2:
                    if(K.checkViTien(idK) >= VTE){
                        System.out.print("Nhập id phim muốn đặt ghế: ");
                        int idP = sc.nextInt();
                        while (true){
                            PrDV.gheTrongDV(PrDV.mangSoGheDV(idP));
                            PrDV.gheTrongDV(PrDV.mangSoGheDV(idP, idK, "TE"), idP, idK, "TE");
                            System.out.print("Bạn muốn đặt ghế số: ");
                            int soG = sc.nextInt();
                            if(PrDV.checkDatDV(PrDV.mangSoGheDV(idP), soG)){
                                PrDV.updateDV(PrDV.themGheDV(soG, idP, idK, "TE"), idP, idK, "TE");
                                System.out.println("Đặt ghế thành công!");
                                K.truTien(idK, PrV.getVTE());
                                PrDT.upTE();
                                System.out.println();

                                String dG = "Bạn đã đặt 1 ghế xem phim!";
                                date = new Date();
                                PrL.insertLS(idK,dG, simpleDateFormat.format(date));
                                break;
                            } else {
                                System.out.println("Ghế này không thể đặt! NHẬP LẠI!");
                            }
                        }
                    } else {
                        System.out.println("Ví tiền của bạn không đủ, HÃY NẠP TIỀN!");
                        System.out.println();
                    }
                    break;
                case 3:
                    stop = 0;
            }
        }
    }

    public static void HuyGhe(int idK) throws SQLException {
        System.out.print("Nhập id phim muốn hủy ghế: ");
        int iP = sc.nextInt();
        if(PrDV.mangSoGheDV(iP, idK).size() > 0){
            while (true){
                System.out.println("Các số ghế bạn đã đặt là: ");
                System.out.println(PrDV.mangSoGheDV(iP, idK));
                System.out.print("Người lớn: ");
                System.out.println(PrDV.mangSoGheDV(iP, idK, "NL"));
                System.out.print("Trẻ em: ");
                System.out.println(PrDV.mangSoGheDV(iP, idK, "TE"));
                System.out.print("Bạn muốn hủy ghế số: ");
                int sG = sc.nextInt();
                if(PrDV.checkHuyDV(PrDV.mangSoGheDV(iP, idK), sG)){
                    PrDV.huyGheDV(PrDV.mangSoGheDV(iP, idK, "NL"), sG, iP, idK, "NL");
                    PrDV.huyGheDV(PrDV.mangSoGheDV(iP, idK, "TE"), sG, iP, idK, "TE");

                    for(int i=0;i<PrDV.mangSoGheDV(iP, idK, "NL").size();i++){
                        if(PrDV.mangSoGheDV(iP, idK, "NL").get(i) == sG){
                            K.themTien(idK, PrV.getVNL());
                            break;
                        }
                    }
                    for(int i=0;i<PrDV.mangSoGheDV(iP, idK, "TE").size();i++){
                        if(PrDV.mangSoGheDV(iP, idK, "TE").get(i) == sG){
                            K.themTien(idK, PrV.getVTE());
                            break;
                        }
                    }

                    System.out.println("Bạn đã hủy đặt ghế thành công!");
                    System.out.println();

                    String hG = "Bạn đã hủy ghế xem phim!";
                    date = new Date();
                    PrL.insertLS(idK, hG, simpleDateFormat.format(date));
                    break;
                } else {
                    System.out.println("Bạn không đặt số ghế này, KHÔNG THỂ HỦY, NHẬP LẠI!");
                }
            }
        } else {
            System.out.println("Bạn chưa đặt ghế nên không thể hủy! HÃY ĐẶT GHẾ!");
            System.out.println();
        }
    }

    public static void changeK(int idK) throws SQLException {
        int stop = 1;
        while (stop == 1){
            System.out.println("|``````````````````````````|");
            System.out.println("|                       (1.2)|");
            System.out.println("| 1.Đổi Tên                |");
            System.out.println("| 2.Giới tính              |");
            System.out.println("| 3.Địa chỉ                |");
            System.out.println("| 4.Email                  |");
            System.out.println("| 5.Phone                  |");
            System.out.println("| 6.UserName               |");
            System.out.println("| 7.Password               |");
            System.out.println("| 8.Exit!                  |");
            System.out.println("|__________________________|");
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
                    PrL.insertLS(idK, ten, simpleDateFormat.format(date));
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
                    PrL.insertLS(idK, gt, simpleDateFormat.format(date));
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
                    PrL.insertLS(idK, dc, simpleDateFormat.format(date));
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
                    PrL.insertLS(idK, em, simpleDateFormat.format(date));
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
                    PrL.insertLS(idK, ph, simpleDateFormat.format(date));
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
                    PrL.insertLS(idK, us, simpleDateFormat.format(date));
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
                    PrL.insertLS(idK, pw, simpleDateFormat.format(date));
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
        PrK.insertKH(NameK, gioiTinhK, diaChiK, emailK, phoneK, userNameK, passK, 0);
        PrGT.insertCheckGT(idK, 0);
        System.out.println("Tạo account thành công!");
    }



    public static void dsPhim(){
        film.showP(film.allDsP());
    }

    public static void showLs(int idk){
        List<lichSu> dsLS = new ArrayList<>();
        dsLS = PrL.showLS(idk);
        System.out.printf("%-40s %s \n","Lịch sử hoạt động", "Thời gian");
        for(lichSu lichsu:dsLS){
            lichsu.showNDLS();
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
            System.out.println("|`````````````````````````````````````|");
            System.out.println("|                                    (2)|");
            System.out.println("| 1.Show in4 bản thân!                |");
            System.out.println("| 2.Thay đổi thông tin cá nhân!       |");
            System.out.println("| 3.Xem danh sách quản lý!            |");
            System.out.println("| 4.Xem danh sách khách hàng!         |");
            System.out.println("| 5.Thêm/Xóa phim!                    |");
            System.out.println("| 6.Tạo giá vé!                       |");
            System.out.println("| 7.Thay đổi thưởng bí ẩn!            |");
            System.out.println("| 8.Exit!                             |");
            System.out.println("|_____________________________________|");
            System.out.print("Nhập lựa chọn: ");
            int x = sc.nextInt();
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
                        System.out.println("|`````````````````````````````|");
                        System.out.println("|                          (2.1)|");
                        System.out.println("| 1.Sắp xếp ds theo id!       |");
                        System.out.println("| 2.Sắp xếp ds theo tên!      |");
                        System.out.println("| 3.Tìm kiếm theo tên!        |");
                        System.out.println("| 4.Exit!                     |");
                        System.out.println("|_____________________________|");
                        System.out.print("Nhập lựa chọn: ");
                        int y = sc.nextInt();
                        switch (y){
                            case 1:
                                quanLy.sapXepTheoId(quanLy.allDsQL());
                                break;
                            case 2:
                                quanLy.sapXepTheoTen(quanLy.allDsQL());
                                break;
                            case 3:
                                sc.nextLine();
                                System.out.print("Nhập từ muốn tìm kiếm: ");
                                String ten = sc.nextLine();
                                quanLy.showIn4One(quanLy.searchDsQL(ten));
                                break;
                            case 4:
                                thoat = 0;
                        }
                    }
                    break;
                case 4:
                    showKH();
                    break;
                case 5:
                    int quay = 1;
                    while (quay == 1){
                        System.out.println("|``````````````````````|");
                        System.out.println("|                   (2.1)|");
                        System.out.println("| 1.Thêm phim!         |");
                        System.out.println("| 2.Xóa phim!          |");
                        System.out.println("| 3.Exit!              |");
                        System.out.println("|______________________|");
                        System.out.print("Nhập lựa chọn: ");
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
                case 6:
                    PrV.changeGia();
                    break;
                case 7:
                    quanLy.changeGT();
                    break;
                case 8:
                    stop = 0;
            }
        }
    }

    public static void changeQ(int idQ) throws SQLException {
        int stop = 1;
        while (stop == 1){
            System.out.println("|```````````````````````|");
            System.out.println("|                    (2.1)|");
            System.out.println("| 1.Đổi Tên             |");
            System.out.println("| 2.Giới tính           |");
            System.out.println("| 3.Địa chỉ             |");
            System.out.println("| 4.Email               |");
            System.out.println("| 5.Phone               |");
            System.out.println("| 6.UserName            |");
            System.out.println("| 7.Password            |");
            System.out.println("| 8.Exit!               |");
            System.out.println("|_______________________|");
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
                    PrQ.updateQPass(idQ, passQ);
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
            System.out.println("|`````````````````````````````|");
            System.out.println("|                          (2.1)|");
            System.out.println("| 1.Show theo tên!            |");
            System.out.println("| 2.Show theo id!             |");
            System.out.println("| 3.Tìm kiếm theo tên!        |");
            System.out.println("| 4.Exit!                     |");
            System.out.println("|_____________________________|");
            System.out.print("Nhập lựa chọn: ");
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
                    sc.nextLine();
                    System.out.print("Nhập từ muốn tìm kiếm: ");
                    String ten = sc.nextLine();
                    K.showIn4OneK(K.showOneKH(ten));
                    break;
                case 4:
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
        //PrG.deleteG(idP);
        PrF.deleteP(idP);
        PrDV.deleteDV(idP);
        System.out.println("Xóa phim thành công!");
        System.out.println();

        System.out.println("-------DANH SÁCH PHIM SAU XÓA------");
        dsPhim();
        System.out.println();
    }
}
