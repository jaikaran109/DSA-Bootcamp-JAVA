// Dekho discription hmko bhi nhi samjh aaya tm usko chatGTP kr lo


class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;

        for (int x = 1; x <= n; x++) {
            int count = 0;

            for (int num : nums) {
                if (num >= x) count++;
            }

            if (count == x) return x;
        }

        return -1;
    }
}



// class Solution {
//     public int specialArray(int[] nums) {
//         for(int i = 0 ; i < nums.length ; i++){
//             int x = i + 1;
//             int j = 0;
//             int count = 0;
//             while(j < nums.length){
//                 if(nums[j] >= x){
//                     count++;
//                 }
//                 j++;
//             }
//             if(count == x) return count;
//         }
//         return -1;   
//     }
// }
