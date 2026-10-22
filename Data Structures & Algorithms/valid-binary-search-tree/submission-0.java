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
    public boolean isValidBST(TreeNode root) {
        // Use Long limits to handle potential Integer.MIN_VALUE or Integer.MAX_VALUE in node values
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        // An empty tree/leaf child is a valid BST
        if (node == null) {
            return true;
        }

        // The current node value must strictly stay within the valid bounds
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Left child must be less than current node value (updates max bound)
        // Right child must be greater than current node value (updates min bound)
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
