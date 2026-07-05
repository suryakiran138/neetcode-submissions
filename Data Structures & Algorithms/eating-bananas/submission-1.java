class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int i=0;i<piles.length;i++){
            if(piles[i]>max) max = piles[i];
        }
        int low=1, high = max;
        int res = max;
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(piles,h,mid)){
                high = mid-1;
                res = mid;
            } else {
                low = mid+1;
            }
        }
        return res;
    }

    boolean isPossible(int[] piles,int max,int rate){
        int hours = 0;
        for(int pile: piles){
            int time = pile/rate;
            hours += pile%rate==0 ? time : time+1;
            if(hours>max) return false;
        }
        return true;
    }
}
