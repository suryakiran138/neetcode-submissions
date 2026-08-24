class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        Map<Integer,Boolean> dp = new HashMap<>();
        dp.put(s.length(),true);
        for(String word: wordDict){
            wordSet.add(word);
        }
        return dfs(0,s,wordSet,dp);
    }

    private boolean dfs(int start, String s, Set<String> wordSet,Map<Integer,Boolean> dp){
        if(dp.containsKey(start)) return dp.get(start);
        for(int i=start;i<s.length();i++){
            if(wordSet.contains(s.substring(start,i+1))){
                if(dfs(i+1,s,wordSet,dp)){
                    dp.put(start,true);
                    return true;
                }
            }
        }
        dp.put(start,false);
        return false;
    }
}
