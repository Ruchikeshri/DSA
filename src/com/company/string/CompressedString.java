package com.company.string;

public class CompressedString {

    public static String compressString(char chars[]) {
        StringBuilder compressed = new StringBuilder();  // To store the compressed result
        int count = 1;  // Initialize count for consecutive characters

        // Loop through the char array starting from the second character
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {  // Check if the current char is the same as the previous one
                count++;  // If same, increment the count
            } else {
                // When the characters are different, append the previous character and its count
                compressed.append(chars[i - 1]).append(count);
                count = 1;  // Reset the count for the new character
            }
        }

        // Append the last character and its count (because the loop doesn't handle the last group)
        compressed.append(chars[chars.length - 1]).append(count);

        // Return the compressed result as a string
        return compressed.length() < chars.length ? compressed.toString() : new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(compressString(new char[]{'a','b','b','c','c','c'}));
    }
}
