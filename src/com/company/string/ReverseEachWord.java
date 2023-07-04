package com.company.string;

public class ReverseEachWord {

    public static void reverseWordsString(String str){
        String splitStr[] = str.split("\\s");
//        StringBuffer sb = new StringBuffer();

        for(int i =0;i<splitStr.length;i++){
            String s = splitStr[i];
            StringBuffer sb = new StringBuffer(s);
             sb.reverse() ;
            System.out.print(sb+" ");
        }

    }
}
