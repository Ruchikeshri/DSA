package com.company.HashTable;

public class canConstruct {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int count[] = new int[256];

        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String ransomNote1 = "a";
        String magazine1 = "b";
        System.out.println(canConstruct(ransomNote1, magazine1)); // Output: false

        // Test Case 2

        String ransomNote3 = "aa";
        String magazine3 = "aab";
        System.out.println(canConstruct(ransomNote3, magazine3));
    }
}