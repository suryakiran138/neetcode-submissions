class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.'; 
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(board, 0, res);
        return res;
    }

    void backtrack(char[][] board,int x, List<List<String>> res){
        if(x==board.length){
            List<String> list = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                list.add(new String(board[i]));
            }
            res.add(list);
            return;
        }
        
        for(int y=0; y<board.length; y++){
            if(canPlace(board,x,y)){
                board[x][y] = 'Q';
                backtrack(board,x+1,res);
                board[x][y] = '.';
            }
        }
    }

    boolean canPlace(char[][] board, int row, int col) {

    // Column
    for (int i = 0; i < row; i++) {
        if (board[i][col] == 'Q') {
            return false;
        }
    }

    // Upper-left diagonal
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
        if (board[i][j] == 'Q') {
            return false;
        }
    }

    // Upper-right diagonal
    for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
        if (board[i][j] == 'Q') {
            return false;
        }
    }

    return true;
    }
}
