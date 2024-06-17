package com.company.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class LongestCommonPrefix {

//    String str = ["flower","flow","flight"]


    public String hasCommonPref(String str[]){
        if(str.length ==0 || str == null){
            return "";
        }
        String pref = str[0];
        for(int i=1;i< str.length;i++){
            int j =str[i].indexOf(pref);
            while(str[i].indexOf(pref)!=0){
                pref = pref.substring(0,pref.length()-1);
            }
        }
        if(pref.isEmpty()){
            return "";
        }
        return pref;
    }

    public String hasCommonPrefix(){
        String str[] =new String[]{"flower","flow","flight"};
        Map <Character, Character> map = new HashMap <>();
        if(str.length ==0 || str == null){
            return "";
        }
        String s1 = Stream.of(str).min(Comparator.comparing(s -> s.length())).get();
        int minLength = Integer.MAX_VALUE;
        for(String s : str){
            minLength = Math.min(minLength,s.length());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i< minLength;i++){
            char c = s1.charAt(i);
            for(int j=0;j< str.length;j++){
                if(str[j].charAt(i) !=s1.charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(c);

        }

        return null;
    }


}
