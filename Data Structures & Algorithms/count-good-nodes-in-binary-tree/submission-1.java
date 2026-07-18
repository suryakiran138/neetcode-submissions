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
    public int goodNodes(TreeNode root) {
        int[] res = new int[1];
        countGood(root,root.val,res);
        return res[0];
    }

    private void countGood(TreeNode root, int max, int[] res){
        if(root.val>=max) {
            System.out.println(root.val);
            res[0]++;
        }
        if(root.left!=null) countGood(root.left,Math.max(root.val,max),res);
        if(root.right!=null) countGood(root.right,Math.max(root.val,max),res);
    }
}
