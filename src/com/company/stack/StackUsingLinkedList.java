package com.company.stack;

public class StackUsingLinkedList {

    private  Node top;
    private  int height;

    public StackUsingLinkedList(int value){
        Node newNode = new Node(value);
        top =newNode;
        height =1;

    }

    class Node{
        Node next;
        int value;
        public Node(int value){
            this.value = value;
        }

    }

    public  Node getTop() {
        return top;
    }

    public int getHeight(){
        return height;
    }

   public void printStack(){
        Node temp = top;

        while (temp!= null){
            System.out.println(temp.value);
            temp = temp.next;
        }
   }

    public void printAll(){
        if(height ==0){
            System.out.println("Top Is null");
        } else {
            System.out.println("top "+ top.value);
        }
        System.out.println("\nHeight "+ height);
        System.out.println("\nStack");
        if(height == 0){
            System.out.println("empty");
        } else {
            printStack();
        }
    }

    public  void push(int value){
        Node node = new Node(value);

        if(top == null){
            top = node;
        } else {
            Node temp = top;
            node.next = temp;
            top = node;
        }
        height++;
    }
    public  boolean isEmpty(){
        return  height ==0;
    }

    public  void makeEmpty(){
        Node top = null;
        int height = 0;
    }
    public  int pop(){
        Node temp = null;

        if(isEmpty()){
            System.out.println("stack underflow");
            return  -1;
        } else {
            temp = top;
            top = top.next;
            temp.next = null;
        }
        height--;
        return temp.value;
    }
    public int peek(){
        if(height ==0 ){
            System.out.println("top is empty");
        } else{
            return top.value;
        }
        return 0;
    }

    public static void main(String[] args) {

        StackUsingLinkedList myStack = new StackUsingLinkedList(4);

        myStack.printAll();
        myStack.push(2);
        myStack.printAll();
        myStack.pop();
        myStack.printAll();
        myStack.pop();
        myStack.printAll();

        /*
            EXPECTED OUTPUT:
            ----------------
            Top: 4
            Height: 1

            Stack:
            4

        */

    }
}
