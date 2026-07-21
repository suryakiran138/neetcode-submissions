class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,0,0,new ArrayList<Integer>(),res);
        return res;
    }

    private void dfs(int[] nums,int target,int index,int sum,
    List<Integer> subset,List<List<Integer>> res) {
        if(sum==target) res.add(new ArrayList<>(subset));
        else if(index==nums.length || sum>target){}
        else {
            //take nums[index]
            subset.add(nums[index]);
            dfs(nums,target,index+1,sum+nums[index],subset,res);
            // don't take nums[index]
            int next = index+1;
            while(next!=nums.length && nums[index]==nums[next]){
                index++;
                next++;
            }
            subset.remove(subset.size()-1);
            dfs(nums,target,index+1,sum,subset,res);
        }
    }
}
