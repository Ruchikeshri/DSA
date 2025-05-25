package com.company.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class maxVowels {


    public static int maxVowelsSlidingWindow(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int i=0,j=0,count =0,maxVowelCount=0;
        int maxLength = 0;
        String result = "";

        while (j< s.length()){
            if(isVowel(s.charAt(j))){
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                count++;
            }

            // oroblem is difffrent not this
//            while(j-i+1>k){
//                if(isVowel(s.charAt(i))){
//                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
//                    if(map.get(s.charAt(i)) == 0){
//                        map.remove(s.charAt(i));
//                    }
//                    count--;
//                }
//                i++;
//
//            }
//            maxLength = Math.max(maxLength,j-i+1);

            if(j-i+1 ==k){


//                maxVowelCount = Math.max(maxVowelCount,count);

                if(maxVowelCount<count){
                    maxVowelCount =count;
                    result = s.substring(i,j+1);
                }

                if(isVowel(s.charAt(i))){
                    map.put(s.charAt(i), map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i)) == 0){
                        map.remove(s.charAt(i));
                    }
                    count--;
                }
                i++;
            }
            j++;
        }
        System.out.println(result);
        return maxVowelCount;
    }

    public static boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c =='o' || c == 'u') return true;
        return false;
    }

    public static int maxVowelsBruteForce(String s, int k) {
        int maxVowelCount = 0;

        // Iterate through every possible starting index for a substring of length k
//        for (int i = 0; i <= s.length() - k; i++) {
//            int currentVowelCount = 0;
//
//            // For each starting index, check the substring of length k
//            for (int j = i; j<i+k; j++) {
//                if (isVowel(s.charAt(j))) {
//                    currentVowelCount++;
//                }
//            }
        for(int i=0;i<=s.length();i++){
            int currentVowelCount =0;

            for(int j=i;j<i+k;j++){
                if(isVowel(s.charAt(j)));
                currentVowelCount++;
            }

            // Update the max vowel count if this substring has more vowels
            maxVowelCount = Math.max(maxVowelCount, currentVowelCount);
        }

        return maxVowelCount;
    }


// this is not right appparoch and qalo wrong answr
    public static int maxVowels(String s, int k) {

//         //The inner while loop in your approach is checking conditions to shrink the window, but since the window size is fixed, shrinking it would unnecessarily reduce the length of the window.
// There's no need to remove elements from the window or shrink it to match the target size since the outer loop is already ensuring that the window size is exactly k.


         Map<Character, Integer> map = new HashMap<>();
         int i=0,j=0,count =0;
         int maxVowelSubCount = 0;

         while (j< s.length()){
             if(isVowel(s.charAt(j))){
                 map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                 count++;
             }

             while(count>k){
                 if(isVowel(s.charAt(i))){
                  map.put(s.charAt(i),map.get(s.charAt(i))-1);

                  if(map.get(s.charAt(i)) ==0){
                     map.remove(s.charAt(i));
                  }

                     count--;
                 }
                 i++;

             }
             maxVowelSubCount = Math.max(maxVowelSubCount,j-i);
             j++;
         }
         return maxVowelSubCount;
    }

    public static int maxVowelSliding2(String s,int k){
        int i=0,j =0,vowelCount=0,maxVowelCount=0;

        while (j<s.length()){

            if(isVowel(s.charAt(j))){
                vowelCount++;
            }

            if(j-i+1==k){
                maxVowelCount = Math.max(vowelCount,maxVowelCount);
                if(isVowel(s.charAt(i))){
                    vowelCount--;
                }
                i++;
            }

            j++;

        }
        return maxVowelCount;
    }

    public static void main(String[] args) {
//        System.out.println(maxVowelsSlidingWindow("abciiidef",3));
        System.out.println(maxVowelsSlidingWindow("abciiidef",3));
        System.out.println(maxVowelSliding2("abciiidef",3));

    }
}
