package B3;

import java.util.ArrayList;

public class News implements INews{
    private int id;
    private String title, pushlishDate, author, content;
    private float averageRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPushlishDate() {
        return pushlishDate;
    }

    public void setPushlishDate(String pushlishDate) {
        this.pushlishDate = pushlishDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(float averageRate) {
        this.averageRate = averageRate;
    }

    @Override
    public void display() {
        System.out.printf("%-20s %-20s %-20s %-20s %-20.3f\n", title, pushlishDate, author, content, averageRate);
    }

    ArrayList<Integer> rateList = new ArrayList<Integer>();
    public void Calculate(){
        double sum = Double.valueOf(0);
        for(int i=0;i<3;i++){
            sum += rateList.get(i);
        }
        this.averageRate = (float) (sum / 3.0);
    }

}
