package com.linkedin;

public class BSTFromPreOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if (index == preorder.length || preorder[index] < start || preorder[index] > end) {
            return null;
        }
        int val = preorder[index];
        index++;
        TreeNode node = new TreeNode(val);
        node.left = helper(preorder, start, val);
        node.right = helper(preorder, val, end);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{8,5,1,7,10,12};
        BSTFromPreOrder b = new BSTFromPreOrder();
        TreeNode node = b.bstFromPreorder(preorder);
        System.out.println(node);
    }
}
