package B2;

import java.util.ArrayList;
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

}
