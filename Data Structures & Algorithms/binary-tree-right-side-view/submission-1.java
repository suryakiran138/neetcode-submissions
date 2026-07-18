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

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root==null) return res;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            res.add(queue.get(size-1).val);
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            
            }
        }
        return res;
    }
}
