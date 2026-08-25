// GFG
class Solution {
    
    static boolean check(int[] nums,int idx){
        if(idx == nums.length - 1) return true;
        if(nums[idx] > nums[idx+1]) return false;
        return check(nums,idx+1);
    }
    
    public boolean isSorted(int[] arr) {
        return check(arr,0);
    }
}
