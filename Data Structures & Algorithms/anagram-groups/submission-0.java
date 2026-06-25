class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character,Integer>,List<String>> res = new HashMap<>();
        for(String str: strs){
            Map<Character,Integer> map = new HashMap<>();
            fillFreqMap(str, map);
            if(!res.containsKey(map)){
                List<String> list = new ArrayList<>();
                list.add(str);
                res.put(map,list);
            } else {
                res.get(map).add(str);
            }
        }
        return new ArrayList<>(res.values());
    }

    private void fillFreqMap(String s, Map<Character,Integer> map){
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else map.put(c, 1);
        }
    }
}
