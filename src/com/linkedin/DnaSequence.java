package com.linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DnaSequence {

    public List<String> findRepeatedDnaSequence(String s) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> seenMap = new HashMap<>();
        int i = 0;
        while (i+10 <= s.length()) {
            String subsequence = s.substring(i, i+10);
            seenMap.put(subsequence, seenMap.getOrDefault(subsequence, 0) + 1);
            if (seenMap.get(subsequence) == 2)
                result.add(subsequence);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        DnaSequence d = new DnaSequence();
        d.findRepeatedDnaSequence("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
}
