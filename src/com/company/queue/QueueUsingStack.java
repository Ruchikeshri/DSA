package com.company.queue;

import java.util.Stack;

public class QueueUsingStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int front;

    public QueueUsingStack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public void queue(int item){
//        if(stack1.isEmpty()){
//             front = item;
//        }
        stack1.push(item);
    }

    public int dequeue(){

        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }

        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

    }

    public  int peek(){
        if(isEmpty()){
            throw  new IllegalArgumentException("queue is empty");
        }

        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        // Queue elements
        queue.queue(1);
        queue.queue(2);
        queue.queue(3);

        // Peek the front element
        System.out.println("Peek: " + queue.peek()); // Output: Peek: 1

        // Dequeue elements
        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 1
        System.out.println("Peek after dequeue: " + queue.peek()); // Output: Peek: 2

        queue.queue(4);

        System.out.println("Peek after queueing 4: " + queue.peek()); // Output: Peek: 2

        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 2
        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 3
        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 4

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? true

}

}
