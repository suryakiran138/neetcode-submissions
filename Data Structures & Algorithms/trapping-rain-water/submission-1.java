class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        // populate left array
        int lMax = -1,rMax = -1;
        for(int i=0;i<len;i++){
            if(height[i]>lMax) lMax=height[i];
            left[i] = lMax;
            if(height[len-i-1]>rMax) rMax=height[len-i-1];
            right[len-i-1] = rMax;
        }
        int res = 0;
        for(int i=1;i<len-1;i++){
            int diff = Math.min(left[i-1],right[i+1]) - height[i];
            if(diff>0) res += diff;
        }
        return res;
        
    }
}
