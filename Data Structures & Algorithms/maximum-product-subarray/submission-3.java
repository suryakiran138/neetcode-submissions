class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin=1,curMax=1;

        for(int num: nums){
            int tmp = curMin*num;
            curMin = Math.min(num, Math.min(curMin*num,curMax*num));
            curMax = Math.max(num, Math.max(tmp, num*curMax));
            res = Math.max(res,curMax);
        }
        return res;
    }
}
