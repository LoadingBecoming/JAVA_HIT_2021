package B2;

import java.util.Scanner;
public class SanPham {
    private Scanner sc = new Scanner(System.in);
    private String maSP, tenSP;
    private int soLuong;
    private float donGia;
    public void inputSP(){
        System.out.print("Ma SP: ");
        maSP = sc.nextLine();
        System.out.print("Ten SP: ");
        tenSP = sc.nextLine();
        System.out.print("So luong: ");
        soLuong = sc.nextInt();
        System.out.print("Don gia: ");
        donGia = sc.nextFloat();
    }
    public void outputSP(){
        System.out.printf("%-20s %-20s %-20d %-20.2f %-20.2f", maSP, tenSP, soLuong, donGia, soLuong*donGia);
    }
}
