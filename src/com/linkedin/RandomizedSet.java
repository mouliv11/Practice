package com.linkedin;

import java.util.*;

public class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int index = map.get(val);
        int lstElement = list.get(list.size() - 1);
        list.set(index, lstElement);
        map.put(lstElement, index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomNum = random.nextInt(list.size());
        return list.get(randomNum);
    }
}
