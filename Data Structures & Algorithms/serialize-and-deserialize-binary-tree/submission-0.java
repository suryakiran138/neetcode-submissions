/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new LinkedList<>();
        dfsSerialize(root,list);
        return String.join(",", list);
    }

    private void dfsSerialize(TreeNode node, List<String> list) {
        if(node==null){
            list.add("N");
            return;
        }
        list.add(""+node.val);
        dfsSerialize(node.left, list);
        dfsSerialize(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] count = new int[1];
        String[] nodes = data.split(",");
        return dfsDeserialize(nodes,count);
    }

    private TreeNode dfsDeserialize(String[] nodes, int[] count){
        if(nodes[count[0]].equals("N")){
            count[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[count[0]]));
        count[0]++;
        node.left = dfsDeserialize(nodes,count);
        node.right = dfsDeserialize(nodes,count);
        return node;
    }


}
