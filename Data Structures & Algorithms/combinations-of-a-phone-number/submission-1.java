class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()) return res;
        Map<Character,List<Character>> map = Map.of(
            '2', List.of('a','b','c'),
            '3', List.of('d','e','f'),
            '4', List.of('g','h','i'),
            '5', List.of('j','k','l'),
            '6', List.of('m','n','o'),
            '7', List.of('p','q','r','s'),
            '8', List.of('t','u','v'),
            '9', List.of('w','x','y','z')
        );
        backtrack(digits,0,new StringBuilder(),res,map);
        return res;
    }

    private void backtrack(String digits,int i,StringBuilder sb,List<String> res, Map<Character,List<Character>> map){
        if(i==digits.length()){
            res.add(sb.toString());
            return;
        }
        List<Character> chars = map.get(digits.charAt(i));
        for(char c: chars){
            sb.append(c);
            backtrack(digits,i+1,sb,res,map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
