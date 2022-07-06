package com.linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    //[[1,3],[2,6],[8,10],[15,18]]
    public int[][] merge(int[][] intervals) {
        if (intervals.length <=1) {
            return intervals;
        }
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        List<int[]> outputArr = new ArrayList<>();
        int[] currInterval = intervals[0];
        outputArr.add(currInterval);
        for (int[] interval : intervals) {
            int currStart = currInterval[0];
            int currEnd = currInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];
            if (currEnd >= nextStart) {
                currInterval[1] = Math.max(currEnd, nextEnd);
            } else {
                currInterval = interval;
                outputArr.add(currInterval);
            }
        }
        return outputArr.toArray(new int[outputArr.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        int[][] intervals = new int[][]{{1,5}, {2,8}, {9,12}};
        m.merge(intervals);
    }
}
