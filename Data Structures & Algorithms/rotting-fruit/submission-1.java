class Solution {
    public int orangesRotting(int[][] grid) {
        List<Integer[]> rottens = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j]==2) rottens.add(new Integer[]{i,j});
            }
        }

        Queue<Integer[]> queue = new LinkedList<>(rottens);
        int res=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                Integer[] arr = queue.poll();
                int x = arr[0],y = arr[1];
                if(x-1>=0 && grid[x-1][y]==1){
                    grid[x-1][y] = 2;
                    fresh--;
                    queue.add(new Integer[]{x-1,y});
                }
                if(x+1<grid.length && grid[x+1][y]==1){
                    grid[x+1][y] = 2;
                    fresh--;
                    queue.add(new Integer[]{x+1,y});
                }
                if(y-1>=0 && grid[x][y-1]==1){
                    grid[x][y-1] = 2;
                    fresh--;
                    queue.add(new Integer[]{x,y-1});
                }
                if(y+1<grid[0].length && grid[x][y+1]==1){
                    grid[x][y+1] = 2;
                    fresh--;
                    queue.add(new Integer[]{x,y+1});
                }
            }
            res++;
        }
        return fresh==0 ? (res>0 ? res-1 : 0) : -1;
    }
}
