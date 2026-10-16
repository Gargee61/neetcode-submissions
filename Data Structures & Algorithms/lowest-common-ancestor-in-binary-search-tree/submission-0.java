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
        return (p.val<q.val)? rLowestCommonAncestor(root, p, q):
        rLowestCommonAncestor(root, q, p);
    }

    public TreeNode rLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(p.val<=root.val && root.val<=q.val) return root;
        return (p.val<root.val)? rLowestCommonAncestor(root.left, p, q):
            rLowestCommonAncestor(root.right, p, q);
        
    }
}
