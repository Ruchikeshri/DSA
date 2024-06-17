package com.company.queue;

public class QueueUsingLinkedList {

    private Node first;
    private Node last;
    private int length;

    class Node {
        Node next;
        int value;

        public Node(int value){
            this.value = value;
        }
    }

    public QueueUsingLinkedList(int value){
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length =1;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void printList(){
        Node temp = first;

        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.next;
        }

    }

    public void printAll() {
        if(length ==0){
            System.out.println("fist null");
            System.out.println("last null");
        }  else {
            System.out.println("first "+ first.value );
            System.out.println("last "+ last.value);
        }
        System.out.println("length "+ length);
        System.out.println("queue:");
        if(length ==0){
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public  void makeEmpty(){
        first = null;
        last = null;
        length =0;
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        if(length ==0){
            first = newNode;
            last = newNode;

        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue(){
        Node temp = first;
        if(length ==0){
            return  null;
        }
        if(length ==1){
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length --;
        return  temp;
    }

    public int peek(){
        if(length ==0){
            throw new IllegalArgumentException("queue is empty");
        }
        return  first.value;
    }
    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList(2);
        queue.enqueue(1);
        queue.printAll();
        System.out.println("Dequeue is happening");
        System.out.println(queue.dequeue().value);
        System.out.println(queue.dequeue().value);
        System.out.println(queue.dequeue());
    }
}
