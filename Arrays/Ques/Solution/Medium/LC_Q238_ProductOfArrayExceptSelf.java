class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];

        pre[0] = nums[0];
        post[nums.length - 1] = nums[nums.length - 1];
        for(int i = 1 ; i < nums.length ; i++){
            pre[i] = nums[i] * pre[i - 1];
            post[nums.length - i - 1] = nums[nums.length - i - 1] * post[nums.length - i];
        }

        for(int i = 1 ; i < nums.length - 1; i++){
            nums[i] = pre[i - 1] * post[i + 1];
        }

        nums[0] = post[1];
        nums[nums.length - 1] = pre[nums.length - 2];
        
        return nums;
    }
}
