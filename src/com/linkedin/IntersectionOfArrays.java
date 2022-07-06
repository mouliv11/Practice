package com.linkedin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int n : nums1) {
            s1.add(n);
        }
        for (int n : nums2) {
            s2.add(n);
        }
        if (s1.size() < s2.size())
            return findIntersection(s1, s2);
        else
            return findIntersection(s2, s1);
    }

    private int[] findIntersection(Set<Integer> s1, Set<Integer> s2) {
        int[] output = new int[s1.size()];
        int idx = 0;
        for (int n : s1) {
            if (s2.contains(n))
                output[idx++] = n;
        }
        return Arrays.copyOf(output, idx);
    }
}
