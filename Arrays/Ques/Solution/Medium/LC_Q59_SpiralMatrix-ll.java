class Solution {
    public int[][] generateMatrix(int n) {
        int element = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int[][] ans = new int[n][n];
        while(top <= bottom && left <= right){
            for(int i = left ; i <= right ; i++){
                ans[top][i] = element++;
            }
            top++;
            for(int j = top ; j <= bottom ; j++){
                ans[j][right] = element++;
            }
            right--;

            if(top <= bottom){
                for(int j = right ; j >= left ; j--){
                    ans[bottom][j] = element++;
                }
                bottom--;
            }

            if(left <= right){
                for(int i = bottom ; i >= top ; i--){
                    ans[i][left] = element++;
                }
                left++;
            }
            
            
        }
        return ans;
    }
}
