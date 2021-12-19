package BT;

import java.util.*;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong nguoi: ");
        long n = sc.nextLong();
        ArrayList<Person> P = new ArrayList<>();
        try {
            sc.nextLine();
            for(int i=0;i<n;i++){
                Person x = new Person();
                System.out.print("Nhap id: ");
                x.setId(sc.nextLine());
                System.out.print("Nhap name: ");
                x.setName(sc.nextLine());
                System.out.print("Nhap address: ");
                x.setAddress(sc.nextLine());
                P.add(x);
            }

            System.out.println("******SORT THEO ID******");
            Collections.sort(P);
            for(Person x:P){
                System.out.println(x.toString());
            }
            System.out.println();

            System.out.println("******SORT THEO NAME*****");
            Collections.sort(P, new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    if(o1.getName().compareTo(o2.getName()) == 0){
                        return o2.getAddress().compareTo(o1.getAddress());
                    }
                    else{
                        return o1.getName().compareTo(o2.getName());
                    }
                }
            });
            for(Person y:P){
                System.out.println(y.toString());
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
