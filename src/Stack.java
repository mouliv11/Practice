public class Stack {
    private int arr[];
    private int capacity;
    private int top;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.top = -1;
    }

    public void push(int data) throws Exception {
        if (top == capacity - 1) {
            throw new Exception("Stack Overflow");
        } else {
            arr[++top] = data;
        }
    }

    public int pop() throws Exception {
        if (top == -1) {
            throw new Exception("Stack is Empty");
        } else {
            return arr[top--];
        }
    }

}
