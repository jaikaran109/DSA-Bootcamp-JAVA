class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i = 0 ; i < 4 ; i++){
            if(isEqual(mat,target)) return true;
            rotate(mat);
        }
        return false;
    }

    private int[][] rotate(int[][] mat){
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = i + 1 ; j < mat[0].length ; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat.length / 2 ; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[i][mat.length - 1 - j] ;
                mat[i][mat.length - 1 - j] = temp;
            }
        }
        return mat;
    }

    private boolean isEqual(int[][] mat , int[][] target){
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                if(mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }
}
