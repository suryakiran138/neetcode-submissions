class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        // checking all rows are valid
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    if(set.contains(board[i][j])) return false;
                    else set.add(board[i][j]);
                }
            }
            set.clear();
        }
        // checking all columns are valid
        for(int j=0;j<board[0].length;j++){
            for(int i=0;i<board.length;i++){
                if(board[i][j]!='.'){
                    if(set.contains(board[i][j])) return false;
                    else set.add(board[i][j]);
                }
            }
            set.clear();
        }
        // checking all squares are valid
        for(int i=0;i<9;i++){
            System.out.print("square: "+i);
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    int row = (i/3)*3+j;
                    int col = (i%3)*3+k;
                    //System.out.println("row: "+row+" col: "+col+" val"+board[row][col]);
                    if(board[row][col]!='.'){
                        if(set.contains(board[row][col])) return false;
                        else set.add(board[row][col]);
                    }
                }
            }
            set.clear();
        }

        return true;
        
    }
}
