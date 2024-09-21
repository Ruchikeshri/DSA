package com.company.string;

public class ValidSubsequence {

    public static  boolean isSubSeq(String str, String seq){
        int i=0,j=0;
        while (i<str.length() && j<seq.length()){
            if(str.charAt(i) == seq.charAt(j)){
                j++;
            }
            i++;
        }
        return j==seq.length();
    }

    public static boolean isSubsequence(String s, String t) {
        if(s.isEmpty()) return  true;
        int start =0,j=0;
        for(int i=0;i<t.length();i++){

            if(j<s.length() && s.charAt(start) == t.charAt(i)){
                start++;
            }
        }
        return start == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubSeq("","abfdc"));
    }
}
