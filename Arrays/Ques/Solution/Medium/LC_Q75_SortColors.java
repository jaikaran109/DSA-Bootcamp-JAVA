class Solution {
    public void sortColors(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        int low = 0 , high = nums.length - 1;
        for(int num : nums){
            if(num == 0) {
                res[low] = 0;
                low++;
            }else if(num == 2){
                res[high] = 2;
                high--;
            }
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(res[i] == -1) res[i] = 1;
        }

        for(int i = 0 ; i < nums.length ; i++){
            nums[i] = res[i];
        }
    }
}
