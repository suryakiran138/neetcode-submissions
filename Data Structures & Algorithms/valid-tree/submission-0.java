class Solution {
    Set<Integer> visited = new HashSet<>();
    Map<Integer,List<Integer>> preMap = new HashMap<>();


    public boolean validTree(int n, int[][] edges) {

        for(int i=0;i<n;i++){
            preMap.put(i, new LinkedList<>());
        }
        for(int[] edge:edges){
            preMap.get(edge[0]).add(edge[1]);
            preMap.get(edge[1]).add(edge[0]);
        }

        if(!dfs(0,-1)){
            return false;
        }

        return visited.size()==n;

    }

    private boolean dfs(int node,int parent){
        if(visited.contains(node)) return false;
        visited.add(node);
        for(int nei: preMap.get(node)){
            if(nei == parent) continue;
            if(!dfs(nei,node)) return false;
        }
        return true;
    }


}
