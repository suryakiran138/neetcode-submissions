class Solution {
    private static final int INF = Integer.MAX_VALUE;
    private int ROWS,COLS;
    Queue<int[]> q = new LinkedList<>();
    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length; COLS = grid[0].length;
        for(int i=0; i<ROWS; i++){
            for(int j=0;j<COLS;j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i,j});
                }
            }
        }
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int[] node = q.poll();
            for(int[] dir: dirs){
                int x = node[0]+dir[0], y = node[1]+dir[1];
                if(x<0 || y<0 || x>=ROWS || y>=COLS ||
                    grid[x][y]!=INF) continue;
                q.add(new int[]{x,y});
                grid[x][y] = grid[node[0]][node[1]] + 1;
            }
        }
    }

}
