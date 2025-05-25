package com.company.string;

import java.util.HashMap;

public class WordPattern {

        public static boolean wordPattern(String pattern, String s) {

            HashMap<Character,String> mapS = new HashMap<>();
            // HashMap<Character,String> mapP  = new HashMap<>();
            String str[] = s.split("\\s");

            if(str.length!= pattern.length())  return false;

            for(int i=0;i<pattern.length();i++){
                char c = pattern.charAt(i);
                if(mapS.containsKey(c)){
                    if(!mapS.get(c).equals(str[i])) return false;
                } else{
                    mapS.put(c,str[i]);
                }
            }
            return true;
        }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat fish"));
    }
    }

