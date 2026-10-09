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
     int maxEdges = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        findDiameter(root);
        return maxEdges; 
    }

    public int findDiameter(TreeNode root){
        if(root == null) { 
            return 0;
        }

        int left = findDiameter(root.left); //traverse left child subtree

        int right = findDiameter(root.right); //traverse right child subtree

        int current = Math.max(left, right) + 1; //'current' subtree length; left/right can either have
        // a val or be 0 if not being traversed

        maxEdges = Math.max(left + right, maxEdges); // add left and right traversals, compare w max

        return current;
        
    }
}
