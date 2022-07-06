import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> maxHeap, minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
        return (minHeap.peek() + maxHeap.peek()) / 2.0d;
    }

    public static void main(String args[]) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        m.addNum(3);
        m.addNum(4);
        System.out.println(m.findMedian());
    }
}
