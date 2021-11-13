package B1;

import java.util.Scanner;
public class SanPham {
    protected Scanner sc = new Scanner(System.in);
    protected String maSP, tenSP, tenHangSX, ngayNhap;

    public void nhap(){
        System.out.print("Ma SP: ");
        maSP = sc.nextLine();
        System.out.print("Ten SP: ");
        tenSP = sc.nextLine();
        System.out.print("Ten hang SX: ");
        tenHangSX = sc.nextLine();
        System.out.print("Ngay nhap: ");
        ngayNhap = sc.nextLine();
    }
    public void xuat(){
        System.out.printf("%-15s %-15s %-15s %-15s", maSP, tenSP, tenHangSX, ngayNhap);
    }

    public String getTenHangSX() {
        return tenHangSX;
    }
}
