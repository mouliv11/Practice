package com.linkedin;

public class PartitionKSubsets {

    public boolean canPartitionSubsets(int[] nums, int k) {
        int total = 0;
        for (int num : nums)
            total = total + num;
        if (total % k != 0)
            return false;
        if (nums.length < k)
            return false;
        boolean[] visited = new boolean[nums.length];
        return canPartitionSubsets(nums, visited, 0, k, 0, total/k);
    }

    private boolean canPartitionSubsets(int[] nums, boolean[] visited, int start, int k,
                                        int curSum, int subsetSum) {
        if (k == 0)
            return true;
        if (curSum > subsetSum)
            return false;
        if (curSum == subsetSum)
            return canPartitionSubsets(nums, visited, 0, k-1, 0, subsetSum);

        for (int i = start; i< nums.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            if (canPartitionSubsets(nums, visited, i+1, k, curSum + nums[i], subsetSum))
                return true;
            visited[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        PartitionKSubsets p = new PartitionKSubsets();
        int[] nums = new int[]{4,3,2,3,5,2,1};
        System.out.println(p.canPartitionSubsets(nums, 4));
    }
}
