package com.linkedin;

public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i=1; i<nums.length; i++) {
            int tmp = max * nums[i];
            max = Math.max(nums[i] * max, Math.max(nums[i] * min, nums[i]));
            min = Math.min(tmp, Math.min(nums[i] * min, nums[i]));
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxProductSubarray m = new MaxProductSubarray();
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(m.maxProduct(nums));
    }
}
