class Solution {

    public String encode(List<String> strs) {
        if(strs==null || strs.size()==0) return null;
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        if(str==null) return list;
        
        int i=0;
        while(i<str.length()){
            int slash = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, slash));
            list.add(str.substring(slash + 1, slash + 1 + length));
            i = slash + 1 + length;
        }
        return list;
    }
}
