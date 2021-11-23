package B2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    ArrayList<Book> A = new ArrayList<>();

    public void addBook(){
        System.out.println("Nhap thong tin bokk can them: ");
        Book B = new Book();
        System.out.print("Nhap id book: " );
        B.setId(sc.nextLine());
        System.out.print("Nhap name book: ");
        B.setName(sc.nextLine());
        System.out.print("Nhap publisher: ");
        B.setPublisher(sc.nextLine());
        System.out.print("Nhap gia: ");
        B.setPrice(sc.nextFloat());
        System.out.print("Nhap so trang sach: ");
        B.setNumberOfPageAuthor(sc.nextInt());
        sc.nextLine();
        A.add(B);
    }

    public void editBook(int id){
        System.out.print("Sua id book: ");
        A.get(id).setId(sc.nextLine());
        System.out.print("Sua ten book: ");
        A.get(id).setName(sc.nextLine());
        System.out.print("Sua publisher: ");
        A.get(id).setPublisher(sc.nextLine());
        System.out.print("Sua gia: ");
        A.get(id).setPrice(sc.nextFloat());
    }

    public void deletebook(int id){
        A.remove(id);
    }

    public void nameBook(){
        A.sort((Book b1, Book b2) -> {
                return b1.getName().compareTo(b2.getName());
        } );
    }

    public void priceBook(){
        Collections.sort(A, new Comparator<Book>(){
            @Override
            public int compare(Book b1, Book b2){
                return (b1.getPrice() < b2.getPrice() ? 1:-1);
            }
        });

        /*int n = A.size();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(A.get(i).getPrice() < A.get(j).getPrice()){
                    Collections.swap(A,i,j);
                }
            }
        }*/
    }

    public void ShowAllBook(){
        System.out.printf("%-20s %-20s %-20s %-20s %-20s \n", "id", "Name", "Publisher", "Price", "NumberPage");
        for(int i=0;i<A.size();i++){
            System.out.printf("%-20s %-20s %-20s %-20.2f %-20s \n", A.get(i).getId(), A.get(i).getName(), A.get(i).getPublisher(), A.get(i).getPrice(), A.get(i).getNumberOfPageAuthor());
        }
    }
}
