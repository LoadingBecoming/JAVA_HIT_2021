package b4;
import java.util.Locale;
import java.util.Scanner;

public class Runmain {
    public static void chuanHoaChuoi(String s){
        s = s.trim();
        s = s.replaceAll(" +"," ");
        s = s.replaceAll("[0-9]","");
        s = s.toLowerCase();

        String ans = "";
        String[] s1 = s.split(" ");
        for(String x : s1)
            ans += Character.toUpperCase(x.charAt(0)) + x.substring(1) + " ";
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        chuanHoaChuoi(s);
    }
}
