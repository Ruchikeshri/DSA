package com.company.practise;

import java.util.Stack;

public class sol32 {

    public String reverseParentheses(String s) {

        Stack<StringBuilder> stack = new Stack<>();

        StringBuilder currentString = new StringBuilder();

        for(char c : s.toCharArray()){

            if(  c == '(' ){

                stack.push(currentString);
                currentString= new StringBuilder();
            } else if(c ==')') {
                currentString.reverse();
                StringBuilder prevString =  stack.pop();
                prevString.append(currentString);
                currentString = prevString;
            }
            else{
               currentString.append(c);
            }
        }
        return currentString.toString();
    }

    public static void main(String[] args) {
        System.out.println(new sol32().reverseParentheses("(u(love)i)"));
    }
}
