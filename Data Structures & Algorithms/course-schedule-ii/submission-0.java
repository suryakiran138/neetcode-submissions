class Solution {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();
    Set<Integer> processed = new HashSet<>();

    int[] res;
    int count = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];

        // Initialize graph
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        // course -> prerequisites
        for (int[] pre : prerequisites) {
            preMap.get(pre[0]).add(pre[1]);
        }

        // DFS each course
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return new int[]{};
            }
        }

        return res;
    }

    private boolean dfs(int course) {

        // Cycle detected
        if (visiting.contains(course)) {
            return false;
        }

        // Already completely processed
        if (processed.contains(course)) {
            return true;
        }

        // Mark as currently being explored
        visiting.add(course);

        // Visit all prerequisites
        for (int dep : preMap.get(course)) {
            if (!dfs(dep)) {
                return false;
            }
        }

        // Done processing this course
        visiting.remove(course);
        processed.add(course);

        // Add after prerequisites -> postorder
        res[count++] = course;

        return true;
    }
}