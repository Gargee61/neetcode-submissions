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

public class Codec {

    int cursor=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb=new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }

    private void dfsSerialize(TreeNode root, StringBuilder sb){
        if(root==null) {
            sb.append(1).append(',').append('#');
            return;
        }
        sb.append((int)(Math.log10(root.val)+1)).append(',').append(root.val);
        dfsSerialize(root.left, sb);
        dfsSerialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        return deserializeHelper(data);
    }

    private TreeNode deserializeHelper(String data){
        if(cursor>=data.length()) return null;
        Integer val=charToInt(data);
        if(val==null) return null;
        TreeNode root=new TreeNode(val);
        root.left=deserializeHelper(data);
        root.right=deserializeHelper(data);
        return root;
    }

    private Integer charToInt(String data){
        int end=data.indexOf(',', cursor);
        String lenStr=data.substring(cursor, end);
        int len=Integer.parseInt(lenStr);
        cursor+=(lenStr.length()+1+len);
        if(data.substring(end+1, end+len+1).equals("#")) return null;
        int res=Integer.parseInt(data.substring(end+1, end+len+1));
        return res;
    }

}
