package com.linkedin;

import java.util.List;

public class NestedList {
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    public int depthSum(List<NestedInteger> nestedList) {
        int res = 0;
        if (nestedList == null || nestedList.size() == 0)
            return res;
        res = depthSum(nestedList, 1);
        return res;
    }

    private int depthSum(List<NestedInteger> nestedList, int level) {
        int res = 0;
        for (NestedInteger item : nestedList) {
            if (item.isInteger()) {
                res = res + item.getInteger() * level;
            } else {
                res = res + depthSum(item.getList(), level + 1);
            }
        }
        return res;
    }
}
