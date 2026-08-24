import java.util.*;
public class sumOfDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(sum(n,0));
    }

    static int sum(int n , int sum){
        if(n == 0) return sum;
        sum += n % 10;
        return sum(n/10,sum);
    }
}
