package com.company.backtaring;

import java.util.*;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private static void backtrack(List<List<String>> result, List<String> temp, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                temp.add(s.substring(start, end + 1));
                backtrack(result, temp, s, end + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

//    public static void main(String[] args) {
//        System.out.println(partition("aab"));
//        // Output: [["a","a","b"], ["aa","b"]]
//    }


        public static List<List<String>> partitions(String s) {
            List<List<String>> result = new ArrayList<>();
            // Outer loop to start the partitioning from every index in the string
            for (int i = 0; i < s.length(); i++) {
                List<String> temp = new ArrayList<>();
                // Inner loop to check all substrings from index i to the end of the string
                for (int j = i + 1; j <= s.length(); j++) {
                    String substring = s.substring(i, j);
                    // Check if the substring is a palindrome
                    if (isPalindrome(substring)) {
                        // If it's a palindrome, add it to the current partition
                        temp.add(substring);
                        // Continue with the next valid palindrome
                        if (j == s.length()) {
                            result.add(new ArrayList<>(temp));  // Add the current partition to result
                        }
                    }
                }
            }
            return result;
        }

        // Helper method to check if a substring is a palindrome
        private static boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left++) != s.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            System.out.println(partition("aab"));  // Output: [["a", "a", "b"], ["aa", "b"]]
        }
    }



