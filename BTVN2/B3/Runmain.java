package B3;
import java.util.Scanner;

public class Runmain {
    public static boolean so(String s){
        for(int i=0;i<s.length();i++)
            if(s.charAt(i) <= '9' && s.charAt(i) >=0)
                return true;
        return false;
    }
    public static float tong(String s){
        float tong = 0;
        int d = 0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i) <= '9' && s.charAt(i) >=0){
                tong+=(s.charAt(i) - '0');
                d++;
            }
        return tong/d;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi: ");
        String s = sc.nextLine();
        if(so(s)){
            System.out.println("True");
            System.out.println("Tong la: " + tong(s));
        }
        else{
            System.out.println("Flase");
            System.out.println("Tong la: " + 0);
        }
    }
}
