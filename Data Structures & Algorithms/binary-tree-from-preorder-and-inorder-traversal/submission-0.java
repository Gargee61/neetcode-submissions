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
    Map<Integer, Integer> map;
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return constructTree(preorder, 0, preorder.length - 1);
    }
    TreeNode constructTree(int[] preorder, int l, int r) {
        if (l > r) return null;
        int val = preorder[index++];
        TreeNode root = new TreeNode(val);
        if (l != r) {
            int mid = map.get(val);
            root.left = constructTree(preorder, l, mid - 1);
            root.right = constructTree(preorder, mid + 1, r);
        }
        return root;
    }
}
