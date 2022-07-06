import java.util.ArrayList;
import java.util.List;

public class FirstOccurance {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(6);
        arr.add(10);
        arr.add(10);
        arr.add(10);
        arr.add(100);
        int target = 3;
        int res = firstOccurance(arr, target);
        System.out.println(res);
    }

    public static int firstOccurance(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (arr.get(mid) <= target) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}
