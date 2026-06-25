class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> first = new HashMap<>();
        Map<Character,Integer> secound = new HashMap<>();
        fillMapWithString(s,first);
        fillMapWithString(t,secound);
        return first.equals(secound);
    }

    private void fillMapWithString(String s, Map<Character,Integer> map){
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else map.put(c, 1);
        }
    }
}
