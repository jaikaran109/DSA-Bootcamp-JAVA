class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int len = image.length;
        int[][] ans = new int[len][len];
        for(int i = 0 ; i < len ; i++){
            for(int j = 0 ; j < len ; j++){
                ans[i][len - 1 - j] = image[i][j];
            }
        }

        
        for(int i = 0 ; i < len ; i++){
            for(int j = 0 ; j < len ; j++){
                if(ans[i][j] == 1){
                    ans[i][j] = 0;
                }else{
                    ans[i][j] = 1;
                }
            }
        }
        return ans;
    }
}
