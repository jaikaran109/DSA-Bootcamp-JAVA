class Solution {
    public int numberOfSteps(int num) {
        return count(num,0);
    }

    static int count(int n , int ans){
        if(n == 0) return ans;
        if(n % 2 == 0) return count(n/2,ans+1);
        return count(n-1,ans+1);
    }
}
