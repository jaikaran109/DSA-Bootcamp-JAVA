// Backtrack

class Solution {

    int helper(int[] nums , int idx , int target,int sum ){
        if(idx >= nums.length){
            if(sum == target)   return 1;
            return 0;
        }
        
        int a = helper(nums,idx+1,target,sum + nums[idx]);
        int b = helper(nums,idx+1,target,sum - nums[idx]);
        
        return a+b;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,0,target,0);
    }
}
