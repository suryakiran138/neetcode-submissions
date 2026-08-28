class Solution {
    public int maxSubArray(int[] nums) {
        int res=nums[0], cur=0;
        for(int num: nums){
            if(cur<0){
                cur = 0;
            }
            cur += num;
            res = Math.max(res,cur);
        }
        return res;
    }
}
