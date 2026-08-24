class Solution {
    Map<Integer,Integer> dp = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        int minCoins = dfs(amount,coins);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private int dfs(int amount,int[] coins){
        if(dp.get(amount)!=null) return dp.get(amount);
        if(amount==0) return 0;
        int count = Integer.MAX_VALUE;
        for(int coin: coins){
            int rem = amount-coin;
            if(rem>=0){
                int value = dfs(rem,coins);
                if(value!=Integer.MAX_VALUE)count = Math.min(count,1+value);
            }
        }
        dp.put(amount,count);
        return count;
    }

    
}
