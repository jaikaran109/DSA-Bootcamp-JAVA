class Solution {
    public int arrangeCoins(int n) {

        long low = 1;
        long high = n;
        int ans = 0;

        while (low <= high) {

            long mid = low + (high - low) / 2;  

            long coins = mid * (mid + 1) / 2;   // formula - for k point - k * (k + 1) / 2 coins are needed

            if (coins <= n) {
                ans = (int) mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
// TC - O(Logn)





// class Solution {
//     public int arrangeCoins(int n) {
//         for(int i = 1 ; ; i++){         //  i < n  here n is decreasing soo if you put this then u'll always get 0
//             if(n < i) return (i - 1);
//             n -= i;
//         }
//     }
// }

// TC - O(n)