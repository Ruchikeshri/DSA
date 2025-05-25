package com.company.string;

import java.util.HashMap;
import java.util.Map;

public class StringCompress {

    public static int compress(char[] chars) {
        int writeIndex = 0;  // Index to write the compressed characters
        int readIndex = 0;   // Index to read the characters

        while (readIndex < chars.length) {
            char currentChar = chars[readIndex];
            int count = 0;

            // Count occurrences of currentChar
            while (readIndex < chars.length && chars[readIndex] == currentChar) {
                readIndex++;
                count++;
            }

            // Write the character to the writeIndex
            chars[writeIndex++] = currentChar;

            // Write the count if greater than 1
            if (count > 1) {
                for (char digit : Integer.toString(count).toCharArray()) {
                    chars[writeIndex++] = digit;
                }
            }
        }

        return writeIndex;
    }

    public static int compressBruteForce(String s){
        String result = "";
        int count =1;

        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            } else {
                result += s.charAt(i-1) + (count>1 ? String.valueOf(count) : "");
                count =1;
            }
        }
        result+= s.charAt(s.length()-1)+ (count>1 ? String.valueOf(count) :"") ;
//        return result.length()< s.length() ? result : s;
        System.out.println(result);
         return result.length();
    }


    public int compressTwoPointers(char[] chars) {
        int write = 0, count = 1;

        for (int read = 1; read < chars.length; read++) {
            if (chars[read] == chars[read - 1]) {
                count++;
            } else {
                chars[write++] = chars[read - 1];
                if (count > 1) {
                    for (char c : Integer.toString(count).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                count = 1;
            }
        }
        chars[write++] = chars[chars.length - 1];
        if (count > 1) {
            for (char c : Integer.toString(count).toCharArray()) {
                chars[write++] = c;
            }
        }
        return write;
    }
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'}));
        System.out.println(compressBruteForce(String.valueOf(new char[]{'a', 'b', 'b', 'a', 'a'})));
        System.out.println(compressRecursive("aabb",0));
    }

    public static String compressRecursive(String s, int start){
        if(start == s.length()) return "";

        char currentChar = s.charAt(start);
        int newCount =1;
        int index = start+1;

        while (index< s.length() && s.charAt(index) == currentChar){
            newCount++;
            index++;
        }

        return currentChar + (newCount > 1 ? String.valueOf(newCount) : "")+
                compressRecursive(s,index);
    }

    public String compressWithHashMap(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        StringBuilder compressed = new StringBuilder();
        for (char c : freq.keySet()) {
            compressed.append(c).append(freq.get(c));
        }

        return compressed.length() < s.length() ? compressed.toString() : s;
    }

}