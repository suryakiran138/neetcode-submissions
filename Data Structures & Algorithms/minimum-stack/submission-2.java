class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val<=minStack.peek()) minStack.push(val);
        //System.out.println("push stack: "+stack.peek()+" min stack: "+minStack.peek());
    }
    
    public void pop() {
        //System.out.println("1 pop stack: "+stack.peek()+" min stack: "+minStack.peek());
        if(stack.peek().equals(minStack.peek())) minStack.pop();
        stack.pop(); 
        //System.out.println("2 pop stack: "+stack.peek()+" min stack: "+minStack.peek()); 
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
