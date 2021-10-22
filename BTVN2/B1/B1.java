import java.util.Scanner;

public class B1 {
    public static int soMax(int a, int b, int c){
        return Math.max(Math.max(a,b),c);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b,c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        System.out.println(soMax(a,b,c));
    }
}
