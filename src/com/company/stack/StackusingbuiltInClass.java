package com.company.stack;

import java.util.Stack;

public class StackusingbuiltInClass {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Top element: " + stack.peek());
        
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
