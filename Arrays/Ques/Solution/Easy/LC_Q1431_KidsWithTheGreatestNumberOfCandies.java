class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();

        int max = 0;
        for(int candy : candies){
            if(candy > max) max = candy;
        }

        for(int candy : candies){
            if((candy + extraCandies) >= max) res.add(true);
            else res.add(false);
        }
        return res;
    }
}







// Brute Force
// class Solution {
//     public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

//         //  Make a list of Booleans
//         //  form 2 nested Loop 
//         //  compare arr[i] + extra with all arr[j] from 0 to .length

//     }
// }