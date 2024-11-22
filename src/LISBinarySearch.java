import java.util.ArrayList;
import java.util.List;

public class LISBinarySearch {

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        List<Integer> tails = new ArrayList<>();

        for (int num : nums) {
            int left = 0, right = tails.size();
            // Binary search to find the position to replace or append
            while (left < right) {
                int mid = (left + right) / 2;
                if (tails.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // If left is equal to the size of tails, we append the number (extend the subsequence)
            if (left == tails.size()) {
                tails.add(num);
            } else {
                tails.set(left, num);  // Otherwise, replace the existing element to maintain the smallest possible tail
            }
        }

        return tails.size();  // The size of tails represents the length of the LIS
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of Longest Increasing Subsequence: " + lengthOfLIS(nums));
    }
}
