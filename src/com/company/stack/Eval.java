package com.company.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Eval {

    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        return evaluate(new LinkedList<>(Arrays.asList(s.replaceAll(" ", "").split(""))));
    }

    private int evaluate(Queue<String> tokens) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        while (!tokens.isEmpty()) {
            String token = tokens.poll();

            if (Character.isDigit(token.charAt(0))) {
//                num = num * 10 + (token.charAt(0) - '0');
                num = num*10 + (token.charAt(0)-'0');
            }

//            if (token.equals("(")) {
//                num = evaluate(tokens); // Recursive call for parentheses
//            }


            if(token.equals("(")){
                num = evaluate(tokens);
            }
            if (!Character.isDigit(token.charAt(0)) || tokens.isEmpty()) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = token.charAt(0);
                num = 0;
            }

            if (token.equals(")")) break; // Stop processing when encountering ')'
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Eval().calculate("3+5 / 2"));
    }
}
