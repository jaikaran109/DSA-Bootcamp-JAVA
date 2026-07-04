class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int low = 0 ;
        int high = nums.length - 1;
        while(low < high){
            int mid = ( high - low ) / 2 + low;
            if(nums[high] < nums[mid]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return nums[low];
    }
}



// class Solution {
//     public int findMin(int[] nums) {
//         int min = nums[0];
//         for(int i = 0 ; i < nums.length ; i++){
//             if(min > nums[i]) min = nums[i];
//         }
//         return min;
//     }
// }
