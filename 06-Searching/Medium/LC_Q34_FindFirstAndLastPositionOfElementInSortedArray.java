// Binary Search
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int low = 0, high = nums.length - 1;

        int[] ans = {-1, -1};

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                ans[0] = mid;
                high = mid - 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        low = 0;
        high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                ans[1] = mid;
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}




// Two Pointer
// class Solution {
//     public int[] searchRange(int[] nums, int target) {

//         int i = 0, j = nums.length - 1;

//         int[] ans = {-1, -1};

//         while (i <= j) {

//             if (ans[0] == -1) {
//                 if (nums[i] == target) {
//                     ans[0] = i;
//                 } else {
//                     i++;
//                 }
//             }

//             if (ans[1] == -1) {
//                 if (nums[j] == target) {
//                     ans[1] = j;
//                 } else {
//                     j--;
//                 }
//             }

//             if (ans[0] != -1 && ans[1] != -1) {
//                 break;
//             }
//         }

//         return ans;
//     }
// }





// Linear
// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         if (nums.length == 0) {
//             return new int[]{-1, -1};
//         }

//         if (nums.length == 1 && nums[0] == target) {
//             return new int[]{0, 0};
//         }

//         int start = -1;
//         int end = -1;

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == target) {
//                 if (start == -1) {
//                     start = i;
//                 }
//                 end = i;
//             }
//         }

//         return new int[]{start, end};
//     }
// }
