package com.linkedin;

import java.util.ArrayList;
import java.util.List;

public class FindKClosest {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> output = new ArrayList<>();
        int low = 0;
        int high = arr.length-1;
        while(high - low >= k) {
            if(Math.abs(arr[low] - x) > Math.abs(arr[high] - x)) {
                low++;
            } else {
                high--;
            }
        }

        for (int i=low; i<=high; i++) {
            output.add(arr[i]);
        }
        return output;
    }

    public static void main(String[] args) {
        FindKClosest f = new FindKClosest();
        int[] arr = new int[]{1,2,3,4,5};
        f.findClosestElements(arr, 4, 3);
    }
}
