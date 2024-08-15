package com.company.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingLinkedListCollection<T> {

    private Queue<T> queue;
    private T frontElement; // Variable to store the front element of the queue


    public QueueUsingLinkedListCollection() {
        queue = new LinkedList<T>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void enqueue(T item) {
        queue.add(item);
        if (frontElement == null) {
            frontElement = item; // Update frontElement if it's the first element
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
        T removed = queue.remove();
        if (removed.equals(frontElement)) {
            updateFrontElement(); // Update frontElement if the removed element was the front
        }
        return removed;

//        return queue.remove();
    }

    public <T> T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("queue is empty");
        }
//        return (T) frontElement;
        return (T) queue.peek();
    }

    private void updateFrontElement() {
        if (!queue.isEmpty()) {
            frontElement = queue.iterator().next();
//                    queue.peek(); // Update frontElement to the new front of the queue
        } else {
            frontElement = null; // Queue is empty, no front element
        }
    }

    // Example usage in main method
    public static void main(String[] args) {
        QueueUsingLinkedListCollection<Integer> queue = new QueueUsingLinkedListCollection<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);



        System.out.println("Peek: " + queue.peek()); // Output: Peek: 1

        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 1
        System.out.println("Peek after dequeue: " + queue.peek()); // Output: Peek after dequeue: 2
    }

}
