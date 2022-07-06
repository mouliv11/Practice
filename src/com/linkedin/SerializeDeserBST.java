package com.linkedin;

public class SerializeDeserBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int index = 0;
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuffer sb = new StringBuffer();
        dfs(root, sb);
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuffer sb) {
        if (root == null)
            return;
        sb.append(root.val + ",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] preorder = data.split(",");
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode helper(String[] preorder, int start, int end) {
        if (index == preorder.length || Integer.parseInt(preorder[index]) < start || Integer.parseInt(preorder[index]) > end) {
            return null;
        }

        int val = Integer.parseInt(preorder[index]);
        TreeNode node = new TreeNode(val);
        index++;
        node.left = helper(preorder, start, val);
        node.right = helper(preorder, val, end);
        return node;
    }
}
