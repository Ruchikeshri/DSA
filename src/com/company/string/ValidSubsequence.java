package com.company.string;

public class ValidSubsequence {

    public boolean isSubSeq(String str, String seq){
        int i=0,j=0;
        while (i<str.length() && j<seq.length()){
            if(str.charAt(i)== seq.charAt(j)){
                j++;
            }
            i++;
        }
        return j==seq.length();
    }
}
