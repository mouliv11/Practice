package com.linkedin;

import java.util.Stack;

public class MaxStack {
    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    public static void main(String args[]) {
        // 1,3,2,5,4,3,5,2
        MaxStack stk = new MaxStack();
        stk.push(1);   // [5] the top of the stack and the maximum number is 5.
        stk.push(3);   // [5, 1] the top of the stack is 1, but the maximum is 5.
        stk.push(2);
        stk.push(5);
        stk.push(4);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
        stk.push(3);
        stk.push(5);
        stk.push(2);

        // stack:    [5, 1, 2, 7, 6] -> [5, 1, 2, 7] -> [5, 1, 2] -> [5, 1, 2, 6]
        // maxStack: [5, 5, 5, 7,  7] -> [5, 5, 5, 7] -> [5, 5, 5] -> [5, 5, 5, 6]
        // buffer: [6]

        stk.top();     // return 5, [5, 1, 5] the stack did not change.
        stk.popMax();  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
        stk.top();     // return 1, [5, 1] the stack did not change.
        stk.peekMax(); // return 5, [5, 1] the stack did not change.
        stk.pop();     // return 1, [5] the top of the stack and the max element is now 5.
        stk.top();     // return 5, [5] the stack did not change.
        stk.popMax();
        stk.popMax();
    }

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int i) {
        stack.push(i);
        int max = maxStack.isEmpty() ? i : (i > maxStack.peek() ? i : maxStack.peek());
        maxStack.push(max);
    }

    public int top() {
        return stack.peek();
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> buffer = new Stack();
        while (top() != max) {
            buffer.push(pop());
        }
        pop();
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }
        return max;
    }
}
