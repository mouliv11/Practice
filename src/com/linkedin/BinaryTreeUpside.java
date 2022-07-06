package com.linkedin;

public class BinaryTreeUpside {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*
       1           1          1           4
     /  \        /  \        /           / \
    2    3      2    3     2 - 3       5    2
   / \         /          /                / \
  4   5       4 - 5      4 - 5            3   1

     */
    public TreeNode upsideDown(TreeNode root) {
        if (root == null || root.left == null)
            return root;
        TreeNode newRoot = upsideDown(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    public static void main (String[] args) {
        BinaryTreeUpside b = new BinaryTreeUpside();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.left.left = new TreeNode(4);
        t.right = new TreeNode(3);
        t.left.right = new TreeNode(5);
        b.upsideDown(t);
    }
}
