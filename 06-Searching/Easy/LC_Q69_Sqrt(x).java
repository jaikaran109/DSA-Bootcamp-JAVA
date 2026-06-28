class Solution {
    public int mySqrt(int x) {
        long low = 0;
        long high = x;
        int ans = 0;

        while(low <= high){

            long mid = low + (high - low) / 2;

            long square = (mid * mid);

            if(square == x)
                return (int)mid;

            else if(square < x){
                ans = (int) mid;
                low = mid + 1;
            }

            else{
                high = mid - 1;
            }
        }   
        return ans;
    }
}

// TC - O(Logn)
// Space - O(1)




// These are not good soln bcz these use sqrt fuction 
// class Solution {
//     public int mySqrt(int x) {
//         return (int)Math.sqrt(x);
//     }
// }


// class Solution {
//     public int mySqrt(int x) {
//         for(int i = 1 ; i <= Math.sqrt(x) ; i++)   {
//             if(i*i == x) return i;
//         }
//         return(int)(Math.sqrt(x));
//     }
// }