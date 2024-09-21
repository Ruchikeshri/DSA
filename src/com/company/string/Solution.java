package com.company.string;

class Solution {
    public static String mergeAlternately(String word1, String word2) {

     int lastIndex =0;
     StringBuilder sb = new StringBuilder();
        for(int i=0;i<Math.min(word1.length(),word2.length());i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            lastIndex =i;
        }
           lastIndex++;
        if(word1.length()>word2.length()){
            sb.append(word1.substring(lastIndex));
        } else {
            sb.append(word2.substring(lastIndex));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc","pqrs"));
    }
}