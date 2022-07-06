package com.linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {
    private Map<String, List<Integer>> map;
    public ShortestWordDistanceII(String[] words) {
        map = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortestDistance(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int i = 0,j = 0;
        int min = Integer.MAX_VALUE;
        while (i<l1.size() && j< l2.size()) {
            min = Math.min(min, Math.abs(l1.get(i) - l2.get(j)));
            if (l1.get(i) < l2.get(j))
                i++;
            else
                j++;
        }
        return min;
    }

    public static void main (String[] args) {
        String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        ShortestWordDistanceII s = new ShortestWordDistanceII(words);
        int min = s.shortestDistance("coding", "practice");
        System.out.println(min);
    }
}
