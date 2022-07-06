import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            int l=i+1;
            int r=nums.length - 1;
            while (l<r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(diff))
                    diff = target - sum;
                if (sum < target)
                    l++;
                else
                    r--;
            }
        }
        return target - diff;
    }

    public static void main(String args[]) {
        int[] nums = new int[]{-1,2,1,-4};
        System.out.println(threeSumClosest(nums, 1));
    }
}
