package com.company.string;




class Solution {

    public static boolean isSubsequence(String s, String t) {

        int start = 0;

        int i = 0;
        while(i<s.length() && start<t.length()) {
            if (s.charAt(i) == t.charAt(start)) {
                i++;
            }
            start++;
        }
        return i == s.length();


    }



    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(isSubsequence("abc","ahbgdc"));
    }

    public static int lengthOfLastWord(String s) {

        String splitStr[] = s.split("\\s+");


        String lastWord = splitStr[splitStr.length - 1];

        return lastWord.length();

    }







}