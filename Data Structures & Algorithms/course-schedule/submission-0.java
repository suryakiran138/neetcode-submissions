class Solution {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            preMap.put(i, new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }

        for(int i=0;i<numCourses;i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course){
        if(visited.contains(course)) return false;
        if(preMap.get(course).isEmpty()) return true;
        visited.add(course);
        for(int dep: preMap.get(course)){
            if(!dfs(dep)) return false;           
        }
        visited.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;
    }
}
