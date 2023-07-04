package com.company.string;

import java.util.Arrays;
import java.util.Locale;

public class Anagram {

    public void anagram(String s1, String s2) {

        s1 = s1.replaceAll("\\s","").toLowerCase();
        s2 = s2.replaceAll("\\s","").toLowerCase();
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        boolean isAnagram = true;

        int[] frequencyChar = new int[256];

        if(s1.length() != s2.length()){
            isAnagram = false;
        }

        for (int i = 0; i < c1.length; i++) {
            frequencyChar[c1[i]]++;
        }

        for (int i = 0; i < c2.length; i++) {
            frequencyChar[c2[i]]--;
        }


        for (int i : frequencyChar) {
            if (i != 0) {
                isAnagram = false;
            }
        }
        if(isAnagram){
            System.out.println("it is anagram");
        }
        else{
            System.out.println("not a anagram");
        }
    }

    boolean isAngaram2(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        Arrays.sort(s1.toLowerCase().toCharArray());
        Arrays.sort(s2.toLowerCase().toCharArray());

         boolean isAanagram = Arrays.equals(s1.toCharArray(),s2.toCharArray());
         if(isAanagram){
             System.out.println("strings are an Anagram");
         }else {
             System.out.println("not an anagram");
         }
        return  true;
    }
}

