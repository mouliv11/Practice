package com.linkedin;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private Map<Integer, Integer> map;
    public TwoSum() {
        map = new HashMap<>();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int target) {
        for (int i : map.keySet()) {
            int j = target - i;
            int counter;
            if (target == i)
                counter = 2;
            else
                counter = 1;
            if (map.getOrDefault(target, 0) >= counter) {
                return true;
            }
        }
        return false;
    }

    public static void main (String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);
        twoSum.add(4);
        twoSum.add(7);
        System.out.println(twoSum.find(4));
    }
}
