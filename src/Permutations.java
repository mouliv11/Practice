import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        permute(nums, new boolean[nums.length], new ArrayList<>(), results);
        return results;
    }

    private void permute(int[] nums, boolean[] used, ArrayList<Integer> permutations, List<List<Integer>> results) {
        if (permutations.size() == nums.length) {
            results.add(new ArrayList<>(permutations));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            permutations.add(nums[i]);
            permute(nums, used, permutations, results);
            used[i] = false;
            permutations.remove(permutations.size()-1);
        }
    }

    public static void main(String args[]) {
        int[] nums = new int[]{1,2,3};
        Permutations p = new Permutations();
        List<List<Integer>> permutations = p.permute(nums);
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }

}