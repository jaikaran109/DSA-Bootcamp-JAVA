class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        reverse(nums , 0 , nums.length - k - 1);
        reverse(nums , nums.length - k , nums.length - 1);
        reverse(nums , 0 , nums.length - 1);
    }

    private int[] reverse(int[] nums,int start ,int end){
        while(start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }    
        return nums;
    }
}




// class Solution {
//     public void rotate(int[] nums, int k) {

//         k %= nums.length;

//         int n = nums.length - k - 1;
//         for(int i = 0 ; i <= n / 2; i++)   {
//             int temp = nums[i];
//             nums[i] = nums[n - i];
//             nums[n - i] = temp;
//         }

//         int start = nums.length - k;
//         int end = nums.length - 1;

//         for(int i = start ; i <= (start + end) / 2 ; i++){
//             int temp = nums[i];
//             nums[i] = nums[end - (i - start)];
//             nums[end - (i - start)] = temp;
//         }

//         for(int i = 0 ; i < nums.length/2; i++){
//             int temp = nums[i];
//             nums[i] = nums[nums.length - i - 1];
//             nums[nums.length - i - 1] = temp;
//         }
//     }
// }
