package com.company.stack;

import java.util.ArrayList;

public class StackUsingArrayList<T> {

    private ArrayList<T> stack = new ArrayList<>();

    public StackUsingArrayList(){
        this.stack = new ArrayList<>();
    }

    public  void push(T value){
        stack.add(value);
    }

    public T pop(){
        if(isEmpty()){
            return null;
        }
        return  stack.remove(stack.size()-1);
    }

    public int size() {
        return stack.size();
    }
    public T peek(){
     if(isEmpty()){
         return null;
     } else {
       return stack.get(stack.size()-1);
     }
    }

    public boolean isEmpty(){
       return  stack.size() == 0;
    }

    public void printStack() {
        for(int i =stack.size()-1;i>=0;i--){
            System.out.println(stack.get(i));
        }
    }

        public static void main(String[] args) {

            StackUsingArrayList myStack = new StackUsingArrayList();
            myStack.push(1);
            myStack.push(2);
            myStack.push(3);

            System.out.println(myStack.peek());
            System.out.println("Stack before pop():");
            myStack.printStack();

            System.out.println("\nPopped node:");
            System.out.println(myStack.pop());

            System.out.println("\nStack after pop():");
            myStack.printStack();

        /*
            EXPECTED OUTPUT:
            Stack before pop():
            3
            2
            1

            Popped node:
            3

            Stack after pop():
            2
            1

        */

        }


}
