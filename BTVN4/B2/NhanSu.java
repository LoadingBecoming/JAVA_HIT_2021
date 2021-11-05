package B2;

import java.util.Scanner;
public class NhanSu {
    private Scanner sc = new Scanner(System.in);
    private String manhansu, hoten;
    private Date NS = new Date();

    public void nhap(){
        System.out.print("Nhap ma nhan su: ");
        manhansu = sc.nextLine();
        System.out.print("Nhap ho ten: ");
        hoten = sc.nextLine();
        NS.nhap();
    }

    public void xuat(){
        System.out.println("Ma nhan su: " + manhansu);

        System.out.println("Ho ten: " + hoten);

        NS.xuat();
    }
}
