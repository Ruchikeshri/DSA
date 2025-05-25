package com.company.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindowSubString {

    public static String minWindowSubString(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0, count = 0, minWindow = Integer.MAX_VALUE;
        String res = "";

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        count = map.size();

        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0) {
                    count--;
                }
            }

            while (count == 0) {
                int currentWindow = j - i + 1;
                if (currentWindow < minWindow) {
                    minWindow = currentWindow;
                    res = s.substring(i, j + 1);
                }

                if (map.containsKey(s.charAt(i))) {
                    if (map.get(s.charAt(i)) == 0) {
                        count++;
                    }

                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                }
                i++;
            }
            j++;
        }
        return res;
    }

    public static int lengthOfLongestSubstring(String s) {


        int i = 0, j = 0, count = 0;

        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {

            if (map.containsKey(s.charAt(j))) {
                // Move `i` to the farthest valid position
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }

            char c = s.charAt(j);
            map.put(c, j);



            maxLength = Math.max(maxLength, j - i + 1);

            j++;
        }

        return maxLength;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int i = 0, j = 0, maxLength = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            char endChar = s.charAt(j);

            // If a duplicate is found, remove characters from the left
            while (set.contains(endChar)) {
                set.remove(s.charAt(i));
                i++;
            }

            set.add(endChar);
            maxLength = Math.max(maxLength, j - i + 1); // Update max length
            j++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
//        System.out.println(minWindowSubString("ADOBECODEBANC","ABC"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));


    }
}
