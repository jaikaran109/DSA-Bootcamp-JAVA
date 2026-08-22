// GFG

class Solution {
    public ArrayList<Integer> getMinMax(int[] arr) {
        int max = -1;
        int min = Integer.MAX_VALUE;
        
        return helper(arr,min,max,0);
    }
    static ArrayList<Integer> helper(int[] nums , int min , int max , int idx){
        if(idx == nums.length){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(min);
            ans.add(max);

            return ans;
        }
        if(nums[idx] > max) max = nums[idx];
        if(nums[idx] < min) min = nums[idx];
        return helper(nums,min,max,idx+1);
    }
}
