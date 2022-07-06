package com.linkedin;

import java.util.HashSet;
import java.util.Set;

public class SecondMinimum {

    public int findSecondMinimumValue(BinaryTreeUpside.TreeNode root) {
        Set<Integer> set = new HashSet();
        int result = -1;
        dfs(root, set);
        int min = root.val;
        for (int value : set) {
            if (min < value) {
                result = value;
                break;
            }
        }
        return result;
    }

    private void dfs(BinaryTreeUpside.TreeNode root, Set set) {
        if (root != null) {
            set.add(root.val);
            dfs(root.left, set);
            dfs(root.right, set);
        }
    }
}
