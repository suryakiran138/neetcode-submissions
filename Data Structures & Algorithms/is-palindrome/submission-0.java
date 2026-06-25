class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        String actual = "";
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i);
            if(Character.isAlphabetic(c) || Character.isDigit(c)) actual += s.substring(i,i+1);
        }
        len = actual.length();
        for(int i=0;i<len/2;i++){
            //System.out.println("i: "+i+" front: "+Character.toLowerCase(actual.charAt(i))+" back: "+Character.toLowerCase(actual.charAt(len-i-1)));
            if(Character.toLowerCase(actual.charAt(i))!=Character.toLowerCase(actual.charAt(len-i-1))) return false;
        }
        return true;
    }
}
