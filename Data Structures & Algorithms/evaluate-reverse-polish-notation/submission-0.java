class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> operators = Set.of("+","-","*","/");
        for(int i=0;i<tokens.length;i++){
            if(operators.contains(tokens[i])){
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int res = 0;
                switch(tokens[i]){
                    case "+":
                        res = a+b;
                        break;
                    case "-":
                        res = a-b;
                        break;
                    case "*":
                        res = a*b;
                        break;
                    case "/":
                        res = a/b;
                        break;

                }
                stack.push(res+"");
            } else stack.push(tokens[i]);
        }
        return Integer.parseInt(stack.pop());
    }
}
