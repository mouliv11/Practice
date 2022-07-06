import java.util.HashMap;
import java.util.Map;

public class SubarraySum2 {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum-k))
                count = count + map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String args[]) {
        SubarraySum2 s = new SubarraySum2();
        int[] nums = new int[]{1,1,1};
        s.subarraySum(nums, 2);
    }
}
