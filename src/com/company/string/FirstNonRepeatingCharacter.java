package com.company.string;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static int firstNonRepeatingCharacter(String str) {
        Map<Character, Integer> characterFrequencyMap = new HashMap<Character, Integer>();
        char c[] = str.toCharArray();
        for(char ch: c){
            characterFrequencyMap.put(ch,characterFrequencyMap.getOrDefault(ch,0)+1);


        }
        for(int i=0;i<c.length;i++){
            char chr = c[i];
            if(characterFrequencyMap.get(chr) == 1){
                return i;
            }
        }
        return -1;
    }
//    public static int lengthOfLongestSubstring(String s) {
//
//        Map<Character,Integer> map = new HashMap<>();
//        char c[] = s.toCharArray();
//        int max =0;
//        for(int i =0,j=0;j<s.length();j++){
//            if(map.containsKey(s.charAt(j)) && map.get(s.charAt(j))>=i){
//                i= map.get(s.charAt(j))+1;
//            }
//            max = Math.max(map.size(),max);
//            map.put(s.charAt(j),j-i+1);
//
//        }
//        return max;
//    }

    public static  int lengthOfLongestSubstring(String str){
        Map<Character,Integer> map = new HashMap<>();
        int i=0;
        int max=0;
        char c[] = new char[3];
        for(int j=0;j<str.length();j++)
        {
            char ch = str.charAt(j);
            if(map.containsKey(ch)){
                i = Math.max(i,map.get(ch)+1);
            }
             map.put(ch,j);
            max = Math.max(max,j-i+1);
//            System.out.println("##############3"+map.values().toArray(new char[map.size()]));
        }
        return max;
    }

}
