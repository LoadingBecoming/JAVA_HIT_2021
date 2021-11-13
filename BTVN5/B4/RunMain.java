package B4;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SUM<Integer> S = new SUM<Integer>();
        System.out.print("Nhap so a: ");
        S.setA(sc.nextInt());
        System.out.print("Nhap so b: ");
        S.setB(sc.nextInt());
        System.out.println("Tong 2 so kieu int: " + (S.getA() + S.getB()));

        SUM<Long> U = new SUM<Long>();
        System.out.print("Nhap so a: ");
        U.setA(sc.nextLong());
        System.out.print("Nhap so b: ");
        U.setB(sc.nextLong());
        System.out.println("Tong 2 so kieu long: " + (U.getA() + U.getB()));

        SUM<Float> M = new SUM<Float>();
        System.out.print("Nhap so a: ");
        M.setA(sc.nextFloat());
        System.out.print("Nhap so b: ");
        M.setB(sc.nextFloat());
        System.out.println("Tong 2 so kieu float: " + (M.getA() + M.getB()));

        SUM<Double> G = new SUM<Double>();
        System.out.print("Nhap so a: ");
        G.setA(sc.nextDouble());
        System.out.print("Nhap so b: ");
        G.setB(sc.nextDouble());
        System.out.println("Tong 2 so kieu double: " + (G.getA() + G.getB()));
    }
}
