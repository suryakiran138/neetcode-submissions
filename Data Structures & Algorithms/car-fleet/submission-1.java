class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int fleets = 1;
        List<Pair> list = new ArrayList<>(position.length);
        for(int i=0;i<position.length;i++){
            list.add(new Pair(position[i],speed[i]));
        }
        list.sort((a,b)->Double.compare(b.position,a.position));
        int start = 1;
        Pair p = list.get(0);
        while(start<position.length){
            Pair q = list.get(start);
            //calculate the time taken for last car to reach target
            double time = (target-p.position)/p.speed;
            //System.out.println("start: "+start);
            //find out if previous car can catch
            if(q.speed>p.speed){
                double prevTime = (p.position-q.position)/(q.speed-p.speed);
                //System.out.println("time: "+time+" prevTime: "+prevTime);
                if(prevTime<=time) {
                    p.position = q.position+(q.speed-p.speed)*prevTime;
                } else {
                    fleets++;
                    p = q;
                }
            }
            else {
                fleets++;
                p = q;
            }
            start++;
        }
        return fleets;
    }

    class Pair {
        double position;
        int speed;
        Pair(double position,int speed){
            this.position = position;
            this.speed = speed;
        }
    }
}
