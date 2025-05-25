package com.company.backtaring;

import java.util.*;

public class StringPermutationsBruteForce {
    public List<String> getPermutations(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        permute(chars, 0, result);
        return result;
    }

    private void permute(char[] chars, int l, List<String> result) {
        if (l == chars.length) {
            result.add(new String(chars));
            return;
        }
        for (int i = l; i < chars.length; i++) {
            swap(chars, l, i);  // Swap current index with loop index
            permute(chars, l + 1, result); // Recursive call
            swap(chars, l, i);  // Backtrack (undo swap)
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
//        public Set<String> getPermutations(String s) {
//            Set<String> result = new HashSet<>();
////            generatePermutations("", s, result);
//            generatePermutations2("",s,result);
//            return result;
//        }

//    private void generatePermutations2(String s1, String s2, Set<String> result) {
//
//      if(s2.isEmpty()){
//          result.add(s1);
//          return;
//      }
//
//      for(int i=0;i<s2.length();i++){
//         generatePermutations2(s1+s2.charAt(i),
//                 s2.substring(0,i)+s2.substring(i+1),
//                 result);
//      }
//    }

//    private void generatePermutations(String prefix, String remaining, Set<String> result) {
//            if (remaining.isEmpty()) {
//                result.add(prefix); // Store only valid permutations
//                return;
//            }
//            for (int i = 0; i < remaining.length(); i++) {
//                generatePermutations(prefix + remaining.charAt(i),
//                        remaining.substring(0, i) + remaining.substring(i + 1),
//                        result);
//            }
//        }

        public static void main(String[] args) {
            StringPermutationsBruteForce obj = new StringPermutationsBruteForce();
            System.out.println(obj.getPermutations("abc"));
        }
    }

//    public static void main(String[] args) {
//        StringPermutationsBruteForce obj = new StringPermutationsBruteForce();
//        System.out.println(obj.getPermutations("abc"));
//    }
//}


