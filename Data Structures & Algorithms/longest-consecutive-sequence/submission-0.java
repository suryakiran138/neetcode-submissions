class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int max = 0;
        Iterator<Integer> iterator = set.iterator();
        for(int num: nums){
            if(!set.contains(num-1)){
                int count = 1;
                while(set.contains(num+1)){
                    count++;
                    num++;
                }
            if(count>max) max = count;
            }
        }
        return max;
    }
}
