package com.company.string;

public class HasUniqueUsingArray {

    public static boolean hasUniqueChars(String str){
        boolean charSet[] = new boolean[256];
        if(str.length() >256){
            return false;
        }
        for(int i=0;i< str.length();i++){
            int c = str.charAt(i);
            if(charSet[c]){
                return false;
            }
            charSet[c] = true;
        }
    return  true;
    }



    public static void main(String[] args) {
        System.out.println(hasUniqueChars("abcde")); // true
        System.out.println(hasUniqueChars("hello")); // false
        System.out.println(hasUniqueChars("world")); // true
    }

}


