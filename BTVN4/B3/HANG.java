package B3;

import java.util.Scanner;

public class HANG {
    private Scanner sc = new Scanner(System.in);
    private String mahang, tenhang;
    private float dongia;

    public void nhap(){
        System.out.print("Nhap ma hang: ");
        mahang = sc.nextLine();
        System.out.print("Nhap ten hang: ");
        tenhang = sc.nextLine();
        System.out.print("Nhap don gia: ");
        dongia = sc.nextFloat();
        //sc.nextLine();
    }

    public void xuat(){
        System.out.printf("%-12s%-12s%.2f", mahang, tenhang, dongia);
    }

    public float getDongia() {
        return dongia;
    }
}
