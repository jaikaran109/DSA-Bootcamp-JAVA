class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int num : nums){
            ans += map.getOrDefault(num,0);
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        return ans;
    }
}




// Brute Force
// class Solution {
//     public int numIdenticalPairs(int[] nums) {
//         int count = 0;
//         for(int i = 0 ; i < nums.length ; i++){
//             for(int j = i + 1 ; j < nums.length ; j++){
//                 if(nums[i] == nums[j]) count++;
//             }
//         }
//         return count;
//     }
// }