package com.company.bitManipulation;

public class UniqueCharUsingBitManipulation {

    public static boolean hasUniqueChars(String str){
        int checker =0;

        for(int i=0;i< str.length();i++){
           int val = str.charAt(i) -'a';
           if((checker & (1<<val))>0){
               return false;
           }
            checker|= 1<<val;
        }

        return  true;
    }
    public static void main(String[] args) {
        System.out.println(hasUniqueChars("abcde")); // true
        System.out.println(hasUniqueChars("hello")); // false
        System.out.println(hasUniqueChars("world")); // true
    }
}
