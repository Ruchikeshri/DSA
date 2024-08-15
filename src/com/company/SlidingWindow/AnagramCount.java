package com.company.SlidingWindow;

import com.sun.source.tree.WhileLoopTree;

import java.util.*;

public class AnagramCount {


    public static List<String> findAnagramsBruteForce(String s, String ptr){
        int pLength = ptr.length();
        int sLength = s.length();
        List<String> result = new ArrayList<>();
        char[] pArray = ptr.toCharArray();

        Arrays.sort(pArray);
//        String sortedStr = new String(pArray);

        for(int i=0;i<sLength-pLength;i++){
          String subString = s.substring(i,i+pLength);
          char[] subStringarr =subString.toCharArray();
          Arrays.sort(subStringarr);
          String anagramStr = new String(subStringarr);
//          if(sortedStr.equals(anagramStr))
          if(Arrays.equals(subStringarr,pArray)){
              result.add(subString);
          }
        }

return result;

    }



    public static List<String> findAnagrams(String s, String ptr){

        Map<Character,Integer> charFreq = new HashMap<>();
        for(char c : ptr.toCharArray()){
            charFreq.put(c,charFreq.getOrDefault(c,0)+1);
        }
        int count =charFreq.size();
        int i=0,j=0,k = ptr.length();

        List<String> result = new ArrayList<>();
        int ans=0;
        while(j<s.length()){
            if(charFreq.containsKey(s.charAt(j))){
                charFreq.put(s.charAt(j),charFreq.get(s.charAt(j))-1);
                if(charFreq.get(s.charAt(j)) == 0){
                    count--;
                }

            }
            if(j-i+1==k){

                if(count ==0){
                    ans+= 1;
                    result.add(s.substring(i,j+1));
                }
                if(charFreq.containsKey(s.charAt(i))){
                    if(charFreq.get(s.charAt(i)) == 0){
                        count++;
                    }

                    charFreq.put(s.charAt(i),charFreq.get(s.charAt(i))+1);
                }
                i++;

            }
            j++;
        }
        System.out.println(ans);
        return result;
    }


    private static List<String> findAnagramUsingCount(String s, String p) {
     int sCount[] = new int[26];
     int pCount[] = new int[26];

     List<String> result = new ArrayList<>();

     for(int i=0;i<p.length();i++){
         pCount[p.charAt(i) - 'a']++;
         sCount[s.charAt(i)-'a']++;

     }

        if(matches(pCount,sCount)){
            result.add(s.substring(0,p.length()));
        }

     for(int i=p.length();i<s.length();i++){
         sCount[s.charAt(i)-'a']++;
         sCount[s.charAt(i-p.length())-'a']--;
         if(matches(pCount,sCount)){
             result.add(s.substring(i-p.length()+1,i+1));
         }
     }
        return result;
     }

    private static boolean matches(int[] pCount, int[] sCount) {
        for(int i=0;i<26;i++){
            if(pCount[i]!=sCount[i]){
                return false;
            }
        }
        return true;
    }

    public static List<String> findAnagramsUsingEquals(String s,String P){
        List<String> result = new ArrayList<>();

        int pCount[] = new int[26];
        int sCount[] = new int[26];

        for(int i=0;i<P.length();i++){
           sCount[s.charAt(i)-'a']++;
           pCount[P.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length()-P.length();i++){
            if(Arrays.equals(pCount,sCount)){
                result.add(s.substring(i,i+P.length()));
            }
            sCount[s.charAt(i+P.length())-'a']++;
            sCount[s.charAt(i)-'a']--;

        }
        if(Arrays.equals(pCount,sCount)){
            result.add(s.substring(s.length()-P.length()));
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p ="abc";
        List<String> anagram = findAnagrams(s,p);
//        List<String> anagrams =    findAnagramsBruteForce(s,p);
        List<String> anagrams = findAnagramUsingCount(s,p);
        System.out.println("Anagram Found: "+anagram);
        System.out.println("Anagram Found: "+anagrams);
//        System.out.println("Angaram Found",+ana);

    }



}

