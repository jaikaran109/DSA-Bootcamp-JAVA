class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int index = 0;
        if(n % 2 != 0) {
            ans[0] = 0;
            index = 1;
        }
        int left = n / 2 , right = n / 2 , zero = 0;
        
        while(left-- > 0){
            ans[index++] = --zero;
        }
        zero = 0;
        while(right-- > 0){
            ans[index++] = ++zero;
        }

        return ans;
    }
}
