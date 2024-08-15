package com.company.stack;

import java.util.Stack;

class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack();
        int longest = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    longest = Math.max(longest, i - stack.peek());// [-1,0,1] 2- 1 =1 valid one parenethesis
                }

            }
        }
        return longest;

    }
    public static void main(String[] args) {
        LongestValidParenthesis solution = new LongestValidParenthesis();
        System.out.println(solution.longestValidParentheses(")()())"));
    }
}