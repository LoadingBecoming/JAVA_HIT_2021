package B3;

import java.util.ArrayList;
import java.util.Scanner;
public class LOPHOC {
    Scanner sc = new Scanner(System.in);
    private String maLP, tenLP, ngayMo, giaoVien;
    ArrayList<SINHVIEN> SV = new ArrayList<>();
    private int n;

    public LOPHOC() {}

    public String getMaLP() {
        return maLP;
    }

    public String getTenLP() {
        return tenLP;
    }

    public String getNgayMo() {
        return ngayMo;
    }

    public String getGiaoVien() {
        return giaoVien;
    }

    public ArrayList<SINHVIEN> getSV() {
        return SV;
    }

    public int getN() {
        return n;
    }

    public void setMaLP(String maLP) {
        this.maLP = maLP;
    }

    public void setTenLP(String tenLP) {
        this.tenLP = tenLP;
    }

    public void setNgayMo(String ngayMo) {
        this.ngayMo = ngayMo;
    }

    public void setGiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }

    public void setSV(ArrayList<SINHVIEN> SV) {
        this.SV = SV;
    }

    public void setN(int n) {
        this.n = n;
    }


}
