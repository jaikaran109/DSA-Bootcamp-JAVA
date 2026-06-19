// Not Optimal

class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int num = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0) continue;                       // saare non-positive skip - neg milte hi skip kr dega
            if(i > 0 && nums[i] == nums[i-1]) continue;       // duplicate skip -- ye impo h kyuki [1,1,2,2] hai to yha comparision hoga bina continue kiye to index 1 pe return 2 kr dega jo glt h
            if(num != nums[i]) return num;
            num++;
        }
        return num;
    }
}
