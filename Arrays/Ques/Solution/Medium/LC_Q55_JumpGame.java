class Solution {
    public boolean canJump(int[] nums) {
        int steps = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            if(steps <= 0) return false;
            steps--;
            steps = Math.max(steps,nums[i]);
        }
        return true;
    }
}



// class Solution {
//     public boolean canJump(int[] nums) {

//         if(nums.length == 1) return true;

//         int steps = nums.length - 1;
//         int have = nums[0];

//         for(int i = 1; i < nums.length; i++) {

//             if(have >= steps) return true;

//             have--;

//             if(have < 0) return false;

//             if(nums[i] > have) {
//                 have = nums[i];
//             }

//             steps--;
//         }

//         return true;
//     }
// }
