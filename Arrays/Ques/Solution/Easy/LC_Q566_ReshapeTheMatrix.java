class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;

        if (m * n != r * c) {
            return mat;
        }

        int[] temp = new int[m * n];

        int idx = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[idx++] = mat[i][j];
            }
        }

        int[][] ans = new int[r][c];

        idx = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = temp[idx++];
            }
        }

        return ans;
    }
}
