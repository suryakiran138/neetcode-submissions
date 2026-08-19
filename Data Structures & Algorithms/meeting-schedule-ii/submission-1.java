/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size()==0) return 0;
        intervals.sort((a,b)->a.start-b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<intervals.size();i++){
            if(!pq.isEmpty() && pq.peek()<=intervals.get(i).start){
                pq.poll();
            }
            pq.offer(intervals.get(i).end);
        }
        return pq.size();
    }
}
