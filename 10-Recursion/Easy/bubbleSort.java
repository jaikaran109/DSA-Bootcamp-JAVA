import java.util.*;
public class bubbleSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[] arr = new int[size];
        for(int i = 0 ; i < size ; i++){
            arr[i] = input.nextInt();
        }
        sort(arr,size);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] nums , int idx){
        if(idx == 1) return ;

        int count = 0;
        for(int i = 0 ; i < idx - 1 ; i++){
            if(nums[i] > nums[i+1]){
                int temp = nums[i];
                nums[i] =  nums[i+1];
                nums[i+1] = temp;
                count++;
            }
        }

        if (count == 0)
            return;

        sort(nums,idx-1);

    }
}
