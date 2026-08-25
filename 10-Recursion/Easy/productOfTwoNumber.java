import java.util.*;
public class productOfTwoNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x1 = input.nextInt();
        int x2 = input.nextInt();
        System.out.print(product(x1,x2));
    }

    static int product(int x , int y){
        if(y == 0){
            return 0;
        }
        return  x + product(x,y-1);
    }
}



// Dry Run
// x = 5 , y = 4
// 5 + product(5,3)
// 5 + 5 + product(5,2)
// 5 + 5 + 5 + product(5,1)
// 5 + 5 + 5 + 5 + product(0)
