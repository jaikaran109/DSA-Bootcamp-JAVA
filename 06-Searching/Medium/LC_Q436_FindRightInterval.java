class Solution {
    public int[] findRightInterval(int[][] inter) {

        int[] ans = new int[inter.length];

        Arrays.fill(ans,-1);
        for(int i = 0 ; i < inter.length ; i++){
            int end = inter[i][1];
            int min = Integer.MAX_VALUE;
            for(int j = 0 ; j < inter.length ; j++){
                if(end <= inter[j][0]) {
                    if(min > (inter[j][0] - end)){
                        ans[i] = j;
                        min = inter[j][0] - end;
                    }
                }
            }
        }
        return ans;
    }
}
