package com.company.SlidingWindow;

import java.util.*;

public class MaxVowelVariable {

        public int countVowelSubstrings(String word) {
            return atMost(word,5) - atMost(word,4);
        }



        public int atMost(String word,int k){
            int i=0,j=0,countVowel=0;

            HashMap<Character,Integer>  map = new HashMap<>();


            while(j<word.length()){


                if(isVowel(word.charAt(j))){
                    map.put(word.charAt(j), map.getOrDefault(word.charAt(j),0)+1);


                    while(map.size()>k){

                        if(isVowel(word.charAt(i))){

                            map.put(word.charAt(i),map.get(word.charAt(i))-1);

                            if(map.get(word.charAt(i)) ==0){
                                map.remove(word.charAt(i));
                            }
                        }
                        i++;

                    }


                    if(map.size() ==k){
                        countVowel += (j - i + 1);
                    }
                } else {
                    i = j+1;
                    map.clear();
                }
                j++;

            }
            return countVowel;
        }

        public boolean isVowel(char c){
            return "aeiou".indexOf(c) !=-1;
        }
    }
//    public int countVowelSubstrings(String word) {
//
//        int totalCount = 0; // Total count of valid vowel substrings
//        int i = 0, j = 0; // Pointers for the sliding window
//        Map<Character, Integer> map = new HashMap<>(); // To track counts of vowels
//        List<String> validSubstrings = new ArrayList<>(); // To store valid substrings
//
//        while (j < word.length()) {
//            // If the current character is a vowel
//            if (isVowel(word.charAt(j))) {
//                // Update the frequency of the vowel
//                map.put(word.charAt(j), map.getOrDefault(word.charAt(j), 0) + 1);
//
//                // Check if we have all five vowels
//                while (map.size() ==5) {
//                    // Add the valid substring from i to j (inclusive)
//                    validSubstrings.add(word.substring(i, j + 1)); // Collect valid substrings
//                    totalCount +=1; // Count all substrings from i to j, then to the end
//                     if(isVowel(word.charAt(j+1))){
//                         j++;
//                         map.put(word.charAt(j), map.getOrDefault(word.charAt(j), 0) + 1);
//                     }else {
//                         // Shrink the window by moving 'i' forward
//
//                         if(isVowel(word.charAt(j-1))){
//                             j--;
////                             map.put(word.charAt(j), map.getOrDefault(word.charAt(j), 0) + 1);
//                         } else {
//                             map.put(word.charAt(i), map.get(word.charAt(i)) - 1);
//                             if (map.get(word.charAt(i)) == 0) {
//                                 map.remove(word.charAt(i)); // Remove the vowel if count becomes zero
//                             }
//
//                         }
//
//                     }
//                    i++; // Move the start of the window forward
//
//                }
//            } else {
//                // If the character is not a vowel, reset the map and move i and j
//                map.clear();
//                i = j + 1; // Move start index to the next position after non-vowel
//            }
//            j++; // Move end index
//        }
//
//        // Print the valid substrings
//        System.out.println("Valid substrings: " + validSubstrings);
//
//        return totalCount; // Return the total count of valid substrings
//    }
//
//    // Helper function to check if a character is a vowel
//    public boolean isVowel(char c) {
//        return "aeiou".indexOf(c) != -1; // Check if character is a vowel
//    }
//
//    public static void main(String[] args) {
//            MaxVowelVariable max = new MaxVowelVariable();
//            System.out.println(max.countVowelSubstrings("cuaieuouac"));
//        }


