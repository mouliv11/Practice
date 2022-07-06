package com.linkedin;

public class MaxSumSubarray {

    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = nums[0];
        for (int i=0; i<nums.length; i++) {
            if (currSum < 0)
                currSum = 0;
            currSum = currSum + nums[i];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSumSubarray m = new MaxSumSubarray();
        int[] nums = new int[]{-2,-1,-1};
        System.out.println(m.maxSubArray(nums));
    }
}
