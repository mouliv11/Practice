package com.linkedin;

import java.util.ArrayList;
import java.util.List;

public class NestedList2 {

    public int depthSum(List<NestedList.NestedInteger> nestedList) {
        int res = 0;
        if (nestedList == null || nestedList.size() == 0)
            return res;
        int ht = getHeight(nestedList);
        return depthSum(nestedList, ht);
    }

    private int getHeight(List<NestedList.NestedInteger> nestedList) { //[[1,1`], 2, [1,1]]
        int ht = 1;
        for (NestedList.NestedInteger item : nestedList) { //[1,1]
            if (!item.isInteger()) {
                int tmp = getHeight(item.getList());
                ht = Math.max(ht, tmp + 1);
            }
        }
        return ht;
    }

    private int depthSum(List<NestedList.NestedInteger> nestedList, int level) {
        int res = 0;
        for (NestedList.NestedInteger item : nestedList) {
            if (item.isInteger()) {
                res = res + item.getInteger() * level;
            } else {
                res = res + depthSum(nestedList, level - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
// Example: [[1, 1], 2, [1, 1]]
        NestedIntegerImpl ni1 = new NestedIntegerImpl();
        ni1.add(new NestedIntegerImpl(1));
        ni1.add(new NestedIntegerImpl(1));

        NestedIntegerImpl ni2 = new NestedIntegerImpl(2);

        NestedIntegerImpl ni3 = new NestedIntegerImpl();
        ni3.add(new NestedIntegerImpl(1));
        ni3.add(new NestedIntegerImpl(1));

        List<NestedList.NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(ni1);
        nestedList.add(ni2);
        nestedList.add(ni3);

        NestedList2 solution = new NestedList2();
        int result = solution.depthSum(nestedList);
        System.out.println("Weighted Sum: " + result);  // Output should be 8
    }

}
