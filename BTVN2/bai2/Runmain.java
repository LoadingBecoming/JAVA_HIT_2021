package bai2;

import java.util.Scanner;

public class Runmain {
    public static void nhapArry(int a[], int n){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mang: ");
        for(int i=0;i<n;i++)
            a[i]= sc.nextInt();
    }

    public static void xuatArray(int a[],int n){
        System.out.print("Mang xuat: ");
        for(int i=0;i<n;i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void them(int a[],int n){
        Scanner sc = new Scanner(System.in);
        System.out.print("Vi tri can them: ");
        int k = sc.nextInt();
        System.out.print("So can them x = ");
        int x = sc.nextInt();
        for(int i=n; i>=k;i--){
            a[i] = a[i-1];
        }
        a[k] = x;
    }
    public static void xoa(int a[], int n){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vi tri can xoa x = ");
        int x = sc.nextInt();
        for(int i=x; i<n;i++)
            a[i] = a[i+1];
    }
    public static void reverArray(int a[], int n){
        int[] b = new int[n+5];
        for(int i=0;i<n;i++)
            b[i] = a[i];
        for(int i=n-1;i>=0;i--)
            a[i] = b[n-1-i];
    }
    public static void a1(int a[], int n){
        System.out.println("a[1] = " + a[1]);
        System.out.print("Cac so chia het cho a[1] la: ");
        for(int i=1;i<n;i++)
            if(a[i] % a[1] == 0)
                System.out.print(a[i] + " ");
        System.out.println();
    }
    public static boolean snt(int n){
        for(int i=2;i*i<=n;i++)
            if(n % i == 0) return false;
        return n>1;
    }
    public static void tong(int a[], int n){
        int tong = 0;
        System.out.print("Tong cac so nguyen to trong mang la ");
        for(int i=0;i<n;i++)
            if(snt(a[i]))
                tong += a[i];
        System.out.println(tong);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n= ");
        int n = sc.nextInt();
        int[] a = new int[n+5];
        while(true){
            System.out.println("Nhap lenh: ");
            int lenh = sc.nextInt();
            switch (lenh) {
                case 1:
                    nhapArry(a,n);
                    break;
                case 2:
                    xuatArray(a,n);
                    break;
                case 3:
                    them(a,n);
                    n++;
                    xuatArray(a,n);
                    break;
                case 4:
                    xoa(a,n);
                    n--;
                    xuatArray(a,n);
                    break;
                case 5:
                    reverArray(a,n);
                    xuatArray(a,n);
                    break;
                case 6:
                    a1(a,n);
                    break;
                case 7:
                    tong(a,n);
                    break;
                case 8:
                    System.out.println("Chuong trinh ket thuc - Tam biet!");
                    return;
                default:
                    System.out.println("Nhap lai");
            }
        }
    }
}
