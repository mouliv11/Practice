import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        MedianQueue medianQueue = new MedianQueue();
        double[] result = new double[nums.length - k + 1];
        int index = 0;
        for (int i=0; i< nums.length; i++) {
            medianQueue.add(nums[i]);
            if (medianQueue.size() == k) {
                result[index++] = medianQueue.getMedian();
                medianQueue.remove(nums[i+1-k]);
            }
        }
        return result;
    }

    class MedianQueue {
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        public MedianQueue() {
            this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            this.minHeap = new PriorityQueue<>();
        }

        void add(int num) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            if (minHeap.size() > maxHeap.size())
                maxHeap.add(minHeap.poll());
        }

        double getMedian() {
            if (maxHeap.size() > minHeap.size())
                return maxHeap.peek();
            else
                return (maxHeap.peek() + minHeap.peek())/2.0;
        }

        int size() {
            return maxHeap.size() + minHeap.size();
        }

        boolean remove(int x) {
            return minHeap.remove(x) || maxHeap.remove(x);
        }
    }

    public static void main(String args[]) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        Solution s = new Solution();
        s.medianSlidingWindow(nums, 3);
    }
}