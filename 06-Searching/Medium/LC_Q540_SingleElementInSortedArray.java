// XOR - 0 ke sath koi number = that number and same numbers ek dusre ke saath tb 0 - aise last me ek bach jayega jo single time appear hua hoga
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for(int i : nums) {
            ans ^= i;
        }
        return ans;
    }
}




// HashMap - O(n)
// class Solution {
//     public int singleNonDuplicate(int[] nums) {
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int i = 0 ; i < nums.length ; i++){
//             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//         }

//         for(int i = 0 ; i < nums.length ; i++){
//             if(map.get(nums[i]) == 1) return nums[i];
//         }

//         return -1;
//     }
// }
