class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1,high=Arrays.stream(piles).max().getAsInt();
        int res = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(isEatingCompleted(piles, mid, h)){
                res = mid;
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return res;
    }

    boolean isEatingCompleted(int[] piles,int speed,int h){
        int res = 0;
        if(speed==0) return false;
        for(int count: piles){
            int div = count/speed;
            res += count%speed==0 ? div : div+1;
            if(res>h) return false;
        }
        return true;
    } 
}
