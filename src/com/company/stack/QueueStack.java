package com.company.stack;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public QueueStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public void push(int item) {
        queue2.add(item);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.remove();
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.peek();
    }
    public static void main(String[] args) {
        QueueStack stack = new QueueStack();

        // Push elements to the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Peek the top element
        System.out.println("Peek: " + stack.peek()); // Output: Peek: 3

        // Pop elements from the stack
        System.out.println("Pop: " + stack.pop()); // Output: Pop: 3
        System.out.println("Peek after pop: " + stack.peek()); // Output: Peek: 2

        stack.push(4);

        System.out.println("Peek after pushing 4: " + stack.peek()); // Output: Peek: 4

        System.out.println("Pop: " + stack.pop()); // Output: Pop: 4
        System.out.println("Pop: " + stack.pop()); // Output: Pop: 2
        System.out.println("Pop: " + stack.pop()); // Output: Pop: 1

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: Is stack empty? true
    }

}
