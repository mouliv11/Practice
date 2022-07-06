package com.linkedin;

public class LCABinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLCA(root, p, q);
        return result;
    }

    private boolean findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        boolean left = findLCA(root.left, p, q);
        boolean right = findLCA(root.right, p, q);
        boolean curr = root == p || root == q;
        if ((left && right) || (left && curr) || (curr && right))
            result = root;
        return left || right || curr;
    }

    public static void main(String[] args) {
        LCABinaryTree l = new LCABinaryTree();
        //l.lowestCommonAncestor();
    }
}
