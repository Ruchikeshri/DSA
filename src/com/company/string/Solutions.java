package com.company.string;

class LongestPalindrome {

    public static boolean isPalindrome(StringBuffer s, int start, int end) { //abba
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static String longestPalindrome(String s) {

        String str = "";

//        int longestPalin = 0;

//        for (int start = 0; start < s.length() - 1; start++) {
//            s = s.substring(start);
//            StringBuffer sb = new StringBuffer();
//            for (char i : s.toCharArray()) {
//                sb.append(i);
//                if (isPalindrome(sb, 0, sb.length() - 1)) {
//                    longestPalin = Math.max(longestPalin, str.length());
//                    if (str.length() < sb.length()) {
//                        str = sb.toString();
//                    }
//                }
//            }
//        }
//        return str;
        StringBuffer sb = new StringBuffer();
        String longestPalin = "";
        int maxLength = 0;

        for (char c : s.toCharArray()) {
            sb.append(c);
            for (int start = 0; start < sb.length(); start++) {
                if (isPalindrome(sb, start, sb.length() - 1)) {
                    int currentLength = sb.length() - start;
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                        longestPalin = sb.substring(start, sb.length());
                    }
                }
            }
        }
        return longestPalin;


    }

//    public static void main(String[] args) {
//        System.out.println(longestPalindrome("abaabba"));
//    }

//    public class ExpandAroundCenterPalindrome {
        public static String longestPalindromes(String s) {
            if (s == null || s.length() == 0) return "";

            String longest = "";
            for (int i = 0; i < s.length(); i++) {
                // Odd length palindromes
                String odd = expandAroundCenter(s, i, i);
                if (odd.length() > longest.length()) {
                    longest = odd;
                }

                // Even length palindromes
                String even = expandAroundCenter(s, i, i + 1);
                if (even.length() > longest.length()) {
                    longest = even;
                }
            }
            return longest;
        }

        private static String expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return s.substring(left + 1, right);
        }

        public static void main(String[] args) {
            System.out.println(longestPalindrome("babad")); // Outputs "bab" or "aba"
        }
    }

