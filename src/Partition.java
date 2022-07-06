import java.util.HashMap;

public class Partition {

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int n : nums) {
            total = total + n;
        }

        if (total % 2 != 0)
            return false;

        return canPartition(nums, 0, 0, total, new HashMap<String, Boolean>());
    }

    private boolean canPartition(int[] nums, int index, int sum, int total, HashMap<String, Boolean> state) {
        String current = index + "" + sum;
        if (state.containsKey(current))
            return state.get(current);

        if (sum * 2 == total)
            return true;

        if (sum > total/2 || index >= nums.length)
            return false;

        boolean isPartition = canPartition(nums, index+1, sum, total, state) ||
                canPartition(nums, index+1, sum + nums[index], total, state);
        state.put(current, isPartition);
        return isPartition;
    }

    public static void main(String args[]) {
        Partition p = new Partition();
        int[] nums = new int[]{1,5,11,5};
        p.canPartition(nums);
    }
}
