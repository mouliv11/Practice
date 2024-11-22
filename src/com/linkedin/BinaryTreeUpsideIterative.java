package com.linkedin;

public class BinaryTreeUpsideIterative {

    public BinaryTreeUpside.TreeNode upsideDownBinaryTree(BinaryTreeUpside.TreeNode root) {
        BinaryTreeUpside.TreeNode current = root;
        BinaryTreeUpside.TreeNode prev = null;
        BinaryTreeUpside.TreeNode next = null;
        BinaryTreeUpside.TreeNode right = null;

        while (current != null) {
            next = current.left;  // Store the left child

            // Rearrange pointers
            current.left = right;
            right = current.right;
            current.right = prev;

            // Move one step down in the tree
            prev = current;
            current = next;
        }
        return prev;  // The new root of the tree
    }

    public static void main (String[] args) {
        BinaryTreeUpsideIterative b = new BinaryTreeUpsideIterative();
        BinaryTreeUpside.TreeNode t = new BinaryTreeUpside.TreeNode(1);
        t.left = new BinaryTreeUpside.TreeNode(2);
        t.left.left = new BinaryTreeUpside.TreeNode(4);
        t.right = new BinaryTreeUpside.TreeNode(3);
        t.left.right = new BinaryTreeUpside.TreeNode(5);
        b.upsideDownBinaryTree(t);
    }
}

