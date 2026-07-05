class Solution {

    class Pair {
        int start;
        int speed;
        Pair(int start,int speed) {
            this.start = start;
            this.speed = speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<len;i++){
            list.add(new Pair(position[i],speed[i]));
        }
        Collections.sort(list, (a,b)-> b.start-a.start);
        int fleets = 1;
        double prevTime = (double)(target-list.get(0).start)/list.get(0).speed;
        for(int i=1;i<len;i++){
            double curTime = (double)(target-list.get(i).start)/list.get(i).speed;
            if(curTime>prevTime){
                fleets++;
                prevTime = curTime;
            }
        }
        return fleets;
    }
}
