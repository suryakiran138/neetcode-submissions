class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,target,0,0,new LinkedList<>(),res);
        return res;
    }

    private void dfs(int[] nums,int target,int index,int sum,
    List<Integer> subset, List<List<Integer>> res){
        if(target==sum){
            res.add(new LinkedList<>(subset));
        }else if(target<sum || index==nums.length){
        } else {
            //don't take i
            dfs(nums,target,index+1,sum,subset,res);
            //take i
            List<Integer> newSubSet = new LinkedList<>(subset);
            newSubSet.add(nums[index]);
            dfs(nums,target,index,sum+nums[index],newSubSet,res);
        }
    }
}
