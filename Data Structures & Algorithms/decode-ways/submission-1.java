class Solution {
    int[] dp;
    public int numDecodings(String s) {
        Map<Integer,Integer> dp = new HashMap<Integer,Integer>();
        return dfs(s,0,dp);
    }

    private int dfs(String s,int i,Map<Integer,Integer> dp) {
        if(dp.get(i)!=null) return dp.get(i);
        if(i==s.length()) return 1;
        if(s.charAt(i)=='0') return 0;
        int res = dfs(s,i+1,dp);
        if(i+1<s.length() && ((s.charAt(i)=='1') || (s.charAt(i)=='2' && s.charAt(i+1)<'7'))){
            res += dfs(s,i+2,dp);
        }
        dp.put(i,res);
        return res;
    }
}
