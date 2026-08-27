class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int n=intervals.length,i=1;
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for(int[] interval: intervals){
            int start = interval[0];
            int end = interval[1];
            int lastEnd = res.get(res.size()-1)[1];
            if(start<=lastEnd){
                res.get(res.size()-1)[1] = Math.max(end,lastEnd);
            }else {
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][]);

    }
}
