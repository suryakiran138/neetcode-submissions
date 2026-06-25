class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(!map.containsKey(num)){
                map.put(target-num,i);
            } else {
                return new int[]{map.get(num),i};
            }
        }
        return new int[]{};
    }
}
