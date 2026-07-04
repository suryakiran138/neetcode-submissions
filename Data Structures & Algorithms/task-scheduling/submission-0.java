class Solution {

    private record Pair(int count, int availableTime) {}

    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Comparator.reverseOrder());

        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }

        Queue<Pair> queue = new LinkedList<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {

            time++;

            // First, move all tasks whose cooldown has finished
            while (!queue.isEmpty() && queue.peek().availableTime() == time) {
                maxHeap.offer(queue.poll().count());
            }

            // Execute the highest-frequency task
            if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll() - 1;

                if (remaining > 0) {
                    queue.offer(new Pair(remaining, time + n + 1));
                }
            }

            // Fast-forward if CPU is idle
            if (maxHeap.isEmpty() && !queue.isEmpty()) {
                time = queue.peek().availableTime() - 1;
            }
        }

        return time;
    }
}