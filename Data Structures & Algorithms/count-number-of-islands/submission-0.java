class Solution {
    public int numIslands(char[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    void dfs(char[][] grid, int row,int col){
        grid[row][col] = '0';
        if(col-1>=0 && grid[row][col-1]=='1')dfs(grid,row,col-1);
        if(col+1<grid[0].length && grid[row][col+1]=='1')dfs(grid,row,col+1);
        if(row-1>=0 && grid[row-1][col]=='1')dfs(grid,row-1,col);
        if(row+1<grid.length && grid[row+1][col]=='1')dfs(grid,row+1,col);
    }
}
