package com.linkedin;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private Map<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<>();
    }

    public void add(Integer value) {
        map.putIfAbsent(value, map.getOrDefault(value, 0) + 1);
    }

    public Boolean find(Integer target) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int complement = target - entry.getKey();
            if (complement == entry.getKey()) {
                if (entry.getValue() > 1)
                    return true;
            } else if (map.containsKey(complement)) {
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
        System.out.println(twoSum.find(8));
    }
}
