package B3;

import java.util.Scanner;
public class NGUOI {
    Scanner sc = new Scanner(System.in);
    private String hoTen, ngaySinh, queQuan;
    public void nhap(){
        System.out.print("Ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("Ngay sinh: ");
        ngaySinh = sc.nextLine();
        System.out.print("Que quan: ");
        queQuan = sc.nextLine();
    }
    public void xuat(){
        System.out.printf("%-20s %-20s %-20s", hoTen, ngaySinh, queQuan);
    }
}
