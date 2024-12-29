package com.company.string;


import java.util.Stack;

public class ReverseString {

public static StringBuilder reverseString(String str){

Stack stack = new Stack();
StringBuilder sb = new StringBuilder();

for (int i=0; i<str.length();i++)
{
    stack.push(str.charAt(i));
}
//  for(int i=0;i<str.length();i++) {
//      char pop = (char) stack.pop();
//      sb.append(pop);
//  }

    while (!stack.isEmpty()){
        sb.append(stack.pop());
    }

 return sb;

}

public static String reverseString2Pointer(String str){
    int start =0, end = str.length()-1;
    char c[] = str.toCharArray();

    while(start<end){
        char temp = str.charAt(start);
        c[start] = c[end];
        c[end] = temp;

        start++;
        end--;

    }

    return new String(c);



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
//
//    public static String reverse(String s){
//    return new StringBuilder(
//              s.chars().mapToObj(c->(char)c)
//                    .collect(Collectors.toList()))
//            .reverse().toString();
//
//
//    }

    public static  String reverseUsingRecursion(String s){

    if(s.isEmpty()){
        return s;
    }
    return reverseUsingRecursion(s.substring(1)) + s.charAt(0);

    }

        public static String reverse(String s) {
            StringBuilder reversed = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                reversed.append(s.charAt(i));
            }
            return reversed.toString();
        }



    public static void main(String[] args) {
        System.out.println(reverseString2Pointer("abcd"));
        System.out.println(reverseString("abcd"));
        System.out.println(reverseUsingRecursion("abcd"));
        System.out.println(reverse("abcd"));
    }
}
