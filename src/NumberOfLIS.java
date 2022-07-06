import java.util.Arrays;

public class NumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        int[] length = new int[nums.length];
        int[] count = new int[nums.length];
        int maxLength = 0;
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);

        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    if (length[j]+1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } else if (length[j]+1 == length[i]) {
                        count[i] = count[i] + count[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, length[i]);
        }

        int result = 0;
        for (int i=0; i<nums.length; i++) {
            if (length[i] == maxLength) {
                result = result + count[i];
            }
        }
        return result;
    }

    public static void main(String args[]) {
        NumberOfLIS n = new NumberOfLIS();
        int[] nums = new int[]{1,3,5,4,7};
        System.out.println(n.findNumberOfLIS(nums));
    }
}
