public class lichSu {
    private int idK;
    private String Ls, date;

    public lichSu() {
    }

    public lichSu(int idK, String ls, String date) {
        this.idK = idK;
        Ls = ls;
        this.date = date;
    }


    public String getLs() {
        return Ls;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "lichSu{" +
                "Ls='" + Ls + '\'' +
                ", date='" + date +
                '}';
    }

    public void showNDLS(){
        System.out.printf("%-35s %s \n", getLs(), getDate());
    }
}
