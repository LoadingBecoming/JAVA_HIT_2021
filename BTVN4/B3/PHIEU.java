package B3;

import jdk.jshell.spi.SPIResolutionException;

import java.util.Scanner;
public class PHIEU {
    private Scanner sc = new Scanner(System.in);
    private String maphieu;
    private int n;
    private HANG[] x;

    public void nhap(){
        System.out.print("Nhap ma phieu: ");
        maphieu = sc.nextLine();
        System.out.print("Nhap so luong hang: ");
        n = sc.nextInt();
        x = new HANG[n];
        for(int i=0;i<n;i++){
            x[i] = new HANG();
            System.out.println("Nhap HANG thu " + (i+1) + ": ");
            x[i].nhap();
        }
    }

    public void xuat(){
        System.out.println("Ma phieu: " + maphieu);
        System.out.printf("%-12s%-12s%s \n", "Ma hang", "Ten hang", "Don gia");
        for(int i=0;i<n;i++){
            x[i].xuat();
            System.out.println();
        }
    }
}
