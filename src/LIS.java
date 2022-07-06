public class LIS {

    public int lengthOfLIS(int[] nums) {
        int[] length = new int[nums.length];
        int maxLength = 0;

        for (int i=0; i<nums.length; i++) {
            length[i] = 1;
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    length[i] = Math.max(length[i], length[j]+1);
                }
            }
            maxLength = Math.max(maxLength, length[i]);
        }
        return maxLength;
    }

    public static void main(String args[]) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        LIS l = new LIS();
        System.out.println(l.lengthOfLIS(nums));
    }

}
