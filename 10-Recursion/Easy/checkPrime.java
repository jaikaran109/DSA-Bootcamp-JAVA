import java.util.*;
public class checkPrime {

    static boolean prime(int n , int i){
        if(n == i) return true;
        if(n % i == 0) return false;
        return prime(n,i+1);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(prime(n,2));

    }
}
