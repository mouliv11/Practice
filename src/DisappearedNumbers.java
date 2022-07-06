import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //[1,2,2,3,3,4,7,8]
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0)
                nums[index] = -nums[index];
        }

        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0)
                result.add(i+1);
        }
        return result;
    }

    public static void main(String args[]) {
        DisappearedNumbers disappearedNumbers = new DisappearedNumbers();
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        disappearedNumbers.findDisappearedNumbers(nums);
    }
}
