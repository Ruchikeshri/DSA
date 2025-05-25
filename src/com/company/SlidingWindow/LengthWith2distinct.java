package com.company.SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;

public class LengthWith2distinct {


        public static int lengthOfLongestSubstringTwoDistinct(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int i = 0, j = 0, maxLen = 0,currentLength=0;
            String result = "";

            while (j < s.length()) {
                // Add the current character to the map
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

                // If the window contains more than 2 distinct characters
                while (map.size() > 2) {
                    // Shrink the window from the left
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0) {
                        map.remove(s.charAt(i));  // Remove the character when its count becomes 0

                    }
                    i++;  // Move the left pointer
                }

                // Update the maximum length after the inner loop (after making the window valid)
//                maxLen = Math.max(maxLen, j - i + 1);

                 currentLength = j-i+1;

                if(currentLength> maxLen){
                      maxLen = currentLength;
                    result= s.substring(i,j+1);
                }

                j++;  // Move the right pointer
            }
            System.out.println(result);
            return maxLen;
        }

        public static String[] lengthWithAtmost2SlidingWindow(String s){

            HashMap<Character,Integer> map = new HashMap<>();

            int i=0,j=0,maxLength = Integer.MIN_VALUE;
            String longestString ="";

            while(j<s.length()){

                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);

                while(map.size()>2) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);

                    if (map.get(s.charAt(i))==0) {
                        map.remove(s.charAt(i));


                    }
                    i++;
                }
//                maxLength = Math.max(maxLength,j-i+1);
                int curLen = j-i+1;
                if(curLen>maxLength){
                    maxLength = curLen;
                    longestString = s.substring(i,j+1);
                }

                j++;
            }
            return new String[]{longestString, String.valueOf(maxLength)};

        }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
        String[] res = lengthWithAtmost2SlidingWindow("eceba");

        System.out.println(Arrays.toString(res));

    }

}
