package com.company.DynamicProgramming;

public class LongestPalindromeBottomUp {
    //    public static String longestPalindrome(String s) {
//        int n = s.length();
//        boolean[][] dp = new boolean[n][n];
//        int maxLen = 0;
//        String result = "";
//
//        // Single-character substrings are palindromes
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = true;
//            result = s.substring(i, i + 1);
//        }
//
//        // Two-character substrings
//        for (int i = 0; i < n - 1; i++) {
//            if (s.charAt(i) == s.charAt(i + 1)) {
//                dp[i][i + 1] = true;
//                result = s.substring(i, i + 2);
//            }
//        }
//
//        // Fill DP table for longer substrings
//        for (int len = 3; len <= n; len++) {
//            for (int i = 0; i <= n - len; i++) {
//                int j = i + len - 1;
//                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
//                    dp[i][j] = true;
//                    result = s.substring(i, j + 1);
//                }
//            }
//        }
//
//        return result;
//    }
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 0;
        String longest = "";

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 1 || len == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && len > maxLength) {
                    maxLength = len;
                    longest = s.substring(i, j + 1);
                }
            }
        }
        return longest;
    }

//    public static void main(String[] args) {
//        System.out.println(longestPalindrome("babad")); // Output: "bab" or "aba"
//    }
//}

    public static String longestPalindrom(String s) {
        String res= "";

        for(int i=0;i<s.length();i++){
            String odd = expand(s,i,i);
            String even = expand(s,i,i+1);


            if(odd.length()>res.length()) res =odd;
            if(even.length()>res.length()) res = even;
        }
        return res;
    }

    private static String expand(String s, int i, int j){

        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrom("babad")); // Output: "bab" or "aba"
    }

}