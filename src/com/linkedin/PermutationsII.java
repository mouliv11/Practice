package com.linkedin;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permuteUnique(nums, used, result, new ArrayList<>());
        return result;
    }

    private void permuteUnique(int[] nums, boolean[] used, List<List<Integer>> result, List permutations) {
        if (permutations.size() == used.length && !(result.contains(permutations))) {
            result.add(new ArrayList<>(permutations));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            permutations.add(nums[i]);
            permuteUnique(nums, used, result, permutations);
            used[i] = false;
            permutations.remove(permutations.size() - 1);
        }
    }

    public static void main(String args[]) {
        int[] nums = new int[]{1,1,2};
        PermutationsII permutations = new PermutationsII();
        permutations.permuteUnique(nums);
    }

}
