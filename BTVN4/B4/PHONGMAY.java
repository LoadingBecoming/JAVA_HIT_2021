package B4;

import java.util.Scanner;
public class PHONGMAY {
    private Scanner sc = new Scanner(System.in);
    private String maphong, tenphong;
    private float dientich;
    private int n;
    private QUANLY x = new QUANLY();
    private MAY[] y;

    public void nhap(){
        System.out.print("Nhap ma phong: ");
        maphong = sc.nextLine();
        System.out.print("Nhap ten phong: ");
        tenphong = sc.nextLine();
        System.out.print("Nhap dien tich: ");
        dientich = sc.nextInt();
        x.nhap();
        System.out.print("Nhap so luong may: ");
        n = sc.nextInt();
        y = new MAY[n];
        for(int i=0;i<n;i++){
            y[i] = new MAY();
            System.out.println("Nhap may thu " + (i+1) + ": ");
            y[i].nhap();
        }
    }

    public void xuat(){
        System.out.println("Ma phong: " + maphong);
        System.out.println("Ten phong: " + tenphong);
        System.out.println("Dien tich: " + dientich);
        x.xuat();
        System.out.printf("%-12s%-12s%s \n", "Ma may", "Kieu may", "Tinh trang");
        for(int i=0;i<n;i++){
            y[i].xuat();
            System.out.println();
        }
    }
}
