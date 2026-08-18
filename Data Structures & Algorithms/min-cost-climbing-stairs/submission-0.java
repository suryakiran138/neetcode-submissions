class Solution {
    int[] cache;
    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length];
        for(int i=0;i<cache.length;i++) cache[i] = -1;
        return Math.min(getCost(0,cost),getCost(1,cost));
    }

    private int getCost(int index,int[] cost){
        if(index>=cost.length) return 0;
        else if(cache[index]!=-1) return cache[index];
        return cache[index] = cost[index]+Math.min(getCost(index+1,cost), getCost(index+2,cost));
    }
}
