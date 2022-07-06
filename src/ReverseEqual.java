import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReverseEqual {

    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : target)
            map.put(i, map.getOrDefault(i,0)+1);
        for (int j : arr) {
            if (!map.containsKey(j))
                return false;
            if (map.get(j) == 1)
                map.remove(j);
            else
                map.put(j, map.get(j)-1);
        }
        return map.size() == 0;
    }

    public static void main(String args[]) {
        int[] target = new int[]{1,2,3,4};
        int[] arr = new int[]{2,4,1,3};
        ReverseEqual r = new ReverseEqual();
        r.canBeEqual(target, arr);
    }
}
