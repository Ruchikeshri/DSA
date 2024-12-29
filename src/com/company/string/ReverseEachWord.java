package com.company.string;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseEachWord {


    public static String reverseWords(String s) {

        int index = 0;
        String[] st = s.trim().split("\\s");
        String result[] = new String[st.length];

        for (int i = st.length - 1; i >= 0; i--) {
            result[index] = st[i];
            index++;
        }
        return String.join(" ", result);
//        return Arrays.toString(result);

    }

    public static void reverseWordsString(String str) {
        String splitStr[] = str.split("\\s");
//        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < splitStr.length; i++) {
            String s = splitStr[i];
            StringBuffer sb = new StringBuffer(s);
            sb.reverse();
            System.out.print(sb + " ");
        }

    }

    public static String reverseWordsStack(String s) {
        Stack<String> stack = new Stack<>();
        String[] words = s.trim().split("\\s+");

        for (String word : words) {
            stack.push(word);
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append(stack.pop());
            if (!stack.isEmpty()) result.append(" "); // Avoid trailing space
        }

        return result.toString();
    }

    public static String reverseWordsUsinghelper(String s) {
        char[] chars = s.trim().toCharArray();
        reverse(chars, 0, chars.length - 1);  // Reverse the whole string

        int start = 0;
        for (int end = 0; end < chars.length; end++) {
            if (chars[end] == ' ') {
                reverse(chars, start, end - 1);  // Reverse each word
                start = end + 1;
            }
        }
        reverse(chars, start, chars.length - 1);  // Reverse the last word

        return new String(chars).replaceAll("\\s+", " ");  // Return with single spaces
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static String reverseWordsQueue(String s) {
        Deque<String> deque = new LinkedList<>();
        String[] words = s.trim().split("\\s+");

        for (String word : words) {
            deque.addFirst(word);
        }

        return String.join(" ", deque);
    }

    public String reverseWords(char[] s) {
        int n = s.length;
        reverse(s, 0, n - 1);  // Reverse the entire array

        int start = 0;
        for (int i = 0; i <= n; i++) {
            if (i == n || s[i] == ' ') {
                reverse(s, start, i - 1);  // Reverse each word
                start = i + 1;
            }
        }

        return new String(s);

}

    public String reverseWordStream(String s) {
        return Arrays.stream(s.trim().split("\\s+"))
                .map(String::trim)
                .filter(str -> !str.isEmpty())
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return String.join(" ", list);
                }));
    }


    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWordsStack("the sky is blue"));
        System.out.println(reverseWordsUsinghelper("the sky is blue"));
        System.out.println(reverseWordsUsinghelper("the sky is blue"));
    }

}
