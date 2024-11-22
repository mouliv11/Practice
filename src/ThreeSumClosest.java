import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Initialize a variable to store the closest sum found so far
        int closestSum = nums[0] + nums[1] + nums[2]; // Start with the first three elements

        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;

            // Use two pointers to find the closest sum
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // If the current sum is exactly equal to the target, return it immediately
                if (currentSum == target) {
                    return currentSum;
                }

                // If the current sum is closer to the target than the previous closest sum, update closestSum
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Move the pointers based on whether the sum is less than or greater than the target
                if (currentSum < target) {
                    left++;  // Increase the sum by moving the left pointer to the right
                } else {
                    right--; // Decrease the sum by moving the right pointer to the left
                }
            }
        }

        // Return the closest sum found
        return closestSum;
    }

    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(solution.threeSumClosest(nums, target)); // Output should be 2
    }
}
