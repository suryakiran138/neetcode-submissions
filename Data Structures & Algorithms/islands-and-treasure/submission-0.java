class Solution {
    public void islandsAndTreasure(int[][] grid) {
        //int[][] res = new int[grid.length][grid[0].length];
        List<Integer[]> treasures = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                //res[i][j] = grid[i][j];
                if(grid[i][j]==0) treasures.add(new Integer[]{i,j});
            }
        }

        Queue<Integer[]> queue = new LinkedList<>();
        int INF = Integer.MAX_VALUE;
        queue.addAll(treasures);
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Integer[] point = queue.poll();
                int x = point[0],y=point[1];
                if(y-1>=0 && grid[x][y-1]==INF){
                    grid[x][y-1] = count;
                    queue.add(new Integer[]{x,y-1});
                }
                if(y+1<grid[0].length && grid[x][y+1]==INF){
                    grid[x][y+1] = count;
                    queue.add(new Integer[]{x,y+1});
                }
                if(x-1>=0 && grid[x-1][y]==INF){
                    grid[x-1][y] = count;
                    queue.add(new Integer[]{x-1,y});
                }
                if(x+1<grid.length && grid[x+1][y]==INF){
                    grid[x+1][y] = count;
                    queue.add(new Integer[]{x+1,y});
                }
            }
            count++;
        }

    }
}
