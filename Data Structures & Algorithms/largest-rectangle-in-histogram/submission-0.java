class Solution {
    class Pair {
        int index;
        int height;
        Pair(int index,int height){
            this.index = index;
            this.height = height;
        }
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek().height>heights[i]){
                Pair p = stack.pop();
                maxArea = Math.max(maxArea, p.height*(i-p.index));
                start = p.index;
            }
            stack.push(new Pair(start, heights[i]));
        }
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            maxArea = Math.max(maxArea,p.height*(heights.length-p.index));
        }
        return maxArea;
    }
}
