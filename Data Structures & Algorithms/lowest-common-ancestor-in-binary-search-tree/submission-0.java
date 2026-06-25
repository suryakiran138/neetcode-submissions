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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<TreeNode> set = new HashSet<>();
        TreeNode temp = root;
        while(temp!=null){
            if(temp.val==p.val) return p;
            else if(temp.val==q.val) return q;
            else if(p.val<temp.val && q.val<temp.val) temp=temp.left;
            else if(p.val>temp.val && q.val>temp.val) temp=temp.right;
            else return temp;
        }
        return null;
    }
}
