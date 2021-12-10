package B3;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    News news = new News();
    ArrayList<News> N = new ArrayList<>();
    public void menu(){
       while(true){
           System.out.println("Nhap lua chon: ");
           int x = sc.nextInt();
           sc.nextLine();
           switch (x){
               case 1:
                   insertNews(N);
                   break;
               case 2:
                   show1(N);
                   break;
               case 3:
                   show2(N);
                   break;
               case 4:
                   System.out.println("End!");
                   return;

               default:
                   System.out.println("Invalid option!");
           }
       }
    }

    public ArrayList<News> insertNews(ArrayList<News> N){
        System.out.print("Nhap title: ");
        news.setTitle(sc.nextLine());
        System.out.print("Nhap publishDate: ");
        news.setPushlishDate(sc.nextLine());
        System.out.print("Nhap author: ");
        news.setAuthor(sc.nextLine());
        System.out.print("Nhap content: ");
        news.setContent(sc.nextLine());
        for(int i=0;i<3;i++){
            System.out.print("Nhap arrageRate [" + i + "]: ");
            news.setAverageRate(sc.nextFloat());
            news.rateList.add((int) news.getAverageRate());
        }
        N.add(news);
        return N;
    }


    public void show1(ArrayList<News> N){
        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Title", "Date", "Author", "Content", "averageRate");
        for(News x:N){
            x.display();
        }
    }

    public void show2(ArrayList<News> N){
        for(News x:N){
            x.Calculate();
        }

        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Title", "Date", "Author", "Content", "averageRate");
        for(News x:N){
            x.display();
        }
    }

}
