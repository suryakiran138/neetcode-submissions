class Solution {
    public int lengthOfLIS(int[] nums) {
        Map<List<Integer>,Integer> dp = new HashMap<>();
        return dfs(nums,0,-1,dp);
    }

    private int dfs(int[] nums,int i,int j,Map<List<Integer>,Integer> dp){
        if(i==nums.length) return 0;
        if(dp.containsKey(List.of(i,j))) return dp.get(List.of(i,j));
        //without taking i
        int max1 = dfs(nums,i+1,j,dp);
        //with taking i
        int max2 = 0;
        if(j==-1 || nums[i]>nums[j]){
            max2 = 1 + dfs(nums,i+1,i,dp);
        }
        int res = Math.max(max1,max2);
        dp.put(List.of(i,j), res);
        return res;
    }
}
