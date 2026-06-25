class Solution {
    public boolean checkInclusion(String s1, String s2) {
        String temp = s1;
        s1=s2;
        s2=temp;
        if(s1.length()<s2.length()) return false;
        int[] s2Freq = new int[26];
        for(char c: s2.toCharArray()){
            s2Freq[c-'a']++;
        }
        int[] s1Freq = new int[26];
        for(int i=0;i<s2.length();i++){
            s1Freq[s1.charAt(i)-'a']++;
        }
        if(Arrays.equals(s1Freq,s2Freq)) return true;
        int l=1,r=s2.length();
        while(r<s1.length()){
            //System.out.println(" l: "+l+" r: "+r);
            s1Freq[s1.charAt(l-1)-'a']--;
            s1Freq[s1.charAt(r)-'a']++;
            if(Arrays.equals(s1Freq,s2Freq)) return true;
            l++;r++;
        }

        return false;

    }
}
