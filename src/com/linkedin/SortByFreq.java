package com.linkedin;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortByFreq {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> p = new PriorityQueue((a, b) -> map.get(b) - map.get(a));
        p.addAll(map.keySet());
        StringBuilder stringBuilder = new StringBuilder();
        while (!p.isEmpty()) {
            char c = p.remove();
            for (int i=0; i<map.get(c); i++) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SortByFreq s = new SortByFreq();
        s.frequencySort("tree");
    }
}
