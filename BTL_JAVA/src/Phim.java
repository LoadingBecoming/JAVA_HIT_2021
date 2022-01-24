public class Phim {
    private int idP;
    private String tenP, thoiLuong, theLoai, moTa;

    public Phim() {
    }

    public Phim(int idP, String tenP, String thoiLuong, String theLoai, String moTa) {
        this.idP = idP;
        this.tenP = tenP;
        this.thoiLuong = thoiLuong;
        this.theLoai = theLoai;
        this.moTa = moTa;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getTenP() {
        return tenP;
    }

    public void setTenP(String tenP) {
        this.tenP = tenP;
    }

    public String getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(String thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "Phim{" +
                "idP=" + idP +
                ", tenP='" + tenP + '\'' +
                ", thoiLuong='" + thoiLuong + '\'' +
                ", theLoai='" + theLoai + '\'' +
                ", moTa='" + moTa + '\'' +
                '}';
    }

    public void showP(){
        System.out.printf("%-5d %-30s %-13s %-15s %s \n", getIdP(), getTenP(), getThoiLuong(), getTheLoai(), getMoTa());
    }
}
