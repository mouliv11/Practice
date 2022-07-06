package com.linkedin;

public class DeleteNode {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            if (root.left == null && root.right == null)
                return null;
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode nextMinNode = root.right;
                while (nextMinNode.left != null) {
                    nextMinNode = nextMinNode.left;
                }
                nextMinNode.left = root.right;
                return root.right;
            }
        }
    }
}
