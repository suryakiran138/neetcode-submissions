class Solution {
    public String longestPalindrome(String s) {
        int longStart = 0;
        int longLength = 0;
        //checking odd palindroms
        for(int k=0;k<s.length();k++){
            int i=k,j=k;
            while(i>=0 && j<s.length()){
                if(s.charAt(i)==s.charAt(j)){
                    int palLength = j-i+1;
                    if(palLength>longLength){
                        longStart = i;
                        longLength = palLength;
                    }
                } else break;
                i--;
                j++;
            }
        }

        //checking even palindroms
        for(int k=0;k<s.length()-1;k++){
            int i=k,j=k+1;
            while(i>=0 && j<s.length()){
                if(s.charAt(i)==s.charAt(j)){
                    int palLength = j-i+1;
                    if(palLength>longLength){
                        longStart = i;
                        longLength = palLength;
                    }
                } else break;
                i--;
                j++;
            }
        }

        return s.substring(longStart,longStart+longLength);
        
    }
}
