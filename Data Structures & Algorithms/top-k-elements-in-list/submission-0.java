class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Arrays.sort(nums);
        int[] res = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.freq-a.freq);
        // Building Frequency map
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        } 
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        for(int i=0;i<k;i++){
            res[i] = pq.poll().value;
        }
        return res;

    }

    class Pair {
        int value;
        int freq;
        Pair(int value,int freq){
            this.value = value;
            this.freq = freq;
        }
    }
}
