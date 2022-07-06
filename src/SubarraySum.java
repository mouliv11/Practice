import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //map.put(0,-1);
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum = sum + nums[i];

            if (k != 0) {
                sum = sum % k;
            }

            if (map.containsKey(sum)) {
                if (i - map.get(sum) >= 2)
                    return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String args[]) {
        SubarraySum s = new SubarraySum();
        int[] nums = new int[]{23,2,4,6,6};
        System.out.println(s.checkSubarraySum(nums, 7));
    }
}
