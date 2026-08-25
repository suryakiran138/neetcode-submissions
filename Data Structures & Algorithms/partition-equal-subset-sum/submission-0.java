class Solution {

    Map<List<Integer>, Boolean> dp = new HashMap<>();

    public boolean canPartition(int[] nums) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        // Odd total can never be divided equally
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;

        return dfs(nums, 0, target);
    }

    private boolean dfs(int[] nums, int i, int target) {

        // Found subset whose sum is total / 2
        if (target == 0) {
            return true;
        }
        if(dp.containsKey(List.of(i,target))) return dp.get(List.of(i,target));

        // No elements left or exceeded target
        if (i == nums.length || target < 0) {
            return false;
        }

        // Do not take nums[i]
        boolean res1 = dfs(nums, i + 1, target);

        // Take nums[i]
        boolean res2 = dfs(nums, i + 1, target - nums[i]);

        dp.put(List.of(i,target),res1||res2);

        return  res1 || res2;
    }
}