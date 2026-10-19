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
        if(root == null) return res;

        Stack<Object[]> stack = new Stack<>();
        stack.push(new Object[]{root , 0});
        res.add(root.val);

        TreeNode curr = root.right;
        TreeNode lastVisited = null;

        while(!stack.isEmpty()){
            while(curr != null){
                stack.push(new Object[]{curr , (int) stack.peek()[1] + 1});

                TreeNode peek = (TreeNode) stack.peek()[0];
                int depth = (Integer) stack.peek()[1];
                if(res.size() == depth) res.add(peek.val);

                curr = curr.right;
            }

            TreeNode peek = (TreeNode) stack.peek()[0];
            if(peek.left != null && lastVisited != peek.left) curr = peek.left;
            else lastVisited = (TreeNode) stack.pop()[0];
        }

        return res;  
    }
}
