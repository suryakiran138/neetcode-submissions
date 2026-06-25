class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        int longest = 1;
        int l=0,r=1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while(r<s.length() && l<=r){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            r++;
            longest = Math.max(longest,set.size());
        }
        return longest;
    }
}
