class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(0,new ArrayList<>(),nums,visited,perms);
        return perms;
    }

    private void backtrack(int index,List<Integer> list, int[] nums,boolean[] visited,List<List<Integer>> perms){
        if(index==nums.length){
            perms.add(new ArrayList<>(list));
        } else {
            for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                list.add(nums[i]);
                visited[i] = true;
                backtrack(index+1, list, nums, visited, perms);
                list.remove(list.size()-1);
                visited[i] = false;
            }
            }
        }


    }
}
