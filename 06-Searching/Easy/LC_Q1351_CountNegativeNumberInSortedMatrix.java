class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            int left = 0;
            int right = grid[i].length - 1;
            int firstNeg = grid[i].length;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (grid[i][mid] < 0) {
                    firstNeg = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            count += grid[i].length - firstNeg;
        }

        return count;
    }
}




// class Solution {
//     public int countNegatives(int[][] grid) {
//         int count = 0;
//         for(int i = 0; i < grid.length; i++) {
//             for(int j = 0; j < grid[i].length; j++) {
//                 if(grid[i][j] < 0) {
//                     count += grid[i].length - j;
//                     break;
//                 }
//             }
//         }       
//         return count;
//     }
// }