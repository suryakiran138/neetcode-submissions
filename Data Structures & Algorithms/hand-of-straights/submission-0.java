class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> freq = new TreeMap<>();
        for(int num: hand){
            if(freq.containsKey(num)){
                freq.put(num,freq.get(num)+1);
            }else freq.put(num,1);
        }

        while(!freq.isEmpty()){
            Integer first = freq.firstKey();
            decrement(freq,first);
            for(int i=first+1;i<first+groupSize;i++){
                if(freq.containsKey(i)){
                    decrement(freq,i);
                } else return false;
            }
        }

        return true;


    }

    private void decrement(Map<Integer,Integer> freq,Integer key){
        int value = freq.get(key);
        if(value==1) freq.remove(key);
        else freq.put(key,value-1);
    }
}
