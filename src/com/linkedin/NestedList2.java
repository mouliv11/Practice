package com.linkedin;

import java.util.List;

public class NestedList2 {


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
        int ht = getHeight(nestedList);
        return depthSum(nestedList, ht);
    }

    private int getHeight(List<NestedInteger> nestedList) { //[[1,1], 2, [1,1]]
        int ht = 1;
        for (NestedInteger item : nestedList) { //[1,1]
            if (!item.isInteger()) {
                int tmp = getHeight(item.getList());
                ht = Math.max(ht, tmp + 1);
            }
        }
        return ht;
    }

    private int depthSum(List<NestedInteger> nestedList, int level) {
        int res = 0;
        for (NestedInteger item : nestedList) {
            if (item.isInteger()) {
                res = res + item.getInteger() * level;
            } else {
                res = res + depthSum(nestedList, level - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
