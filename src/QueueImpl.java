import java.util.Arrays;

public class QueueImpl {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    public QueueImpl(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public int dequeue() throws Exception {
        if (count == 0) {
            throw new Exception("Queue is empty");
        } else {
            int x = arr[front];
            front = (front + 1) % capacity;
            return x;
        }
    }

    public void enqueue(int x) throws Exception {
        if (count == capacity) {
            throw new Exception("Queue overflow");
        } else {
            arr[rear] = x;
            rear = (rear + 1) % capacity;
            count++;
        }
    }
}
