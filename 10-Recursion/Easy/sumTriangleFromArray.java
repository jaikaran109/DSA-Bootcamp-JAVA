import java.util.*;
public class sumTriangleFromArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i = 0 ; i < size ; i++){
            arr[i] = input.nextInt();
        }

        printTriangle(arr);
    }
    static void printTriangle(int[] nums){
        if(nums.length == 1){
            System.out.println(Arrays.toString(nums));
            return;
        }

        int[] temp = new int[nums.length - 1];

        helper(temp,nums,0);

        printTriangle(temp);

        System.out.println(Arrays.toString(nums));
    }

    static int[] helper(int[] temp , int[] nums , int idx){

        if(idx == temp.length){
            return temp;
        }

        temp[idx] = nums[idx] + nums[idx + 1];

        return helper(temp,nums,idx+1);
    }
}
