package B2;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu M = new Menu();

        System.out.println("Hay chon 1 trong cac lua chon sau: ");
        System.out.println("1. Tao thong tin book");
        System.out.println("2. Sua thong tin book");
        System.out.println("3. Xoa thong tin book");
        System.out.println("4. Sap xep cac books theo ten (tang dan theo Alphabets)");
        System.out.println("5. Sap xep cac books theo gia (giam dan");
        System.out.println("6. Show all books");
        System.out.println("7. Exit");
        System.out.println("*Note: Moi bat dau ban nen chon 1");
        while (true){
            int x;
            System.out.print("Nhap lưa chon: ");
            x = sc.nextInt();
            switch (x){
                case 1:{
                    M.addBook();
                    break;
                }
                case 2:{
                    System.out.print("Nhap vi tri book muon sua: ");
                    int id;
                    id = sc.nextInt();
                    System.out.println("- Chon 1 de sua id book");
                    System.out.println("- Chon 2 de sua name book");
                    System.out.println("- Chon 3 de sua publisher book");
                    System.out.println("- Chon 4 de sua price book");
                    System.out.println("- Chon 5 de sua number page");
                    System.out.println("- Chon 6 se sua all books");
                    System.out.print("=> Hay ghi lua chon cua ban o day: ");

                    int y;
                    y = sc.nextInt();
                    switch (y){
                        case 1:{
                            sc.nextLine();
                            System.out.print("Id book sua thanh: ");
                            M.A.get(id-1).setId(sc.nextLine());
                            break;
                        }
                        case 2:{
                            sc.nextLine();
                            System.out.print("Name book sua thanh: ");
                            M.A.get(id-1).setName(sc.nextLine());
                            break;
                        }
                        case 3:{
                            sc.nextLine();
                            System.out.print("Publisher sua thanh: ");
                            M.A.get(id-1).setPublisher(sc.nextLine());
                            break;
                        }
                        case 4:{
                            System.out.print("Price sua thanh: ");
                            M.A.get(id-1).setPrice(sc.nextFloat());
                            break;
                        }
                        case 5:{
                            sc.nextLine();
                            System.out.print("Number page sua thanh: ");
                            M.A.get(id-1).setNumberOfPageAuthor(sc.nextInt());
                            break;
                        }
                        case 6:{
                            M.editBook(id-1);
                            break;
                        }
                    }
                    break;
                }
                case 3:{
                    System.out.print("Nhap vi tri book muon xoa: ");
                    int id;
                    id = sc.nextInt();
                    M.deletebook(id-1);
                    break;
                }
                case 4:{
                    M.nameBook();
                    break;
                }
                case 5:{
                    M.priceBook();
                    break;
                }
                case 6:{
                    System.out.println("Danh sach book: ");
                    M.ShowAllBook();
                    break;
                }
                case 7:{
                    System.out.println("EXIT!!");
                    return;
                }
                default:
                    System.out.println("Nhap lai!!");
            }
        }
    };
}
