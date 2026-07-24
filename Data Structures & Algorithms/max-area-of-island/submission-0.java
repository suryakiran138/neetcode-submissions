class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int[] area = new int[1];
                    dfs(grid,i,j,area);
                    res = Math.max(area[0],res);
                }
            }
        }
        return res;
    }

    void dfs(int[][] grid, int row,int col,int[] area){
        grid[row][col] = 0;
        area[0]++;
        if(col-1>=0 && grid[row][col-1]==1)dfs(grid,row,col-1,area);
        if(col+1<grid[0].length && grid[row][col+1]==1)dfs(grid,row,col+1,area);
        if(row-1>=0 && grid[row-1][col]==1)dfs(grid,row-1,col,area);
        if(row+1<grid.length && grid[row+1][col]==1)dfs(grid,row+1,col,area);
    }
}
