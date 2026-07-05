class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int pile:piles){
            high=Math.max(high,pile);
        }
        int ans=high;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canEat(piles,mid,h)){
                ans = mid ; 
                high = mid - 1 ;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean canEat(int[] piles , int mid , int h){
        long hour=0;
        for(int pile:piles){
            hour+=(pile+mid-1)/mid;
        }
        return hour<=h;
    }
}



// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
        
//         int max = 0;
//         for(int num : piles){
//             max = Math.max(max,num);
//         }

//         for (int speed = 1; speed <= max; speed++) {
//             int hours = 0;

//             for (int pile : piles) {
//                 hours += Math.ceil((double) pile / speed);
//             }

//             if (hours <= h) {
//                 return speed;
//             }
//         }

//         return max;
//     }
// }
