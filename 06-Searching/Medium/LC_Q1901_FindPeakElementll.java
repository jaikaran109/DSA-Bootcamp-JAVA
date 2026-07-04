// Isme TIME - O(nLogm) - Review

class Solution {
    public int[] findPeakGrid(int[][] nums) {

        int low = 0;
        int high = nums[0].length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int[] colInfo = findPeak(mid, nums);

            int row = colInfo[1];
            int val = colInfo[0];

            int left = (mid - 1 >= 0) ? nums[row][mid - 1] : -1;
            int right = (mid + 1 < nums[0].length) ? nums[row][mid + 1] : -1;

            if (val > left && val > right) {
                return new int[]{row, mid};
            }
            else if (left > val) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }

    private static int[] findPeak(int col, int[][] arr) {

        int max = arr[0][col];
        int index = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i][col] > max) {
                max = arr[i][col];
                index = i;
            }
        }

        return new int[]{max, index};
    }
}



// class Solution {
//     public int[] findPeakGrid(int[][] nums) {
//         int start = 0;
//         int end = 0;
//         int max = 0;
//         for(int i = 0 ; i < nums.length ; i++)   {
//             for(int j = 0 ; j < nums[0].length ; j++){
//                 if(nums[i][j] > max){
//                     start = i;
//                     end = j;
//                     max = nums[i][j];
//                 }
//             }
//         }
//         return new int[]{start,end};
//     }
// }
