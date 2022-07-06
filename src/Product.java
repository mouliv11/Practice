public class Product {

    //Input: nums = [1,2,3,4]
    //Output: [24,12,8,6]
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;
        for (int i=1; i<nums.length; i++) {
            answer[i] = nums[i-1] * answer[i-1];
        }
        //answer = [1,1,2,6]
        int R=1;
        for (int i=nums.length-1; i>=0; i--) {
            answer[i] = answer[i] * R;
            R = R * nums[i]; //R=6
        }
        return answer;
    }

    public static void main(String args[]) {
        Product p = new Product();
        int[] nums = new int[]{1,2,3,4};
        p.productExceptSelf(nums);
    }
}
