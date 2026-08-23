import java.util.*;
public class insertionSort {
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
        if(idx <= 1) return;

        sort(nums,idx-1);

        int last = nums[idx - 1];
        int j = idx - 2;

        while(j >= 0 && nums[j] > last){
            nums[j+1] = nums[j];
            j--;
        }
        nums[j+1] = last;
    }
}
