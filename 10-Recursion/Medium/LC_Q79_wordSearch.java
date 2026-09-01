class Solution {
    boolean dfs(char[][] board , String word , int row , int col , int idx){

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;  // agr row or col invalid ho to mtlb uss col or row pe ans nhi mila , isiliye false return kr do 

        if(board[row][col] != word.charAt(idx)) return false;  // agr kisi point pe match nhi hota h to backtracking ke liye false return kr do

        if(idx == word.length() - 1) return true;  //  iska mtlb h ki word ke sare letter mil gya h


        // jo visit kr liye usko mark kr do
        char temp = board[row][col];
        board[row][col] = '#';


        boolean found = false;

        // sare 4 direction me check krne ke liye
        found = dfs(board,word,row-1,col,idx+1);

        if(!found){
            found = dfs(board,word,row+1,col,idx+1);
        }

        if(!found){
            found = dfs(board,word,row,col-1,idx+1);
        }

        if(!found){
            found = dfs(board,word,row,col+1,idx+1);
        }

        // backtrack krne ke liye
        board[row][col] = temp;
        return found;
    }


    public boolean exist(char[][] board, String word) {
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if (board[i][j] == word.charAt(0)) {

                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }
}
