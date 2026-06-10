class Solution {
    public int oddCells(int m, int n, int[][] indices) {

        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int[] idx : indices) {
            rows[idx[0]]++;
            cols[idx[1]]++;
        }

        int odd = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((rows[i] + cols[j]) % 2 != 0) {
                    odd++;
                }
            }
        }

        return odd;
    }
}
