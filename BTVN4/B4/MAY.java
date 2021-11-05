package B4;

import java.util.Scanner;
public class MAY {
    private Scanner sc = new Scanner(System.in);
    private String mamay, kieumay, tinhtrang;

    public void nhap(){
        System.out.print("Nhap ma may: ");
        mamay = sc.nextLine();
        System.out.print("Nhap kieu may: ");
        kieumay = sc.nextLine();
        System.out.print("Nhap tinh trang: ");
        tinhtrang = sc.nextLine();
    }

    public void xuat(){
        System.out.printf("%-12s%-12s%s", mamay, kieumay, tinhtrang);
    }
}
