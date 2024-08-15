package com.company.queue;

public class QueueUsingArray {
  private int[] queue;
  private int capacity;
  private int front;
  private int rear;
  private int size;

    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

//    public void enqueue(int item) {
//        if (isFull()) {
//            throw new IllegalStateException("Queue is full");
//        }
//        rear = (rear + 1) % capacity;
//        queue[rear] = item;
//        size++;
//    }

    public  void enqueue(int item){
        if(isFull()) {
            throw new IllegalArgumentException("queue is full");
        }
        rear = (rear+1)%capacity;
        queue[rear] = item;
        size++;
    }

    public int dequeue(){
        if(isFull()){
            throw  new IllegalArgumentException("Queue is empty");
        }
        int item = queue[front];
        front = (front+1)%capacity;
        size --;
        return item;
    }

//    public int dequeue() {
//        if (isEmpty()) {
//            throw new IllegalStateException("Queue is empty");
//        }
//        int item = queue[front];
//        front = (front + 1) % capacity;
//        size--;
//        return item;
//    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(5);

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Peek the front element
        System.out.println("Peek: " + queue.peek()); // Output: Peek: 1

        // Dequeue elements
        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 1
        System.out.println("Peek after dequeue: " + queue.peek()); // Output: Peek: 2

        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        System.out.println("Peek after enqueuing 4, 5, 6: " + queue.peek()); // Output: Peek: 2

        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 2
        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 3
        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 4

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? false

        queue.enqueue(7);
        queue.enqueue(8);

        // Dequeue remaining elements
        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 5
        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 6
        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 7
        System.out.println("Dequeue: " + queue.dequeue()); // Output: Dequeue: 8

        // Check if the queue is empty again
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? true
    }
}
