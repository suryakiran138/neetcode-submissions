class Solution {

    private record Triple(Integer x,Integer y,Integer distance){}

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Triple> pq = new PriorityQueue<>((a,b)-> b.distance()-a.distance());
        for(int[] point: points){
            int x = point[0],y = point[1];
            pq.offer(new Triple(x, y, x*x+y*y));
            if(pq.size()>k) pq.poll();
        }
        int[][] res = new int[k][2];
        for(int i=0;i<k;i++){
            Triple t = pq.poll();
            res[i][0] = t.x();
            res[i][1] = t.y();
        }
        return res;
    }
}
