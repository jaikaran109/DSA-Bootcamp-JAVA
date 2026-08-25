import java.util.*;
public class sumNaturalNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n  = input.nextInt();
        System.out.println(sum(n));
    }
    static int sum(int n){
        if(n == 0) return 0;
        return n + sum(n-1);
    }
}
