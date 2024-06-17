package com.company.HashTable;

import java.util.*;


public class GroupAnagrams {
    
    // WRITE GROUPANAGRAMS METHOD HERE // 
    //                                 //
    //                                 //
    //                                 //
    //                                 //
    /////////////////////////////////////
    

        public static List<List<String>> groupAnagrams(String[] strings){
            HashMap<String,List<String>> map = new HashMap<>();
            
            for(String  str : strings){
            char c[] = str.toCharArray();
            
            Arrays.sort(c);
            
            String sortedStr = new String(c);
            
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr,new ArrayList<>());
            }
              
              map.get(sortedStr).add(str);
            }
            return new ArrayList<>(map.values());
            
        }
    public static void main(String[] args) {
        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));

        /*
            EXPECTED OUTPUT:
            ----------------
            1st set:
            [[eat, tea, ate], [tan, nat], [bat]]

            2nd set:
            [[abc, cba, bac], [foo], [bar]]

            3rd set:
            [[listen, silent], [triangle, integral], [garden, ranged]]

        */
        
    }
    
}
