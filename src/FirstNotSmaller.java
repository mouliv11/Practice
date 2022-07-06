import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FirstNotSmaller {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(3);
        arr.add(5);
        arr.add(8);
        arr.add(8);
        arr.add(10);
        int target = 2;
        int res = firstNotSmaller(arr, target);
        System.out.println(res);
    }

    public static int firstNotSmaller(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (arr.get(mid) >= target) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}
