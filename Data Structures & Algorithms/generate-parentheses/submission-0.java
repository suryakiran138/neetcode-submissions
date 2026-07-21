class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n,"",0,0,res);
        return res;
    }

    private void backtrack(int n,String sub,int open,int close,List<String> res){
        if(sub.length()==2*n){
            res.add(sub);
            return;
        }
        // add (
        if(open<n) backtrack(n,sub+"(",open+1,close,res);
        // add )
        if(close<n && close<open) backtrack(n,sub+")",open,close+1,res);
    }
}
