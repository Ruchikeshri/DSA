package com.company.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSubString {

//    public static List<Integer> findSubstring(String s, String[] words) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        int j = 0, i = 0, count = 0;
//        List<String> res = new ArrayList<>();
//        List<Integer> result = new ArrayList<>();
//
//        // Count the frequency of each character in all words
//        for (String st : words) {
//            for (char c : st.toCharArray()) {
//                map.put(c, map.getOrDefault(c, 0) + 1);
//            }
//        }
//
//        count = map.size();  // Number of distinct characters we need to match
//
//        // Sliding window over the string s
//        while (j < s.length()) {
//
//            // If the current character in the string matches a character in the map, update the frequency
//            if (map.containsKey(s.charAt(j))) {
//                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
//
//                // If we match a character exactly, decrement the count
//                if (map.get(s.charAt(j)) == 0) {
//                    count--;
//                }
//            }
//
//            // Check if we have found a valid window
//            if (j - i + 1 == words.length * words[0].length()) { // Window size is the total length of all words
//
//                // If we have matched all the characters, we have found a valid substring
//                if (count == 0) {
//                    result.add(i);
//                }
//
//                // Before moving the window forward, we need to update the map for the character at the start of the window
//                if (map.containsKey(s.charAt(i))) {
//                    // If this character was perfectly matched, we need to increment count
//                    if (map.get(s.charAt(i)) == 0) {
//                        count++;
//                    }
//                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
//                }
//
//                // Move the left pointer of the window forward
//                i++;
//            }
//
//            // Move the right pointer of the window forward
//            j++;
//        }
//
//        return result;
////        HashMap<Character,Integer> map = new HashMap<>();
////        int j=0,i=0,count=0;
////        List res = new ArrayList<>();
////        List result = new ArrayList<>();
////        for(String st : words){
////            for(char c : st.toCharArray()){
////                map.put(c,map.getOrDefault(c,0)+1);
////            }
////        }
////        count = map.size();
////        while(j< s.length()){
////
////            if(map.containsKey(s.charAt(j))){
////                map.put(s.charAt(j),map.get(s.charAt(j))-1);
////                if(map.get(s.charAt(j)) ==0){
////                    count--;
////                }
////            }
////
////            if(map.containsKey(s.charAt(i))){
////                if(count ==0){
////                    res.add(s.substring(i,j+1));
////                    result.add(i);
////                }
////                if(map.containsKey(s.charAt(i))){
////                    if(map.get(s.charAt(i)) ==0){
////                        count++;
////                    }
////                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
////                    i++;
////                }
////
////
////            }
////            j++;
////        }
////        return result;
//    }

        public static List<Integer> findSubstringSliding(String s, String[] words) {
            List<Integer> result = new ArrayList<>();
            if (s == null || s.length() == 0 || words == null || words.length == 0) {
                return result;
            }

            int wordLength = words[0].length();
            int totalWordsLength = words.length * wordLength;
            int n = s.length();

            // Frequency map for the words
            HashMap<String, Integer> wordMap = new HashMap<>();
            for (String word : words) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }

            // Iterate through all word-length offsets (to check all starting positions)
            for (int i = 0; i < wordLength; i++) {
                int left = i, right = i;
                HashMap<String, Integer> seenWords = new HashMap<>();
                int count = 0;

                while (right + wordLength <= n) {
                    // Get the current word from the string
                    String word = s.substring(right, right + wordLength);
                    right += wordLength;

                    // Check if the word is in the wordMap
                    if (wordMap.containsKey(word)) {
                        seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
                        count++;

                        // If the word count exceeds the required frequency, shift the window
                        while (seenWords.get(word) > wordMap.get(word)) {
                            String leftWord = s.substring(left, left + wordLength);
                            seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                            count--;
                            left += wordLength;
                        }

                        // If we found a valid window, add the starting index
                        if (count == words.length) {
                            result.add(left);
                        }
                    } else {
                        // Reset the window if an invalid word is encountered
                        seenWords.clear();
                        count = 0;
                        left = right;
                    }
                }
            }

            return result;
        }



        public static List<Integer> findSubstring(String s, String[] words) {
            // Edge case: if words are empty or string is too short
            if (s == null || s.length() == 0 || words == null || words.length == 0) {
                return new ArrayList<>();
            }

            // Store word frequency in map
            HashMap<String, Integer> wordMap = new HashMap<>();
            for (String word : words) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }

            List<Integer> result = new ArrayList<>();
            int wordLength = words[0].length();  // Length of each word
            int totalWordsLength = wordLength * words.length;  // Total length of all words concatenated

            // Iterate through the string `s` using a sliding window
            for (int i = 0; i <= s.length() - totalWordsLength; i++) {

                // Create a map to track seen words in the current window
                HashMap<String, Integer> seenWords = new HashMap<>();
                int j = 0;

                // Check every word in the current window
                while (j < words.length) {
                    // Extract the word from the current window
                    String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);

                    // If the word is not in the wordMap, break the loop
                    if (!wordMap.containsKey(word)) {
                        break;
                    }

                    // Count the word in the current window
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);

                    // If this word appears more times than it should, break the loop
                    if (seenWords.get(word) > wordMap.get(word)) {
                        break;
                    }

                    j++;
                }

                // If all words are matched correctly, add the starting index `i` to the result
                if (j == words.length) {
                    result.add(i);
                }
            }

            return result;
        }


    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman",new String[]{"foo","bar"}));
        System.out.println(findSubstringSliding("barffoothefoobarman",new String[]{"foo","bar"}));
    }
}
