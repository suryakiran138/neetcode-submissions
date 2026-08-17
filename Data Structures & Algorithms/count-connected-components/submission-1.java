class Solution {
    
    
    public int countComponents(int n, int[][] edges) {
        int res = 0;
        Map<Integer, List<Integer>> preMap = new HashMap<>();
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            preMap.put(i,new ArrayList<>());
        }
        for(int[] edge: edges){
            preMap.get(edge[0]).add(edge[1]);
            preMap.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i, preMap, visited);
                res++;
            }
        }
        
        return res;
    }

    private void dfs(int node,Map<Integer, List<Integer>> preMap,boolean[] visited){
        visited[node] = true;
        for(int nei: preMap.get(node)){
            if(!visited[nei]){
                dfs(nei, preMap, visited);
            }    
        }
    }
}
