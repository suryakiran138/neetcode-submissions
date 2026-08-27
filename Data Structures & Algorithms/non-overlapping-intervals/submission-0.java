class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] first = intervals[0];
        int res = 0;
        for(int i=1;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start<first[1]){
                res++;
                first[0] = start;
                first[1] = Math.min(first[1],end);
            }else{
                first = intervals[i];
            }
        }
        return res;
    }
}
