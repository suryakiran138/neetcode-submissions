class Solution {
    int ROWS,COLS;
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        boolean[][] pasVisited = new boolean[ROWS][COLS];
        boolean[][] atlVisited = new boolean[ROWS][COLS];
        for(int i=0;i<COLS;i++){
            dfs(heights,0,i,pasVisited);
        }
        for(int i=0;i<ROWS;i++){
            dfs(heights,i,0,pasVisited);
        }
        for(int i=0;i<ROWS;i++){
            dfs(heights,i,COLS-1,atlVisited);
        }
        for(int i=0;i<COLS;i++){
            dfs(heights,ROWS-1,i,atlVisited);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLS;j++){
                if(pasVisited[i][j] && atlVisited[i][j]){
                    res.add(List.of(i,j));
                }
            }
        }
        return res;

    }

    private void dfs(int[][] heights,int x,int y,boolean[][] visited){
        visited[x][y] = true;
        for(int[] dir: dirs){
            int nx = x+dir[0];
            int ny = y+dir[1];
            if(nx>=0 && ny>=0 && nx<ROWS && ny<COLS &&
            !visited[nx][ny] && heights[nx][ny]>=heights[x][y]){
                dfs(heights, nx, ny, visited);
            }
        }
    }
}
