package com.company.string;

public class CharacterCount {
    public static void main(String[] args) {
        String s = "Navat";
        int[] charCount = new int[26]; // 26 letters in the alphabet

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                charCount[c - 'a']++;
            }
        }

        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > 0) {
                System.out.println((char) (i + 'a') + ": " + charCount[i]);
            }
        }
    }

}
