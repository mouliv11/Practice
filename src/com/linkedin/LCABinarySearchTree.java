package com.linkedin;


public class LCABinarySearchTree {

    public LCABinaryTree.TreeNode lowestCommonAncestor(LCABinaryTree.TreeNode root, LCABinaryTree.TreeNode p, LCABinaryTree.TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

}
