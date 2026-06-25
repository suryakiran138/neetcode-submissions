class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        Map<Character,Character> closeToOpen = Map.of(')','(','}','{',']','[');
        for(char c: s.toCharArray()){
            //System.out.println("c: "+c);
            if(closeToOpen.containsKey(c)){
                if(!stack.isEmpty() && closeToOpen.get(c) == stack.peek()){
                    stack.pop();
                } else return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
        
    }
}
