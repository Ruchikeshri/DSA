package com.company.stack;

import java.util.Stack;

public class Main {

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> auxiliaryStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();  // Step 1
            while (!auxiliaryStack.isEmpty() && auxiliaryStack.peek() > temp) {  // Step 2
                stack.push(auxiliaryStack.pop());  // Step 3
            }
            auxiliaryStack.push(temp);  // Step 4
        }

        // Transfer back the sorted elements from auxiliaryStack to stack
        while (!auxiliaryStack.isEmpty()) {  // Step 5
            stack.push(auxiliaryStack.pop());  // Step 6
        }
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Before sorting:");
        printStack(stack);

        sortStack(stack);

        System.out.println("\nAfter sorting:");
        printStack(stack);
    }

    public static void printStack(Stack<Integer> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }
}