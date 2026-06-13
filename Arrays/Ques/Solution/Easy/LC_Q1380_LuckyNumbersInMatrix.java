class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < matrix.length ; i++){
            int minCol = 0;
            for(int c = 1 ; c < matrix[0].length ; c++){
                if(matrix[i][c] < matrix[i][minCol]){           // min in Row - index
                    minCol = c;
                }
            }

            int val = matrix[i][minCol];                        // min in Row - value
            boolean flag = true;

            for(int r = 0 ; r < matrix.length ; r++){
                if(matrix[r][minCol] > val){                    // max in Column
                    flag = false;
                    break;
                }
            }
            if(flag) ans.add(val);
        }
        return ans;
    }
}
