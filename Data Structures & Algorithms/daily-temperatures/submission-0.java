class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        Stack<Pair> stack = new Stack<>();
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && temperatures[i]>stack.peek().temp){
                Pair p = stack.pop();
                res[p.index] = i-p.index; 
            }
            stack.add(new Pair(temperatures[i],i));
        }
        return res;
    }

    class Pair {
        int temp;
        int index;
        Pair(int temp,int index) {
            this.temp = temp;
            this.index = index;
        }
    }
}
