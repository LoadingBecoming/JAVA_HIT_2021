package B1;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sach Sach = new Sach();
        int n;
        System.out.print("So luong sach: ");
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            Sach.nhap();
        }
        for(int i=0;i<n;i++){
            Sach.xuat();
        }
    }
}
