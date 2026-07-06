class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> tMap = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for(int i=0;i<t.length();i++){
            Integer count = tMap.get(t.charAt(i));
            if(count==null){
                tMap.put(t.charAt(i), 1);
            } else tMap.put(t.charAt(i), count+1);
        }

        int l=0,r=0;
        int have=0,need=tMap.size();
        int[] res = {-1,-1};
        int resLen = Integer.MAX_VALUE;
        while(r<s.length()){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c,0)+1);

            if(tMap.containsKey(c) && tMap.get(c).equals(window.get(c))) have++;
            while(have==need){
                if(r-l+1<resLen){
                    res[0] = l;
                    res[1] = r;
                    resLen = r-l+1;
                }
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar)-1);
                if(tMap.containsKey(leftChar) && window.get(leftChar)<tMap.get(leftChar)) have--;
                l++;
            } 
            r++;
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0],res[1]+1);

    }
}
