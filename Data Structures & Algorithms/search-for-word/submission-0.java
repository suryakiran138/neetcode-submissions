class Solution {
    public boolean exist(char[][] board, String word) {
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[r].length;c++){
                if(dfs(board,word,0,r,c)) return true;
            }
        }
        return false;  
    }

    private boolean dfs(char[][] board, String word,int i,int r,int c){
        int rows = board.length,cols=board[0].length;
        if(i==word.length()) return true;
        if(r<0 || c<0 || r>=rows || c>=cols ||
        board[r][c]=='#' || board[r][c]!=word.charAt(i)){
            return false;
        }
        board[r][c]='#';
        boolean res = dfs(board,word,i+1,r-1,c) ||
        dfs(board,word,i+1,r,c-1) ||
        dfs(board,word,i+1,r+1,c) ||
        dfs(board,word,i+1,r,c+1);
        board[r][c] = word.charAt(i);
        return res;
    }
}
