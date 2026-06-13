class Solution {
    public int diagonalSum(int[][] mat) {
        int i = 0 , j = mat.length - 1;
        int sum = 0;
        for(int k = 0 ; k < mat.length ; k++){
            sum = sum + mat[k][i] + mat[k][j];
            if(i == j) sum -= mat[i][j];
            i++;
            j--;
        }
        return sum;
    }
}
