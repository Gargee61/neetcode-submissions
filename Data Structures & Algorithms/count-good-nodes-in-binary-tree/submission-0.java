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
        return dfs(root, Integer.MIN_VALUE);
    }
    private int dfs(TreeNode node, int largestVal) {
        if (node == null) return 0;
        int count = node.val >= largestVal ? 1 : 0;
        largestVal = Math.max(largestVal, node.val);
        return count + dfs(node.left, largestVal) + dfs(node.right, largestVal); 
    }
}
