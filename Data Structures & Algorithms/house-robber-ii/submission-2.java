class Solution {
    int[][] cache;

    public int rob(int[] nums) {
        cache = new int[nums.length][2];
        for(int i=0;i<nums.length;i++) {
            cache[i][0] = -1;
            cache[i][1] = -1;
        }
        if(nums.length==1) return nums[0];
        return Math.max(getCost(0,0,nums),getCost(1,1,nums)); 
    }

    private int getCost(int i,int flag, int[] nums){
        if(i>=nums.length) return 0;
        else if(i==nums.length-1 && flag==0) return 0;
        else if(cache[i][flag]!=-1) return cache[i][flag];
        else return cache[i][flag] = Math.max(getCost(i+1,flag,nums), nums[i]+getCost(i+2,flag,nums));
    }
}
