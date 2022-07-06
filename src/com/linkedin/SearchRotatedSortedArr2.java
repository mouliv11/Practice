package com.linkedin;

public class SearchRotatedSortedArr2 {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int midpoint = left + (right - left)/2;
            if (nums[midpoint] > nums[right]) {
                left = midpoint + 1;
            } else if (nums[midpoint] == nums[right]) {
                left = left + 1;
            } else {
                right = midpoint;
            }
        }
        int start = left;
        left = 0;
        right = nums.length - 1;
        if (target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }
        while (left <= right) {
            int midpoint = left + (right-left)/2;
            if (nums[midpoint] == target) {
                return true;
            } else if (target < nums[midpoint]) {
                right = midpoint - 1;
            } else {
                left = midpoint + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArr2 s = new SearchRotatedSortedArr2();
        int[] nums = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        s.search(nums, 2);
    }
}
