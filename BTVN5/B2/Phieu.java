package B2;

import java.util.Scanner;
import java.util.ArrayList;
public class Phieu {
    Scanner sc = new Scanner(System.in);
    private String maPhieu, tenPhieu;
    DateTime a = new DateTime();
    private int n;
    ArrayList<SanPham> SP = new ArrayList<>();


    public void inputPhieu(){
        System.out.print("Ma phieu: ");
        maPhieu = sc.nextLine();
        System.out.print("Ten phieu: ");
        tenPhieu = sc.nextLine();
        a.inputDate();
        System.out.print("So luong san pham: ");
        n = sc.nextInt();
        for(int i=0;i<n;i++){
            SanPham S = new SanPham();
            S.inputSP();
            SP.add(S);
        }
    }

    public void outputPhieu(){
        System.out.println("Ma Phieu: " + maPhieu);
        System.out.println("Ten Phieu: " + tenPhieu);
        System.out.print("DateTime: ");
        a.outputDate();

        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Ma SP", "Ten SP", "So luong", "Don gia", "Thanh tien");
        for(SanPham s:SP){
            s.outputSP();
            System.out.println();
        }
    }
}
