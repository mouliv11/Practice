package com.linkedin;

import java.util.ArrayList;
import java.util.List;

public class Leaves {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        findLeaves(root, result);
        return result;
    }

    private int findLeaves(TreeNode root, List<List<Integer>> result) {
        if (root == null)
            return -1;
        int left = findLeaves(root.left, result);
        int right = findLeaves(root.right, result);
        int depth = Math.max(left, right) + 1;
        if (depth == result.size()) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            result.add(list);
        } else {
            List list = result.get(depth);
            list.add(root.val);
        }
        return depth;
    }

    public static void main (String[] args) {
        Leaves l = new Leaves();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        List<List<Integer>> result = l.findLeaves(treeNode);
        System.out.println("Done");
    }
}
