package B2;

import java.util.Scanner;
public class DateTime {
    private Scanner sc = new Scanner(System.in);
    private int d, m, y;
    public void inputDate(){
        System.out.print("Ngay: ");
        d = sc.nextInt();
        System.out.print("Thang: ");
        m = sc.nextInt();
        System.out.print("Nam: ");
        y = sc.nextInt();
    }
    public void outputDate(){
        System.out.println(d + "/ " + m + "/ " + y);
    }
}
