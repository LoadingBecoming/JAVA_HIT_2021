package B4;

import java.util.Scanner;
public class QUANLY {
    private Scanner sc = new Scanner(System.in);
    private String maql, hoten;

    public void nhap(){
        System.out.print("Nhap ma quan ly: ");
        maql = sc.nextLine();
        System.out.print("Nhap ho ten: ");
        hoten = sc.nextLine();
    }

    public void xuat(){
        System.out.println("Ma quan ly: " + maql);
        System.out.println("Ho ten: " + hoten);
    }
}
