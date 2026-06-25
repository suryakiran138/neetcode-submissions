class TimeMap {

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).add(new Pair(timestamp, value));
        } else {
            ArrayList<Pair> list = new ArrayList<>();
            list.add(new Pair(timestamp, value));
            map.put(key,list);
        }
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            List<Pair> list = map.get(key);
            int low = 0;
            int high = list.size()-1;
            String res = "";
            while(low<=high){
                int mid = (low+high)/2;
                if(list.get(mid).ts<=timestamp){
                    res = list.get(mid).v;
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
            return res;

        } else return "";
    }

    class Pair {
        int ts;
        String v;
        Pair(int ts, String v){
            this.ts = ts;
            this.v = v;
        }
    }
}
