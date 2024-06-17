package com.company.stack;

import java.util.Arrays;
import java.util.Stack;

public class FindNextGreaterElement {

    public int[] nextGreaterElement(int arr[]) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty()
                        && (stack.peek() <= arr[i])) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        FindNextGreaterElement find = new FindNextGreaterElement();
        System.out.println(Arrays.toString(find.nextGreaterElement(new int[]{4,7,3,4,8,1})));
    }

}