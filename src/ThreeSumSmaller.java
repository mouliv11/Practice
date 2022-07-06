import java.util.Arrays;

public class ThreeSumSmaller {
    public static int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            int j=i+1;
            int k=nums.length-1;
            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target) {
                    // k-j important because value at k-1 will be less than
                    // target if added in the sum as array is sorted.
                    count = count+(k-j);
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;

    }

    public static void main(String args[]) {
        int[] nums = new int[]{-2,0,1,3};
        System.out.println(threeSumSmaller(nums, 2));
    }
}
