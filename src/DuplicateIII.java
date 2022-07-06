import java.util.HashMap;
import java.util.Map;

public class DuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i]) && i-map.get(nums[i]) <= k) {
                if (Math.abs(nums[i] - nums[i-k]) <= t)
                    return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String args[]) {
        DuplicateIII d = new DuplicateIII();
        int[] nums = new int[]{8,7,15,1,6,1,9,15};
        d.containsNearbyAlmostDuplicate(nums, 1, 3);
    }
}
