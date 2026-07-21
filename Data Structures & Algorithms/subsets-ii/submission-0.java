class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,new ArrayList<>(),res);
        return res;
    }

    private void backtrack(int[] nums,int i,List<Integer> subset,List<List<Integer>> res){
        if(i==nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        //pick i
        subset.add(nums[i]);
        backtrack(nums,i+1,subset,res);
        // remove duplicates
        while(i<nums.length-1 && nums[i]==nums[i+1]) i++;
        //do not pick i
        subset.remove(subset.size()-1);
        backtrack(nums,i+1,subset,res);
    }
}
