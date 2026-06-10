class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int temp = 0;
        for(int i = 0 ; i < gain.length ; i++){
            temp += gain[i];
            ans = Math.max(ans,temp);
        }
        return ans;
    }
}
