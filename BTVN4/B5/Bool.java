package B5;

public class Bool {
    boolean isPrime(int n){
        for(int i=2; i*i<=n; i++){
            if(n%i == 0) return false;
        }
        return n>1;
    }

    boolean isPrime(long n){
        for(int i=2; i*i<=n; i++){
            if(n%i == 0) return false;
        }
        return n>1;
    }

    boolean isPrime(float n){
        return false;
    }

    boolean isPrime(double n){
        return false;
    }
}
