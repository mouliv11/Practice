package com.linkedin;

import java.util.Arrays;

public class TriangleNumber {

    public int triangleNumbers(int[] nums) {
        int result = 0;
        if (nums.length < 3)
            return 0;
        Arrays.sort(nums);
        for (int i=2; i<nums.length; i++) {
            int left = 0;
            int right = i-1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result = result + (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
