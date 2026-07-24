/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> map = new HashMap<>();
        dfs(node,map);
        for(Map.Entry<Node,Node> entry: map.entrySet()){
            Node original = entry.getKey();
            Node clone = entry.getValue();
            List cloneList = new ArrayList<>();
            for(Node n: original.neighbors){
                cloneList.add(map.get(n));
            }
            clone.neighbors = cloneList;
        }
        return map.get(node);
    }

    void dfs(Node node, Map<Node,Node> map){
        if(node==null || map.containsKey(node)) return;
        Node clone = new Node(node.val);
        map.put(node,clone);
        for(Node n: node.neighbors){
            dfs(n,map);
        }
    }
}