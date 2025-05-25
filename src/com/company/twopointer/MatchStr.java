package com.company.twopointer;

public class MatchStr {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        int start=0 ,end = n;
        int index=0;

        while(start<=m-n){
            if( haystack.substring(start,end).equals(needle)) {
                return start;
            }
            start++;
            end++;

        }

        return start;

    }


    public int[] strStr2Poin(String haystack, String needle) {
        if (needle.isEmpty()) {
            return new int[]{0, 0}; // Return [0, 0] if needle is empty
        }

        int m = haystack.length();
        int n = needle.length();

        if (n > m) {
            return new int[]{-1, -1}; // If needle is longer than haystack, return [-1, -1]
        }

        int i = 0, j = 0; // i for haystack, j for needle
        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1; // Reset `i` to the next possible starting point
                j = 0; // Reset `j`
            }

            // If the needle is fully matched
            if (j == n) {
                return new int[]{i - n, i - 1}; // Return start and end index
            }
        }

        return new int[]{-1, -1}; // If no match found
    }

    public int[] strStrB(String haystack, String needle) {
        if (needle.isEmpty()) {
            return new int[]{0, 0}; // Return [0, 0] if needle is empty
        }

        int m = haystack.length();
        int n = needle.length();

        if (n > m) {
            return new int[]{-1, -1}; // If needle is longer than haystack, return [-1, -1]
        }

        // Brute force: Check each starting position in haystack
//        for (int i = 0; i <= m - n; i++) {
//            int j = 0;
//            while (j < n && haystack.charAt(i + j) == needle.charAt(j)) {
//                j++;
//            }
//            if (j == n) {
//                return new int[]{i, i + n - 1}; // Return start and end index
//            }
//        }


        for(int i=0; i<= m-n ;i++){
            int j =0;

            while (j<n && haystack.charAt(i+j) == needle.charAt(j)){
                j++;
            }
            if(j == n){
                return new int[]{i,i+n -1};
            }
        }

        return new int[]{-1, -1}; // If no match found
    }


    public int  matchStrSlidingWindow(String s, String t){
        int m = s.length(), n = t.length();

        if(n>m) return  -1;

        for(int i=0;i<= m-n;i++){
            if(s.substring(i,i+n).equals(t)){

//                int end = i+n-1;
                return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        MatchStr str = new MatchStr();
//        System.out.println(str.strStr("sadbutsad","adb"));
        System.out.println(str.matchStrSlidingWindow("sadbutsad","adb"));
        System.out.println(str.strStr2Poin("sadbutsad","sadb"));

    }
}
