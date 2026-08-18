class Solution {
    int[] cache;


    public int climbStairs(int n) {
        cache = new int[n];
        for(int i=0;i<n;i++){
            cache[i] = -1;
        }
        return backtrack(0,n);
    }

    private int backtrack(int sum,int n){
        if(sum>n) return 0;
        else if(sum==n) return 1;
        else if(cache[sum]!=-1) return cache[sum];
        else return cache[sum] = backtrack(sum+1,n) + backtrack(sum+2,n);
    }
}
