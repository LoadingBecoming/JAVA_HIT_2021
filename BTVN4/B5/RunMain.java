package B5;

public class RunMain {
    public static void main(String[] args) {
        Bool Bool = new Bool();

        System.out.println("Kieu int: _____________");
        if(Bool.isPrime(2)) System.out.println("2 is Prime!");
        else System.out.println("2 is'n Prime!");
        if(Bool.isPrime(4)) System.out.println("4 is Prime!");
        else System.out.println("4 is'n Prime!");

        System.out.println("Kieu long: _____________");
        if(Bool.isPrime(53L)) System.out.println("53 is Prime!");
        else System.out.println("53 is'n Prime!");
        if(Bool.isPrime(57L)) System.out.println("57 is Prime!");
        else System.out.println("57 is'n Prime!");

        // 2 kiểu dưới đây sẽ in ra "is'n Prime" vì theo đề với mọi số thực thì boolean = false;
        System.out.println("Kieu float: _____________");
        if(Bool.isPrime(8.0f)) System.out.println("8 is Prime!");
        else System.out.println("8 is'n Prime!");

        System.out.println("Kieu double: _____________");
        if(Bool.isPrime(9.0d)) System.out.println("9 is Prime!");
        else System.out.println("9 is'n Prime!");
    }
}
