class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int max = Integer.MIN_VALUE;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<k;i++){
            maxHeap.add(nums[i]);
        }
        res[0] = maxHeap.peek();
        int l=1,r=k;
        while(r<nums.length){
            maxHeap.remove(nums[l-1]);
            maxHeap.add(nums[r]);
            res[l] = maxHeap.peek();
            l++;
            r++;
        }
        return res;
    }
}
