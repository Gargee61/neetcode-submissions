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
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            List<Integer> sublist = new ArrayList<>();
            int sz = deque.size();
            for (int i = 0; i < sz; i++) {
                TreeNode top = deque.pollFirst();
                sublist.add(top.val);
                if (top.left != null) deque.addLast(top.left); 
                if (top.right != null) deque.addLast(top.right);
            }
            res.add(sublist);
        }
        return res;  
    }
}
