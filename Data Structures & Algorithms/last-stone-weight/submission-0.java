class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }

        while(pq.size()>1){
            int first = pq.poll();
            int secound = pq.poll();
            if(first!=secound) pq.offer(first-secound);
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}
