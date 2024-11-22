import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> num_list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i ++) {
            num_list.add(nums[i]);
        }

        backtrack(num_list, 0, nums.length, result);
        return result;
    }

    private void backtrack (List<Integer> nums, int left, int right, List<List<Integer>> result) {
        if (left == right) {
            result.add(new ArrayList<Integer>(nums));

        } else {
            for (int i = left; i < right; i++) {
                Collections.swap(nums, left, i);
                backtrack(nums, left + 1, right, result);
                Collections.swap(nums, left, i);
            }
        }

    }

    public static void main(String args[]) {
        int[] arr = new int[]{1,1,2};
        Permute p = new Permute();
        List<List<Integer>> permutations = p.permute(arr);
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}