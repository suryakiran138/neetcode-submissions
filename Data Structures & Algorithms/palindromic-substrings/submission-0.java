class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i=0;i<s.length();i++){
            // odd palindroms
            int j=i,k=i;
            while(j>=0 && k<s.length() && s.charAt(j)==s.charAt(k)){
                res++;
                j--;
                k++;
            }
            // even palindroms
            j=i;k=i+1;
            while(j>=0 && k<s.length() && s.charAt(j)==s.charAt(k)){
                res++;
                j--;
                k++;
            }
        }
        return res;
    }
    
}
