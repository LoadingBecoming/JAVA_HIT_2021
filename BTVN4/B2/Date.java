package B2;

import java.util.Scanner;
public class Date {
    private Scanner sc = new Scanner(System.in);
    private int d, m, y;

    public void nhap(){
        System.out.print("Nhap ngay: ");
        d = sc.nextInt();
        System.out.print("Nhap thang: ");
        m = sc.nextInt();
        System.out.print("Nhap nam: ");
        y = sc.nextInt();
    }

    public void xuat(){
        System.out.println(d + "/ " + m + "/ " + y);
    }

}
