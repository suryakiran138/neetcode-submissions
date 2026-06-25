class Solution {
    public int findMin(int[] nums) {
        int low=0, high=nums.length-1, res= 1001;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[low]<=nums[mid]){
                res = Math.min(res,nums[low]);
                low = mid+1;
            }else {
                res = Math.min(res,nums[mid]);
                high = mid-1;
            }
        }
        return res;
    }
}
