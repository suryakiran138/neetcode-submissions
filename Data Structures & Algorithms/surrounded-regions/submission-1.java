class Solution {
    public void solve(char[][] board) {
        // up and down row
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O') dfs(board,new int[]{0,i});
            if(board[board.length-1][i]=='O') dfs(board,new int[]{board.length-1,i});
        }
        // left and right column
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O') dfs(board,new int[]{i,0});
            if(board[i][board[0].length-1]=='O') dfs(board,new int[]{i,board[0].length-1});
        }
        

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='#') board[i][j]='O';
            }
        }
    }

    void dfs(char[][] board, int[] arr){
        int x=arr[0],y=arr[1];
        board[x][y]='#';
        if(x-1>=0 && board[x-1][y]=='O'){
            dfs(board,new int[]{x-1,y});
        }
        if(x+1<board.length && board[x+1][y]=='O'){
            dfs(board,new int[]{x+1,y});
        }
        if(y-1>=0 && board[x][y-1]=='O'){
            dfs(board,new int[]{x,y-1});
        }
        if(y+1<board[0].length && board[x][y+1]=='O'){
            dfs(board,new int[]{x,y+1});
        }
    }
}
