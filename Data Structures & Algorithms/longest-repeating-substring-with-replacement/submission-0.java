class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0;
        int maxCount = 1;
        int l=0,r=0;
        int[] charFreq = new int[26];
        while(r<s.length()){
           charFreq[s.charAt(r)-'A']++;
           maxCount = Math.max(maxCount, charFreq[s.charAt(r)-'A']); 
           while(r-l+1-maxCount>k){
                charFreq[s.charAt(l)-'A']--;
                l++;
           }
           longest = Math.max(longest, r-l+1);
           r++;
        }
        return longest;
    }
}
