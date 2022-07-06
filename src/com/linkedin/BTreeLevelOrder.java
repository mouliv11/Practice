package com.linkedin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTreeLevelOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> currLevel = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return output;
        queue.add(root);
        int levelSize = queue.size();
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            currLevel.add(currNode.val);
            if (currNode.left != null) {
                queue.add(currNode.left);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
            }
            if (--levelSize <= 0) {
                output.add(currLevel);
                currLevel = new ArrayList<>();
                levelSize = queue.size();
            }
        }
        return output;

    }

    public static void main(String[] args) {
        BTreeLevelOrder b = new BTreeLevelOrder();
        BTreeLevelOrder.TreeNode t = new BTreeLevelOrder.TreeNode(3);
        t.left = new BTreeLevelOrder.TreeNode(9);
        t.right = new BTreeLevelOrder.TreeNode(20);
        t.right.right = new BTreeLevelOrder.TreeNode(7);
        t.right.left = new BTreeLevelOrder.TreeNode(15);
        b.levelOrder(t);
    }
}
