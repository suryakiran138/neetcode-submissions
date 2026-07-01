class KthLargest {

    int size;
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.size = k;
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(queue.size()<size){
           //System.out.println("adding val: "+val);
           queue.offer(val); 
        } else if(val>queue.peek()){
            //System.out.println("removing val: "+queue.peek()+"adding val: "+val);
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}
