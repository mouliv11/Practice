import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            if ((Integer)entry.getValue() > 1)
                return true;
        }
        return false;
    }

}
