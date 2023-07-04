package com.company.string;


import java.util.Stack;

public class ReverseString {

public StringBuilder reverseString(String str){

Stack stack = new Stack();
StringBuilder sb = new StringBuilder();

for (int i=0; i<str.length();i++)
{
    stack.push(str.charAt(i));
}
  for(int i=0;i<str.length();i++) {
      char pop = (char) stack.pop();
      sb.append(pop);
  }
 return sb;

}

    public String reversedString(String str){

        Stack<Character> stack = new Stack<>();
        char chars[] = str.toCharArray();
        String s1 ="abc";
        for(char c:chars){
            stack.push(c);
        }
        for(int i=0;i<chars.length;i++) {
            chars[i] = stack.pop();
        }
      String s2= s1.concat("cde");
        System.out.println("I have "+s1);
        System.out.println("I have  "+s2);
        return new String(chars);
    }

}
