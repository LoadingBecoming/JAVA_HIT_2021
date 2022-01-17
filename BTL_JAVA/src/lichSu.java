public class lichSu {
    private String Ls, date;

    public lichSu() {
    }

    public lichSu(String ls, String date) {
        Ls = ls;
        this.date = date;
    }

    public String getLs() {
        return Ls;
    }

    public void setLs(String ls) {
        Ls = ls;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "lichSu{" +
                "Ls='" + Ls + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
