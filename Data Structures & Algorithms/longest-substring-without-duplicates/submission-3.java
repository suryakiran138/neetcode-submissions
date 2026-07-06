class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0;
        Set<Character> set = new HashSet<>();
        int res=0;
        while(r<s.length()){
            if(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            } else {
                set.add(s.charAt(r));
                res = Math.max(res,set.size());
                r++;
            }
        }
        return res;
    }
}
