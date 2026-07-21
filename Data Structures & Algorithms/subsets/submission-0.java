class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,0,new ArrayList<>(), res);
        return res;
    }

    void helper(int[] nums,int index, List<Integer> list, List<List<Integer>> res){
        if(index==nums.length){
            res.add(list);
        } else {
            //dont take i
            helper(nums,index+1, new ArrayList<>(list),res);
            //take i
            list.add(nums[index]);
            helper(nums,index+1, list,res);            
        }
    }
}
