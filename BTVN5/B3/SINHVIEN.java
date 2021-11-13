package B3;

import java.util.Scanner;
public class SINHVIEN extends NGUOI {
    Scanner sc = new Scanner(System.in);
    private String maSV, nganh;
    private int khoaHoc;

    public SINHVIEN() {}

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public void setKhoaHoc(int khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getNganh() {
        return nganh;
    }

    public int getKhoaHoc() {
        return khoaHoc;
    }
}
