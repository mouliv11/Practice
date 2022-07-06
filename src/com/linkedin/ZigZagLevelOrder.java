package com.linkedin;

import java.util.*;

public class ZigZagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(BTreeLevelOrder.TreeNode root) {
        List<List<Integer>> ouput = new ArrayList<>();
        Queue<BTreeLevelOrder.TreeNode> queue = new LinkedList<>();
        if (root == null)
            return ouput;
        queue.add(root);
        int levelSize = queue.size();
        boolean rightToLeft = false;
        List<Integer> currLevel = new ArrayList<>();
        while (!queue.isEmpty()) {
            BTreeLevelOrder.TreeNode node = queue.poll();
            currLevel.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (--levelSize <= 0) {
                ouput.add(currLevel);
                if (rightToLeft)
                    Collections.reverse(currLevel);
                rightToLeft = !rightToLeft;
                currLevel = new ArrayList<>();
                levelSize = queue.size();
            }
        }
        return ouput;
    }
}
