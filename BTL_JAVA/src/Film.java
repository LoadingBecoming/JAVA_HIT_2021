import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Film {
    public static List<Phim> allDsP(){
        List<Phim> dsP = new ArrayList<>();
        String sql = "Select * from Phim";
        try {
            ResultSet resultSet = SQLProcessFilm.statement.executeQuery(sql);
            while (resultSet.next()){
                Phim phim = new Phim(
                        resultSet.getInt(1),
                        resultSet.getString(2).trim(),
                        resultSet.getString(3).trim(),
                        resultSet.getString(4).trim(),
                        resultSet.getString(5).trim()
                );
                dsP.add(phim);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsP;
    }

    public static void showP(List<Phim> dsP){
        for(Phim phim:dsP)
            System.out.println(phim);
    }



}
