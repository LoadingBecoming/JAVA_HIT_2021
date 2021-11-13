package B3;

import java.util.Collections;
import java.util.Scanner;

public class RunMain {
        public static void main(String[] args) {
        LOPHOC L = new LOPHOC();
        nhap(L);
        System.out.println();
        xuat(L);
        System.out.println();
        dem(L);
        System.out.println();
        sapxep(L);
        xuat(L);
    }
    public static void nhap(LOPHOC L){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ma lop: ");
        L.setMaLP(sc.nextLine());
        System.out.print("Ten lop: ");
        L.setTenLP(sc.nextLine());
        System.out.print("Giao vien: ");
        L.setGiaoVien(sc.nextLine());
        System.out.print("So luong sinh vien: ");
        L.setN(sc.nextInt());
        for(int i=0;i<L.getN();i++){
            System.out.println("Nhap sinh vien thu " + (i+1) + ": ");
            SINHVIEN S = new SINHVIEN();
            S.nhap();
            sc.nextLine();
            System.out.print("Ma sv: ");
            S.setMaSV(sc.nextLine());
            System.out.print("Nganh: ");
            S.setNganh(sc.nextLine());
            System.out.print("Khoa hoc: ");
            S.setKhoaHoc(sc.nextInt());
            L.SV.add(S);
        }
    }

    public static void xuat(LOPHOC L){
        System.out.println("Ma lop: " + L.getMaLP());
        System.out.println("Ten lop: " + L.getTenLP());
        System.out.println("Giao vien: " + L.getGiaoVien());
        System.out.println("Danh sach sv: ");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", "Ho Ten", "Ngay Sinh", "Que Quan", "Ma sv", "Nganh", "Khoa hoc");
        for(SINHVIEN V:L.SV){
            V.xuat();
            System.out.printf("%-20s %-20s %-20d\n", V.getMaSV(), V.getNganh(), V.getKhoaHoc());
        }
    }

    public static void dem(LOPHOC L){
        int d=0;
        for(SINHVIEN V:L.SV){
            if(V.getKhoaHoc() == 15) d++;
        }
        System.out.println("So SV K15: " + d);
    }

    public static void sapxep(LOPHOC L){
        for(int i=0;i<L.getN();i++){
            for(int j=i+1;j<L.getN();j++){
                if(L.SV.get(i).getKhoaHoc() > L.SV.get(j).getKhoaHoc()) Collections.swap(L.SV, i, j);
            }
        }
    }
}
