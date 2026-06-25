class Solution {
    public int[] productExceptSelf(int[] nums) {
        boolean isZeroPresent = false;
        int product = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(isZeroPresent){
                    product = 0;
                } else isZeroPresent=true;
            } else {
                product *= nums[i];
            }
            //System.out.println("i: "+i+" product: "+product);
        }
        int[] res = new int[nums.length];
        if(product==0) return res;
        for(int i=0;i<nums.length;i++){
            if(isZeroPresent){
                if(nums[i]!=0) res[i]=0;
                else res[i] = product;
            } else {
                res[i] = product/nums[i];
            }
        }
        return res;
    }
}  
