import java.util.Arrays;
import java.util.Stack;

public class UnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int left = nums.length, right = 0, result = 0;
        for (int i=0; i<nums.length; i++) {
            if (stack.isEmpty() || nums[i] > nums[stack.peek()]) {
                stack.push(i);
            } else {
                left = Math.min(left, stack.pop());
                stack.push(i);
            }
        }
        stack.removeAllElements();
        for (int j=nums.length-1; j>=0; j--) {
            if (stack.isEmpty() || nums[j] > nums[stack.peek()]) {
                stack.push(j);
            } else {
                right = Math.max(right, stack.pop());
                stack.push(j);
            }
        }
        if (left >= right)
            return 0;
        else
            result = right-left+1;
        return result;
    }

    public static void main(String args[]) {
        int[] nums = new int[]{2,6,4,8,10,9,15};
        UnsortedSubarray u = new UnsortedSubarray();
        System.out.println(u.findUnsortedSubarray(nums));
    }
}
