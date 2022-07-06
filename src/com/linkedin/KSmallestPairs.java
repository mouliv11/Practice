package com.linkedin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> output = new ArrayList<>();
        k = Math.min(nums1.length * nums2.length, k);
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> (a.get(0) + a.get(1))));
        for (int i=0; i<Math.min(k, nums1.length); i++) {
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[i]);
            pair.add(nums2[0]);
            pair.add(0);
            pq.offer(pair);
        }
        for (int i=0; i<k; i++) {
            List<Integer> pair = pq.poll();
            List<Integer> trimList = new ArrayList<>();
            trimList.add(pair.get(0));
            trimList.add(pair.get(1));
            output.add(trimList);
            if (pair.get(2) < nums2.length - 1) {
                int num2nxt = pair.get(2);
                num2nxt++;
                List<Integer> list = new ArrayList<>();
                list.add(pair.get(0));
                list.add(nums2[num2nxt]);
                list.add(num2nxt);
                pq.offer(list);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,7,11};
        int[] nums2 = new int[]{2,4,6};
        List<List<Integer>> res = kSmallestPairs(nums1, nums2, 3);
        for (List<Integer> pairs : res) {
            for (Integer num : pairs) {
                System.out.println(num);
            }
        }
    }
}
