// Brute Force Approach - TC = O(n^2)
// Don't Submit on LeetCode


class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int n = points.length;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n && Math.abs(points[i][0] - points[j][0]) <= k; j++) {
                int sum = points[i][1] + points[j][1] + Math.abs(points[i][0] - points[j][0]);
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}
