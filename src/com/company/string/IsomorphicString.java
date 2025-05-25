package com.company.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicString {

    // using two hasMap
    public static boolean isIsomorphic(String s,String p){
        HashMap<Character,Character> mapS = new HashMap<>();
        HashMap<Character,Character> mapP = new HashMap<>();

        if(s.length()!=p.length()) return false;

        for(int i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = p.charAt(i);

            if(mapS.containsKey(c1)) {
                if (mapS.get(c1) != c2) return false;
            } else{
                mapS.put(c1,c2);
            }

            if(mapP.containsKey(c2)){
                if(mapP.get(c2)!=c1) return false;
            } else{
                mapP.put(c2,c1);
            }
        }
            return true;
    }

    //using set
    public static boolean isIsomorphicUsingSet(String s, String p){

        if(s.length()!= p.length())return false;

        Map<Character,Character> map = new HashMap<>();
        Set<Character> mapped = new HashSet<>();

        for(int i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = p.charAt(i);

            if(map.containsKey(c1)){
                if(map.get(c1)!= c2){
                    return false;
                }
            } else{
                if(mapped.contains(c2)) return false;
                map.put(c1,c2);
                mapped.add(c2);
            }
        }
        return true;
    }
// Manual Character Array Mapping:

    public static boolean isIsomorphicUsingArray(String s,String p){
        int mapS[] = new int[256];
        int mapP[] = new int[256];


        for(int i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = p.charAt(i);

            if(mapS[c1] ==0  && mapP[c2]==0){
                mapS[c1] = c2;
                mapP[c2] = c1;
            } else if(mapS[c1]!= c2 || mapP[c2]!=c1) {
                return false;
            }
        }
        return true;

    }
   // Array Index Mapping:
    public static boolean isIsomorphicUsingIndexbasedArray(String s,String p){
        int mapS[] = new int[256];
        int mapP[] = new int[256];

        for(int i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = p.charAt(i);

             if(mapS[c1]!=mapP[c2] || mapP[c2]!=mapS[c1]){
                return false;
            }

            mapS[c1] = i+1;
            mapP[c2] = i+1;
        }
        return true;
    }
//String Matching Using IndexOf:

    public static  boolean isIsomorphicUsingString(String s, String p){
        for(int i=0;i<s.length();i++){
            if(s.indexOf(s.charAt(i)) !=  p.indexOf(p.charAt(i))){
                return false;
            }
        }
        return true;
    }
// Transform and Compare Strings:
    public static boolean isIsomorphicUsingTransform(String s,String p){

        return transform(s).equals(transform(p));

    }

    private static String transform(String s) {
        Map<Character,Integer> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
        map.putIfAbsent(s.charAt(i),i);
        sb.append(map.get(s.charAt(i)));
        sb.append(" ");


        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo","egg"));
        System.out.println(isIsomorphicUsingSet("foo","egg"));
        System.out.println(isIsomorphicUsingArray("foo","egg"));
        System.out.println(isIsomorphicUsingIndexbasedArray("foo","egg"));
        System.out.println(isIsomorphicUsingString("foo","egg"));
        System.out.println(isIsomorphicUsingTransform("foo","egg"));
    }
}
