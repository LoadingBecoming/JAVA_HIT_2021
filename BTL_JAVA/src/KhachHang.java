public class KhachHang implements Comparable<KhachHang>{
    private String tenK, gioiTinhK, diaChiK, emailK, phoneK, usernameK, passwordK;
    private int idK, viTien;

    public KhachHang() {
    }

    public KhachHang(int idK, String tenK, String gioiTinhK, String diaChiK, String emailK, String phoneK, String usernameK, String passwordK, int viTien) {
        this.tenK = tenK;
        this.gioiTinhK = gioiTinhK;
        this.diaChiK = diaChiK;
        this.emailK = emailK;
        this.phoneK = phoneK;
        this.usernameK = usernameK;
        this.passwordK = passwordK;
        this.idK = idK;
        this.viTien = viTien;
    }

    public String getTenK() {
        return tenK;
    }

    public void setTenK(String tenK) {
        this.tenK = tenK;
    }

    public String getGioiTinhK() {
        return gioiTinhK;
    }

    public void setGioiTinhK(String gioiTinhK) {
        this.gioiTinhK = gioiTinhK;
    }

    public String getDiaChiK() {
        return diaChiK;
    }

    public void setDiaChiK(String diaChiK) {
        this.diaChiK = diaChiK;
    }

    public String getEmailK() {
        return emailK;
    }

    public void setEmailK(String emailK) {
        this.emailK = emailK;
    }

    public String getPhoneK() {
        return phoneK;
    }

    public void setPhoneK(String phoneK) {
        this.phoneK = phoneK;
    }

    public String getUsernameK() {
        return usernameK;
    }

    public void setUsernameK(String usernameK) {
        this.usernameK = usernameK;
    }

    public String getPasswordK() {
        return passwordK;
    }

    public void setPasswordK(String passwordK) {
        this.passwordK = passwordK;
    }

    public int getIdK() {
        return idK;
    }

    public void setIdK(int idK) {
        this.idK = idK;
    }

    public int getViTien() {
        return viTien;
    }

    public void setViTien(int viTien) {
        this.viTien = viTien;
    }

    @Override
    public int compareTo(KhachHang o) {
        return 0;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                " id=" + idK +
                ", tenK='" + tenK + '\'' +
                ", gioiTinh='" + gioiTinhK + '\'' +
                ", diaChi='" + diaChiK + '\'' +
                ", email='" + emailK + '\'' +
                ", phone='" + phoneK + '\'' +
                ", username='" + usernameK + '\'' +
                ", password='" + passwordK + '\'' +
                ", viTien=" + viTien +
                '}';
    }

    public String toString2() {
        return "KhachHang{" +
                " id=" + idK +
                ", tenK='" + tenK + '\'' +
                ", gioiTinh='" + gioiTinhK + '\'' +
                ", diaChi='" + diaChiK + '\'' +
                ", email='" + emailK + '\'' +
                ", phone='" + phoneK + '\'' +
                ", viTien=" + viTien +
                '}';
    }

    public void showMeK(){
        System.out.printf("%-10s %-20s %-15s %-15s %-20s %-10s %-10s %-10s %s \n","Id", "Tên", "Giới tính", "Địa chỉ",
                "Email", "Phone", "Username", "Password", "Ví tiền");
        System.out.printf("%-5d %-25s %-15s %-15s %-20s %-12s %-10s %-10s %d \n", getIdK(), getTenK(), getGioiTinhK(), getDiaChiK(),
                getEmailK(), getPhoneK(), getUsernameK(), getPasswordK(), getViTien());
    }

    public void showMeK2(){
        System.out.printf("%-5d %-25s %-15s %-15s %-20s %-17s %d \n", getIdK(), getTenK(), getGioiTinhK(), getDiaChiK(),
                getEmailK(), getPhoneK(), getViTien());
    }
}
