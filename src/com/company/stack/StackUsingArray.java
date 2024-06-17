package com.company.stack;

public class StackUsingArray {

    private int[] array;
    private int top;
    private int capacity;

    public StackUsingArray(int capacity){
        this.capacity = capacity;
        this.array = new int[capacity];
        this.top=-1;
    }

    public void  push(int value){
        if(top == capacity-1){
            return;
        }
        array[++top]=value;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("top is null");
            return -1;
        }
        return array[top--];
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return array[top];
    }

    public boolean isEmpty(){
        return  top ==-1;
    }
//    public void printStack() {
//        for(int i =array.length-11;i>=0;i--){
//            System.out.println(array[i]);
//        }
//    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }
    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printStack();
        System.out.println(stack.peek());

        while(!stack.isEmpty()){
            System.out.println(stack.pop());

        }
    }

}
