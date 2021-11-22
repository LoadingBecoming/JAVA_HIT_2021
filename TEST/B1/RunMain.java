package B1;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.print("Nhap chuoi: ");
        s = sc.nextLine();
        int sum = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
           if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
               sum += (s.charAt(i)-'0');
           }
        }
        int tich=1;
        for(int i=1;i*i<=sum;i++){
            if(sum%i == 0 && i != (sum/i)){
                tich*=i;
                tich *= (sum/i);
            }
            else if(sum%i == 0 && i == (sum/i)){
                tich*=i;
            }
        }

        System.out.println("Tich: " + tich);
    }
}
