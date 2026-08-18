class Solution {
    int len;
    int[] cache;
    public int rob(int[] nums) {
        len = nums.length;
        cache = new int[len];
        if(len==1) return nums[0];
        for(int i=0;i<len;i++) cache[i] = -1;
        return Math.max(getCost(0,nums),getCost(1,nums));
    }

    private int getCost(int i,int[] nums){
        if(i>=len) return 0;
        else if(cache[i]!=-1) return cache[i];
        return cache[i] = nums[i] + Math.max(getCost(i+2,nums),getCost(i+3,nums));
    }

    
}
