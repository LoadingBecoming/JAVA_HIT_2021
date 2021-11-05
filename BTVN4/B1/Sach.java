package B1;

import java.util.Scanner;

public class Sach {
    private String masach, tensach, nxb;
    private int sotrang;
    private float giatien;

    private Scanner sc = new Scanner(System.in);

    public void nhap() {
        System.out.print("Ma sach: ");
        masach = sc.nextLine();
        System.out.print("Ten sach: ");
        tensach = sc.nextLine();
        System.out.print("Nha xuat ban: ");
        nxb = sc.nextLine();
        System.out.print("So trang: ");
        sc.nextInt();
        System.out.print("Gia tien: ");
        giatien = sc.nextFloat();
        sc.nextLine();
    }

    public void xuat(){
        System.out.println();

        System.out.println("Ma sach: " + masach);

        System.out.println("Ten sach: " + tensach);

        System.out.println("Nha xuat ban: " + nxb);

        System.out.println("So trang: " + sotrang);

        System.out.println("Gia tien: " + giatien);

        System.out.println();
    }
}
