package B2;

import java.util.Scanner;
public class Array {
    private int n;
    private int a[];

    Scanner sc = new Scanner(System.in);

    public void inputData(){
        System.out.print("Nhap n = ");
        n = sc.nextInt();
        a = new int[n];
        System.out.print("Nhap mang: ");
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
    }
    public void show(){
        System.out.print("Mang la: ");
        for(int i=0;i<n;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public int Sum(){
        int s = 0;
        for(int i=0;i<n;i++){
            s+=a[i];
        }
        return s;
    }
    public void Filter(boolean flag){
        if(flag){
            System.out.print("Day so chan: ");
            for(int i=0;i<n;i++){
                if(a[i] % 2 == 0){
                    System.out.print(a[i] + " ");
                }
            }
            System.out.println();
        }
        else{
            System.out.print("Day so le: ");
            for(int i=0;i<n;i++){
                if(a[i] % 2 != 0){
                    System.out.print(a[i] + " ");
                }
            }
            System.out.println();
        }
    }

    public Array() {
        n = 0;
        a = null;
    }
    public Array(int n, int a[]) {
        this.n = n;
        this.a = a;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }
}
